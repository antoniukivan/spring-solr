package com.example.spring.solr.repository;

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
class HumanRepositoryTest {
    @Autowired
    private HumanRepository humanRepository;

    @Test
    public void saveAll() {
        List<Human> humans = createAlbums();
        Iterable<Human> savedHuman = humanRepository.saveAll(createAlbums());
        Assertions.assertEquals(humans, savedHuman);

        Optional<Human> humanOptional = humanRepository.findById(10L);
        Assertions.assertTrue(humanOptional.isPresent());

        Human human = humanOptional.get();
        Assertions.assertEquals(humans.get(10), human);
        Assertions.assertEquals(humans.get(10).getId(), human.getId());
        Assertions.assertEquals(humans.get(10).getAvatar(), human.getAvatar());
        Assertions.assertEquals(humans.get(10).getLogin(), human.getLogin());
        Assertions.assertEquals(humans.get(10).getName(), human.getName());
    }

    private List<Human> createAlbums() {
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
