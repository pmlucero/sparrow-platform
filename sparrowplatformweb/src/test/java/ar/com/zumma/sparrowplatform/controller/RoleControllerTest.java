package ar.com.zumma.sparrowplatform.controller;

import ar.com.zumma.sparrowplatform.services.RoleService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.mockito.ArgumentMatchers.anyIterable;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.junit.Assert.*;

public class RoleControllerTest {

    @Mock
    RoleService service;

    @Mock
    Model model;

    RoleController controller;

    @Test
    public void getRolePage() throws Exception {
        String viewName = controller.getRolePage(model);
        assertEquals("roles", viewName);
        verify(service, times(1)).findAll();
        verify(model, times(1)).addAttribute(eq("roles"), anyIterable());
    }

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        controller = new RoleController(service);
    }
}