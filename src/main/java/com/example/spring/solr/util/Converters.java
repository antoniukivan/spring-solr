package com.example.spring.solr.util;

import com.example.spring.solr.model.Album;
import com.example.spring.solr.model.DataFile;
import com.example.spring.solr.model.Entity;
import com.example.spring.solr.model.Human;
import com.example.spring.solr.model.Image;
import com.example.spring.solr.model.Preview;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;

public class Converters {
    @WritingConverter
    public enum EntityToStringConverter implements Converter<Entity, String> {
        INSTANCE;

        @Override
        public String convert(final Entity entity) {
            if (entity == null) {
                return null;
            }
            final ObjectMapper mapper = new ObjectMapper();

            try {
                return mapper.writeValueAsString(entity);
            } catch (final JsonProcessingException e) {
                throw new RuntimeException("Unable to serialize to json.");
            }
        }
    }

    @ReadingConverter
    public enum StringToAlbumConverter implements Converter<String, Album> {
        INSTANCE;

        @Override
        public Album convert(final String source) {
            if (source == null) {
                return null;
            }
            try {
                return new ObjectMapper().readValue(source, Album.class);
            } catch (final IOException e) {
                throw new RuntimeException("Unable to deserialize from json.");
            }
        }
    }

    @ReadingConverter
    public enum StringToDataFileConverter implements Converter<String, DataFile> {
        INSTANCE;

        @Override
        public DataFile convert(final String source) {
            if (source == null) {
                return null;
            }
            try {
                return new ObjectMapper().readValue(source, DataFile.class);
            } catch (final IOException e) {
                throw new RuntimeException("Unable to deserialize from json.");
            }
        }
    }

    @ReadingConverter
    public enum StringToHumanConverter implements Converter<String, Human> {
        INSTANCE;

        @Override
        public Human convert(final String source) {
            if (source == null) {
                return null;
            }
            try {
                return new ObjectMapper().readValue(source, Human.class);
            } catch (final IOException e) {
                throw new RuntimeException("Unable to deserialize from json.");
            }
        }
    }

    @ReadingConverter
    public enum StringToImageConverter implements Converter<String, Image> {
        INSTANCE;

        @Override
        public Image convert(final String source) {
            if (source == null) {
                return null;
            }
            try {
                return new ObjectMapper().readValue(source, Image.class);
            } catch (final IOException e) {
                throw new RuntimeException("Unable to deserialize from json.");
            }
        }
    }

    @ReadingConverter
    public enum StringToPreviewConverter implements Converter<String, Preview> {
        INSTANCE;

        @Override
        public Preview convert(final String source) {
            if (source == null) {
                return null;
            }
            try {
                return new ObjectMapper().readValue(source, Preview.class);
            } catch (final IOException e) {
                throw new RuntimeException("Unable to deserialize from json.");
            }
        }
    }
}
