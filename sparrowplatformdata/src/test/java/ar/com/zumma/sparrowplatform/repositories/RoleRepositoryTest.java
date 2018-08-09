package ar.com.zumma.sparrowplatform.repositories;

import ar.com.zumma.sparrowplatform.model.Role;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
//@SpringBootTest
//@DataMongoTest
public class RoleRepositoryTest {

    @Autowired
    RoleRepository repo;

    @Before
    public void setUp() throws Exception {
    }


    @Test
    @Ignore
    public void findByName() throws Exception {
        Optional<Role> o = repo.findByName("ADMIN");

        assertEquals("ADMIN", o.get().getName());
    }

}