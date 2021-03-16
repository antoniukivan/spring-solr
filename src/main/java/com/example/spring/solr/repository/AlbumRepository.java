package com.example.spring.solr.repository;

import com.example.spring.solr.model.Album;
import org.springframework.data.solr.repository.SolrCrudRepository;

public interface AlbumRepository extends SolrCrudRepository<Album, Long> {
}
