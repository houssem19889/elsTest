package com.elsTest.repositories;

import com.elsTest.entities.Salarie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by houssem89 on 20/11/2018.
 */
@Repository
public interface SalarieRepository extends MongoRepository<Salarie,String>{
    List<Salarie> findByFirstName();
    List<Salarie> findByLastName();
    List<Salarie> findByCountry();


}
