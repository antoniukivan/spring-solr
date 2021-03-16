package com.example.spring.solr.repository;

import com.example.spring.solr.Util;
import com.example.spring.solr.model.Preview;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PreviewRepositoryTest {
    @Autowired
    private PreviewRepository previewRepository;

    @Test
    public void saveAll() {
        List<Preview> previews = Util.createPreviews();
        Iterable<Preview> savedPreview = previewRepository.saveAll(previews);
        Assertions.assertEquals(previews, savedPreview);

        Optional<Preview> previewOptional = previewRepository.findById(10L);
        Assertions.assertTrue(previewOptional.isPresent());

        Preview preview = previewOptional.get();
        Assertions.assertEquals(previews.get(10), preview);
        Assertions.assertEquals(previews.get(10).getId(), preview.getId());
        Assertions.assertEquals(previews.get(10).getPreview(), preview.getPreview());
        Assertions.assertEquals(previews.get(10).getFile(), preview.getFile());
    }
}
