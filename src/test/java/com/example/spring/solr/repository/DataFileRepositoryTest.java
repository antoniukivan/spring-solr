package com.example.spring.solr.repository;

import com.example.spring.solr.model.DataFile;
import com.example.spring.solr.model.Human;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DataFileRepositoryTest {
    @Autowired
    private DataFileRepository dataFileRepository;

    @Test
    public void saveAll() {
        List<DataFile> dataFiles = createAlbums();
        Iterable<DataFile> savedDataFiles = dataFileRepository.saveAll(createAlbums());
        Assertions.assertEquals(dataFiles, savedDataFiles);

        Optional<DataFile> dataFileOptional = dataFileRepository.findById(10L);
        Assertions.assertTrue(dataFileOptional.isPresent());

        DataFile dataFile = dataFileOptional.get();
        Assertions.assertEquals(dataFiles.get(10), dataFile);
        Assertions.assertEquals(dataFiles.get(10).getId(), dataFile.getId());
        Assertions.assertEquals(dataFiles.get(10).getUploader(), dataFile.getUploader());
        Assertions.assertEquals(dataFiles.get(10).getFilesize(), dataFile.getFilesize());
    }

    public List<DataFile> createAlbums() {
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
}
