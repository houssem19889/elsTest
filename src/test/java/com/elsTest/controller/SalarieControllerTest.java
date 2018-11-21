package com.elsTest.controller;

import com.elsTest.TestService;
import com.elsTest.entities.Salarie;
import com.elsTest.services.SalarieServiceImpl;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class SalarieControllerTest extends TestCase {
    @Mock
    SalarieServiceImpl salarieService;
    @InjectMocks
    SalarieController salarieController ;
    private MockMvc mockMvc;
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(salarieController);
        this.mockMvc = MockMvcBuilders.standaloneSetup(salarieController).build();
    }
    @Test
    public void testFindSalarieByCriteria() throws Exception {
        List<Salarie> salarieList = TestService.createData();
        /* when */
        when(salarieService.findSalarieByCriteria("firstName")).thenReturn(salarieList.subList(1, 3));
        /* then */
        mockMvc.perform(get("/test/salarie/firstName"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));

        verify(salarieService, times(1)).findSalarieByCriteria("firstName");
        verifyNoMoreInteractions(salarieService);
    }
}