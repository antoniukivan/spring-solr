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
@SolrDocument(collection = "DataFile")
public class DataFile implements Entity {
    @Id
    @Field
    private Long id;
    @Field
    private Human uploader;
    @Field
    private String contentType;
    @Field
    private String originalName;
    @Field
    private String url;
    @Field
    private String pod;
    @Field
    private long filesize;
}
