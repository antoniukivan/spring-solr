package com.example.spring.solr.repository;

import com.example.spring.solr.Util;
import com.example.spring.solr.model.DataFile;
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
        List<DataFile> dataFiles = Util.createDataFiles();
        Iterable<DataFile> savedDataFiles = dataFileRepository.saveAll(dataFiles);
        Assertions.assertEquals(dataFiles, savedDataFiles);

        Optional<DataFile> dataFileOptional = dataFileRepository.findById(10L);
        Assertions.assertTrue(dataFileOptional.isPresent());

        DataFile dataFile = dataFileOptional.get();
        Assertions.assertEquals(dataFiles.get(10), dataFile);
        Assertions.assertEquals(dataFiles.get(10).getId(), dataFile.getId());
        Assertions.assertEquals(dataFiles.get(10).getUploader(), dataFile.getUploader());
        Assertions.assertEquals(dataFiles.get(10).getFilesize(), dataFile.getFilesize());
    }
}
