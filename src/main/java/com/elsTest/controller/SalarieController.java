package com.elsTest.controller;

import com.elsTest.entities.Salarie;
import com.elsTest.services.SalarieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by houssem89 on 20/11/2018.
 */
@RestController
@RequestMapping("/test")
public class SalarieController {
    private final Logger log = LoggerFactory.getLogger(SalarieController.class);
    @Autowired
    SalarieService salarieService ;

    @RequestMapping(value = "/salarie/{criteria}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Salarie>> findSalarieByCriteria(@PathVariable(value = "criteria") String criteria) {
        log.debug("list salarie  by ",criteria);
        List<Salarie> salarieList = salarieService.findSalarieByCriteria(criteria);
        return new ResponseEntity<>(salarieList, HttpStatus.OK);
    }
    @RequestMapping(value = "/salarie", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Salarie>> findSalarie() {
        List<Salarie> salarieList = salarieService.getAllSalarie();
        return new ResponseEntity<>(salarieList, HttpStatus.OK);
    }
}
