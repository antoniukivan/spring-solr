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
@SolrDocument(collection = "Human")
public class Human implements Entity {
    @Id
    @Field
    private Long id;
    @Field
    private String name;
    @Field
    private String surname;
    @Field
    private String login;
    @Field
    private String mail;
    @Field
    private String[] roles;
    @Field
    private Image avatar;
}

