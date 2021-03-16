package com.example.spring.solr.repository;

import com.example.spring.solr.model.Preview;
import org.springframework.data.solr.repository.SolrCrudRepository;

public interface PreviewRepository extends SolrCrudRepository<Preview, Long> {
}
