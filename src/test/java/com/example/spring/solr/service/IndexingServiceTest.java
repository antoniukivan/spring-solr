package com.example.spring.solr.service;

import com.example.spring.solr.Util;
import com.example.spring.solr.model.Album;
import com.example.spring.solr.model.DataFile;
import com.example.spring.solr.model.Entity;
import com.example.spring.solr.model.Human;
import com.example.spring.solr.model.Image;
import com.example.spring.solr.model.Preview;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IndexingServiceTest {
    @Autowired
    private IndexingService indexingService;

    @Autowired
    private SolrClient solrClient;

    private static List<Entity> entities;

    @BeforeAll
    static void beforeAll() {
        createEntities();
    }

    @Test
    void indexing() {
        long startIndexingService = System.currentTimeMillis();
        indexingService.indexing(entities);
        long endIndexingService = System.currentTimeMillis();
        long serviceTime = endIndexingService - startIndexingService;

        long startAddBeansBySolrClient = System.currentTimeMillis();
        try {
            solrClient.addBeans("Album", entities.stream().filter(x -> x.getClass().equals(Album.class))
                    .collect(Collectors.toList()));
            solrClient.addBeans("Human", entities.stream().filter(x -> x.getClass().equals(Human.class))
                    .collect(Collectors.toList()));
            solrClient.addBeans("DataFile", entities.stream().filter(x -> x.getClass().equals(DataFile.class))
                    .collect(Collectors.toList()));
            solrClient.addBeans("Image", entities.stream().filter(x -> x.getClass().equals(Image.class))
                    .collect(Collectors.toList()));
            solrClient.addBeans("Preview", entities.stream().filter(x -> x.getClass().equals(Preview.class))
                    .collect(Collectors.toList()));
        } catch (SolrServerException | IOException e) {
            throw new RuntimeException("Couldn't save all beans", e);
        }
        long endAddBeansBySolrClient = System.currentTimeMillis();
        long solrClientTime = endAddBeansBySolrClient - startAddBeansBySolrClient;

        System.out.println(serviceTime);
        System.out.println(solrClientTime);
    }

    private static void createEntities() {
        entities = new ArrayList<>();
        entities.addAll(Util.createAlbums());
        entities.addAll(Util.createDataFiles());
        entities.addAll(Util.createHumans());
        entities.addAll(Util.createImages());
        entities.addAll(Util.createPreviews());
    }
}
