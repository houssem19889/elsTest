package com.elsTest.services;

import com.elsTest.entities.Salarie;

import java.util.List;

/**
 * Created by houssem89 on 20/11/2018.
 */
public interface SalarieService {
    List<Salarie> findSalarieByCriteria(String criteria);
    List<Salarie> findAllSalarie();
    List<Salarie> getAllSalarie();

}
