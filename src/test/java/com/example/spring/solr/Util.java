package com.example.spring.solr;

import com.example.spring.solr.model.Album;
import com.example.spring.solr.model.DataFile;
import com.example.spring.solr.model.Human;
import com.example.spring.solr.model.Image;
import com.example.spring.solr.model.Preview;
import java.util.ArrayList;
import java.util.List;

public class Util {
    public static List<Preview> createPreviews() {
        List<Preview> previews = new ArrayList<>();

        for (int i = 0; i < 90; i++) {
            Preview preview = Preview.builder()
                    .id((long) i)
                    .preview(Image.builder().id((long) i).build())
                    .file(DataFile.builder().id((long) i).build())
                    .build();
            previews.add(preview);
        }

        return previews;
    }

    public static List<Image> createImages() {
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

    public static List<Album> createAlbums() {
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

    public static List<DataFile> createDataFiles() {
        List<DataFile> dataFiles = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            DataFile dataFile = DataFile.builder()
                    .id((long) i)
                    .uploader(Human.builder().id((long) i).build())
                    .filesize(i)
                    .build();
            dataFiles.add(dataFile);
        }

        return dataFiles;
    }

    public static List<Human> createHumans() {
        List<Human> humans = new ArrayList<>();

        for (int i = 0; i < 70; i++) {
            Human human = Human.builder()
                    .id((long) i)
                    .avatar(Image.builder().id((long) i).build())
                    .login(i + "")
                    .name(i + "")
                    .build();
            humans.add(human);
        }

        return humans;
    }
}
