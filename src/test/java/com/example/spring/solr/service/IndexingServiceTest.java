package com.example.spring.solr.service;

import com.example.spring.solr.Util;
import com.example.spring.solr.model.Entity;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IndexingServiceTest {
    @Autowired
    private IndexingService indexingService;

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

        long serviceTime = (endIndexingService - startIndexingService) / entities.size() * 10;

        Assertions.assertTrue(serviceTime < 1);
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
