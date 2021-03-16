package com.example.spring.solr.repository;

import com.example.spring.solr.model.Image;
import org.springframework.data.solr.repository.SolrCrudRepository;

public interface ImageRepository extends SolrCrudRepository<Image, Long> {
}
