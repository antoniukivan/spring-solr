package com.example.spring.solr.repository;

import com.example.spring.solr.model.Album;
import com.example.spring.solr.model.Human;
import com.example.spring.solr.model.Image;
import java.util.ArrayList;
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
        List<Album> albums = createAlbums();
        Iterable<Album> savedAlbums = albumRepository.saveAll(createAlbums());
        Assertions.assertEquals(albums, savedAlbums);

        Optional<Album> albumOptional = albumRepository.findById(4L);
        Assertions.assertTrue(albumOptional.isPresent());

        Album album = albumOptional.get();
        Assertions.assertEquals(albums.get(4), album);
        Assertions.assertEquals(albums.get(4).getId(), album.getId());
        Assertions.assertEquals(albums.get(4).getAuthor(), album.getAuthor());
        Assertions.assertEquals(albums.get(4).getPhotos(), album.getPhotos());
    }

    private List<Album> createAlbums() {
        List<Album> albums = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Album album = Album.builder()
                    .id((long) i)
                    .author(Human.builder().id((long) i).build())
                    .photos(new Image[]{Image.builder().id((long) i).build()})
                    .build();
            albums.add(album);
        }

        return albums;
    }
}
