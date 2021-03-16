package com.example.spring.solr.service;

import com.example.spring.solr.model.Album;
import com.example.spring.solr.model.DataFile;
import com.example.spring.solr.model.Entity;
import com.example.spring.solr.model.Human;
import com.example.spring.solr.model.Image;
import com.example.spring.solr.model.Preview;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.stereotype.Service;

@Service
public class IndexingService {
    private final SolrClient solrClient;
    private final Map<String, Class<?>> collections = new HashMap<>();

    public IndexingService(SolrClient solrClient) {
        this.solrClient = solrClient;
        createCollections();
    }

    public void indexing(List<? extends Entity> entities) {
        for (Map.Entry<String, Class<?>> entry : collections.entrySet()) {
            try {
                List<? extends Entity> list = entities
                        .stream()
                        .filter(x -> x.getClass().equals(collections.get(entry.getKey())))
                        .collect(Collectors.toList());
                if (!list.isEmpty()) {
                    solrClient.addBeans(entry.getKey(), list);
                }
            } catch (SolrServerException | IOException e) {
                throw new RuntimeException("Couldn't save all beans", e);
            }
        }
    }

    private void createCollections() {
        collections.put("Album", Album.class);
        collections.put("DataFile", DataFile.class);
        collections.put("Image", Image.class);
        collections.put("Human", Human.class);
        collections.put("Preview", Preview.class);
    }
}
