package com.example.spring.solr.repository;

import com.example.spring.solr.model.DataFile;
import org.springframework.data.solr.repository.SolrCrudRepository;

public interface DataFileRepository extends SolrCrudRepository<DataFile, Long> {
}
