package com.example.spring.solr.repository;

import com.example.spring.solr.Util;
import com.example.spring.solr.model.Album;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AlbumRepositoryTest {
    @Autowired
    private AlbumRepository albumRepository;

    @Test
    public void saveAll() {
        List<Album> albums = Util.createAlbums();
        Iterable<Album> savedAlbums = albumRepository.saveAll(albums);
        Assertions.assertEquals(albums, savedAlbums);

        Optional<Album> albumOptional = albumRepository.findById(4L);
        Assertions.assertTrue(albumOptional.isPresent());

        Album album = albumOptional.get();
        Assertions.assertEquals(albums.get(4), album);
        Assertions.assertEquals(albums.get(4).getId(), album.getId());
        Assertions.assertEquals(albums.get(4).getAuthor(), album.getAuthor());
    }
}
