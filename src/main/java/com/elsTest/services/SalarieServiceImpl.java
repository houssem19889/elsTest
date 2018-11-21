package com.elsTest.services;

import com.elsTest.entities.Salarie;
import com.elsTest.repositories.SalarieRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by houssem89 on 20/11/2018.
 */
@Service
public class SalarieServiceImpl implements SalarieService {
    private final Logger logger= LoggerFactory.getLogger(SalarieServiceImpl.class);
   @Autowired
    SalarieRepository salarieRepository;
    @Autowired
    MongoTemplate mongoTemplate;
    @Override
    public List<Salarie> findSalarieByCriteria(String criteria) {
        List<Salarie> salarieList = salarieRepository.findAll().stream()
                .filter(distinctByKey(salarie -> getCriteria(criteria, salarie)))
                .collect(Collectors.toList());
        return salarieList;
    }

    @Override
    public List<Salarie> findAllSalarie() {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Salarie>> mapType = new TypeReference<List<Salarie>>() {};
        InputStream is = TypeReference.class.getResourceAsStream("/static/salarie.json");
        try {
            List<Salarie> salarieList = mapper.readValue(is, mapType);
            salarieRepository.saveAll(salarieList);
            logger.info("salarie list saved successfully");
            return salarieList;
        } catch (IOException e) {
            logger.debug("Unable to get salaries: " + e.getMessage());
            return Collections.emptyList();
        }

    }

    @Override
    public List<Salarie> getAllSalarie() {
        return salarieRepository.findAll();
    }

    public static <T> Predicate<T> distinctByKey(
            Function<? super T, ?> ke) {

        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(ke.apply(t), Boolean.TRUE) == null;
    }

    public static String getCriteria(String criteria, Salarie salarie) {
        switch (criteria.toUpperCase()) {
            case "LASTNAME":
                return salarie.getLastName() ;
            case "FIRSTNAME":
                return salarie.getLastName();
            case "COUNTRY":
                return salarie.getCountry();
            default:
                return salarie.getLastName();
        }
    }
}
