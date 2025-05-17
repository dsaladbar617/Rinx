package com.saladbar.rinx.repository;

import com.saladbar.rinx.model.entity.Rink;
import com.saladbar.rinx.rink.repository.RinkRepository;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DataJpaTest(showSql = false)
@Transactional
public class RinkRepositoryTest {

    private static List<Rink> rinks;

    @Autowired
    private RinkRepository rinkRepository;

    @BeforeAll
    public static void setupRinks(){
        Rink rink1 = new Rink.Builder()
                .rinkNumber(1)
                .rinkName("Rank")
                .build();

        Rink rink2 = new Rink.Builder()
                .rinkNumber(2)
                .rinkName("Runk")
                .build();

        Rink rink3 = new Rink.Builder()
                .rinkNumber(3)
                .rinkName("Ronk")
                .build();

        rinks = new ArrayList<>(List.of(rink1, rink2, rink3));
    }

    @BeforeEach
    public void setUpBeforeEach() {
        rinkRepository.saveAllAndFlush(rinks);
    }

    @AfterEach
    public void cleanup() {
        rinkRepository.deleteAll();
        rinkRepository.flush();
    }

    @DisplayName("Save new rink")
    @Test
    public void saveRinkTest() {
        Rink rink = new Rink.Builder()
                .rinkName("duh")
                .rinkNumber(420)
                .build();

        Rink savedRink = rinkRepository.save(rink);

        assertThat(savedRink).isNotNull();
        assertThat(savedRink.getRinkId()).isGreaterThan(0);
        assertThat(savedRink.getRinkId()).isGreaterThanOrEqualTo(4);
    }

    @DisplayName("Get all rinks")
    @Test
    @Order(2)
    public void getAllRinksTest() {
        List<Rink> rinksFromDb = rinkRepository.findAll();

        assertThat(rinksFromDb.isEmpty()).isFalse();
        assertThat(rinksFromDb.size()).isGreaterThan(1);
    }

    @DisplayName("Get rink by rinkId")
    @Test
    @Order(1)
    public void getRinkByIdTest() {
        Rink rink = rinkRepository.findById(rinks.getFirst().getRinkId()).orElse(null);

        assertThat(rink).isNotNull();
        assertThat(rink.getRinkName()).isEqualTo("Rank");
    }

    @Test
    public void updateRinkTest() {
        Rink rink = new Rink.Builder()
                .rinkName("Silver Creek")
                .rinkNumber(420)
                .build();

        Rink savedRink = rinkRepository.save(rink);

        Rink fetchedRink = rinkRepository.findById(savedRink.getRinkId()).orElse(null);

        assertThat(fetchedRink).isNotNull();
        fetchedRink.setRinkName("Ash Pavilion");
        fetchedRink.setRinkNumber(69);
        Rink updatedRink = rinkRepository.save(fetchedRink);

        assertThat(updatedRink.getRinkId()).isEqualTo(savedRink.getRinkId());
        assertThat(updatedRink.getRinkName()).isEqualTo("Ash Pavilion");
        assertThat(updatedRink.getRinkNumber()).isEqualTo(69);
    }
}
