package com.example.spring.solr.config;

import com.example.spring.solr.util.Converters;
import java.util.ArrayList;
import java.util.List;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.ConcurrentUpdateSolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.convert.CustomConversions;
import org.springframework.data.solr.core.convert.MappingSolrConverter;
import org.springframework.data.solr.core.convert.SolrConverter;
import org.springframework.data.solr.core.mapping.SimpleSolrMappingContext;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@Configuration
@EnableSolrRepositories(
        basePackages = "com.example.spring.solr.repository")
@ComponentScan
public class ApplicationConfig {
    @Value("${spring.data.solr.host}")
    private String baseUrl;

    @Bean
    public CustomConversions customConversions() {
        final List<Object> converters = new ArrayList<>();
        converters.add(Converters.EntityToStringConverter.INSTANCE);
        converters.add(Converters.StringToAlbumConverter.INSTANCE);
        converters.add(Converters.StringToDataFileConverter.INSTANCE);
        converters.add(Converters.StringToHumanConverter.INSTANCE);
        converters.add(Converters.StringToImageConverter.INSTANCE);
        converters.add(Converters.StringToPreviewConverter.INSTANCE);
        return new CustomConversions(converters);
    }

    @Bean
    public SolrClient solrClient() {
        return new HttpSolrClient.Builder(baseUrl).build();
    }

    @Bean
    public SolrTemplate solrTemplate(SolrClient client) {
        SolrTemplate solrTemplate = new SolrTemplate(client);
        solrTemplate.setSolrConverter(mappingSolrConverter());
        return solrTemplate;
    }

    @Bean
    public SolrConverter mappingSolrConverter() {
        final MappingSolrConverter converter = new MappingSolrConverter(new SimpleSolrMappingContext());
        converter.setCustomConversions(customConversions());
        return converter;
    }
}
