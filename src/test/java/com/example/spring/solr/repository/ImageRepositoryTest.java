package com.example.spring.solr.repository;

import com.example.spring.solr.model.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ImageRepositoryTest {
    @Autowired
    private ImageRepository imageRepository;

    @Test
    public void saveAll() {
        List<Image> images = createAlbums();
        Iterable<Image> savedImage = imageRepository.saveAll(createAlbums());
        Assertions.assertEquals(images, savedImage);

        Optional<Image> imageOptional = imageRepository.findById(10L);
        Assertions.assertTrue(imageOptional.isPresent());

        Image image = imageOptional.get();
        Assertions.assertEquals(images.get(10), image);
        Assertions.assertEquals(images.get(10).getId(), image.getId());
        Assertions.assertEquals(images.get(10).getFormat(), image.getFormat());
        Assertions.assertEquals(images.get(10).getUrl(), image.getUrl());
        Assertions.assertEquals(images.get(10).getHeight(), image.getHeight());
    }

    private List<Image> createAlbums() {
        List<Image> humans = new ArrayList<>();

        for (int i = 0; i < 80; i++) {
            Image image = Image.builder()
                    .id((long) i)
                    .format(i + "")
                    .url(i + "")
                    .height(i)
                    .build();
            humans.add(image);
        }

        return humans;
    }
}
