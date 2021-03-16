package com.example.spring.solr.service;

import com.example.spring.solr.model.Album;
import com.example.spring.solr.model.DataFile;
import com.example.spring.solr.model.Entity;
import com.example.spring.solr.model.Human;
import com.example.spring.solr.model.Image;
import com.example.spring.solr.model.Preview;
import com.example.spring.solr.repository.AlbumRepository;
import com.example.spring.solr.repository.DataFileRepository;
import com.example.spring.solr.repository.HumanRepository;
import com.example.spring.solr.repository.ImageRepository;
import com.example.spring.solr.repository.PreviewRepository;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StrategyService {
    private final ImageRepository imageRepository;
    private final HumanRepository humanRepository;
    private final AlbumRepository albumRepository;
    private final DataFileRepository dataFileRepository;
    private final PreviewRepository previewRepository;

    public Map<Class<? extends Entity>, SolrCrudRepository> getStrategies() {
        Map<Class<? extends Entity>, SolrCrudRepository> strategies = new HashMap<>();
        strategies.put(Image.class, imageRepository);
        strategies.put(Human.class, humanRepository);
        strategies.put(Album.class, albumRepository);
        strategies.put(DataFile.class, dataFileRepository);
        strategies.put(Preview.class, previewRepository);
        return strategies;
    }
}
