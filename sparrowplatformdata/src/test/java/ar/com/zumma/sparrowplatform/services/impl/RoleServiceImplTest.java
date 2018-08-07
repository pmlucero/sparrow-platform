package ar.com.zumma.sparrowplatform.services.impl;

import ar.com.zumma.sparrowplatform.model.Role;
import ar.com.zumma.sparrowplatform.repositories.RoleRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class RoleServiceImplTest {

    RoleServiceImpl roleService;

    @Mock
    RoleRepository roleRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        roleService = new RoleServiceImpl(roleRepository);
    }

    @Test
    public void save() throws Exception {
        Role r = new Role();

        Role saved = new Role();
        saved.setId("1sa13gwk");
        when(roleService.save(r)).thenReturn(saved);

        r = roleService.save(r);

        assertNotNull(r.getId());
        //verify(roleRepository, times(1)).save(r);
    }

    @Test
    public void findById() throws Exception {
        String id = "ABCDEF";

        Role r = new Role();
        r.setId(id);
        Optional<Role> optional = Optional.of(r);

        when(roleService.findById(id)).thenReturn(optional);

        optional = roleService.findById(id);

        assertTrue(optional.isPresent());
        assertEquals(optional.get().getId(), id);
        verify(roleRepository, times(1)).findById(id);
    }

    @Test
    public void delete() throws Exception {
        Role r = new Role();
        r.setId("1h2k3l4");
        roleService.delete(r);
        verify(roleRepository, times(1)).delete(r);
    }

    @Test
    public void findAll() throws Exception {
        Role r = new Role();
        HashSet<Role> roles = new HashSet<>();
        roles.add(r);

        when(roleService.findAll()).thenReturn(roles);

        Set<Role> result = (Set<Role>) roleService.findAll();

        assertEquals(result.size() , 1);
        verify(roleRepository, times(1)).findAll();
    }

    @Test
    public void findByName() throws Exception {
        String adminRole = "ADMIN";

        Role r = new Role();
        r.setName(adminRole);
        Optional<Role> optional = Optional.of(r);

        when(roleService.findByName(adminRole)).thenReturn(optional);

        optional = roleService.findByName(adminRole);

        assertTrue(optional.isPresent());
        assertEquals(optional.get().getName(), adminRole);
        verify(roleRepository, times(1)).findByName(adminRole);
    }

}