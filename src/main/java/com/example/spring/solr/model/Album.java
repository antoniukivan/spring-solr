package com.example.spring.solr.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SolrDocument(collection = "Album")
public class Album implements Entity {
    @Id
    @Field
    private Long id;
    @Field
    private Human author;
    @Field
    private Image[] photos;
}
