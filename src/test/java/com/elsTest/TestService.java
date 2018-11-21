package com.elsTest;

import com.elsTest.entities.Salarie;
import com.elsTest.repositories.SalarieRepository;
import com.elsTest.services.SalarieServiceImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestService {
    @InjectMocks
    SalarieServiceImpl salarieService;

    @Mock
    SalarieRepository salarieRepository;
    public static List<Salarie> createData() {
        Salarie salarie1 = new Salarie("1", "fahed", "sami", "Tunisia");
        Salarie salarie2 = new Salarie("2", "SAlah", "monir", "Tunisia");
        Salarie salarie3 = new Salarie("3", "Ali", "jaber", "Maroc");
        Salarie salarie4 = new Salarie("4", "Ali", "sami", "Tunisia");
        List<Salarie> salarieList = new ArrayList<>();
        salarieList.add(salarie1);
        salarieList.add(salarie2);
        salarieList.add(salarie3);
        salarieList.add(salarie4);
        return  salarieList;
    }
    @Test
    public void testSalarieListByCriteria() {
        //given
        String criteriaFirstName = "FIRSTNAME";
        String criteriaLastName = "LASTNAME";
        String criteriaCountry = "COUNTRY";
        List<Salarie> salarieList=createData();
        //when
        when(salarieRepository.findAll()).thenReturn(salarieList);
        int taille = salarieService.findSalarieByCriteria(criteriaFirstName).size();
        //then
        assertEquals(3, taille);
        //when
        when(salarieRepository.findAll()).thenReturn(salarieList);
        int listSize2 = salarieService.findSalarieByCriteria(criteriaLastName).size();
        //then
        assertEquals(3, listSize2);
        //when
        when(salarieRepository.findAll()).thenReturn(salarieList);
        int listSize3 = salarieService.findSalarieByCriteria(criteriaCountry).size();
        //then
        assertEquals(2, listSize3);
    }

}
