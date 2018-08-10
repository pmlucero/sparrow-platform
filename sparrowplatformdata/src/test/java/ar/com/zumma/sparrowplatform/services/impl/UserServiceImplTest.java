package ar.com.zumma.sparrowplatform.services.impl;

import ar.com.zumma.sparrowplatform.model.User;
import ar.com.zumma.sparrowplatform.repositories.UserRepository;
import ar.com.zumma.sparrowplatform.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserServiceImplTest {


    UserServiceImpl service;

    @Mock
    UserRepository repository;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        service = new UserServiceImpl(repository);
    }

    @Test
    public void save() throws Exception {
        User u = new User();

        User saved = new User();
        saved.setId("xusya12");

        when(service.save(u)).thenReturn(saved);

        u = service.save(u);

        assertNotNull(u.getId());
    }

    @Test
    public void findById() throws Exception {
        String id = "ABCDEF";

        User u = new User();
        u.setId(id);
        Optional<User> optional = Optional.of(u);

        when(service.findById(id)).thenReturn(optional);

        optional = service.findById(id);

        assertTrue(optional.isPresent());
        assertEquals(optional.get().getId(), id);
        verify(repository, times(1)).findById(id);
    }

    @Test
    public void delete() throws Exception {
        User u = new User();
        u.setId("1h2k3l4");
        service.delete(u);
        verify(repository, times(1)).delete(u);
    }

    @Test
    public void findAll() throws Exception {
        User u = new User();
        List<User> users = new ArrayList<User>();
        users.add(u);

        when(service.findAll()).thenReturn(users);

        List<User> result =  service.findAll();

        assertEquals(result.size() , 1);
        verify(repository, times(1)).findAll();
    }

    @Test
    public void findByEmail() throws Exception {
        String email = "administrator@zumma.com.ar";

        User u = new User();
        u.setEmail(email);
        Optional<User> optional = Optional.of(u);

        when(service.findByEmail(email)).thenReturn(optional);

        optional = service.findByEmail(email);

        assertTrue(optional.isPresent());
        assertEquals(optional.get().getEmail(), email);
        verify(repository, times(1)).findByEmail(email);
    }

}