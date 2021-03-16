package com.example.spring.solr.service;

import com.example.spring.solr.Util;
import com.example.spring.solr.model.Entity;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IndexingServiceTest {
    @Autowired
    private IndexingService indexingService;

    private static List<? super Entity> entities;

    @BeforeAll
    static void beforeAll() {
        createEntities();
    }

    @Test
    void indexing() {
        long startIndexingService = System.currentTimeMillis();
//        indexingService.indexing();
        long endIndexingService = System.currentTimeMillis();


    }

    private static void createEntities() {
        entities = new ArrayList<>();
        entities.add(Util.createAlbums());
        entities.add(Util.createDataFiles());
        entities.add(Util.createHumans());
        entities.add(Util.createImages());
        entities.add(Util.createPreviews());
    }
}