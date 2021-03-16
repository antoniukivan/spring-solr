package com.example.spring.solr.service;

import com.example.spring.solr.model.Album;
import com.example.spring.solr.model.DataFile;
import com.example.spring.solr.model.Entity;
import com.example.spring.solr.model.Human;
import com.example.spring.solr.model.Image;
import com.example.spring.solr.model.Preview;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.xml.crypto.Data;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Service;

@Service
public class IndexingService {
    private final StrategyService strategyService;
    private final List<String> collections = new ArrayList<>();

    public IndexingService(StrategyService strategyService) {
        this.strategyService = strategyService;
        createCollections();
    }

    public void indexing(List<? extends Entity> entities) {

    }

    private void createCollections() {
        collections.add("Album");
        collections.add("DataFile");
        collections.add("Image");
        collections.add("Human");
        collections.add("Preview");
    }
}
