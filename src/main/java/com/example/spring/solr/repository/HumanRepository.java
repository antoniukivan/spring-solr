package com.example.spring.solr.repository;

import com.example.spring.solr.model.Human;
import org.springframework.data.solr.repository.SolrCrudRepository;

public interface HumanRepository extends SolrCrudRepository<Human, Long> {
}
