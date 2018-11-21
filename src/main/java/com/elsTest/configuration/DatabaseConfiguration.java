package com.elsTest.elsTest.configuration;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by houssem89 on 20/11/2018.
 */
@Configurable
@EnableMongoRepositories("com.elsTest.repositories")
@Import(value = MongoAutoConfiguration.class)
public class DatabaseConfiguration {
}
