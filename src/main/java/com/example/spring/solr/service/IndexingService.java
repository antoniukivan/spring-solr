package com.example.spring.solr.service;

import com.example.spring.solr.model.Entity;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IndexingService {
    private final StrategyService strategyService;

    public void indexing(List<? extends Entity> entities) {
        Map<Class<? extends Entity>, SolrCrudRepository> strategies = strategyService.getStrategies();
        for (Class<? extends Entity> clazz : strategies.keySet()) {
            List<Entity> entityList = entities.stream()
                    .filter(x -> x.getClass().equals(clazz))
                    .collect(Collectors.toList());
            if (!entityList.isEmpty()) {
                strategies.get(clazz).saveAll(entityList);
            }
        }
    }
}
