package pl.umk.mat.danielsz.journal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "pl.umk.mat.danielsz.journal.repositories")
public class MongoConfiguration {

    @Bean
    public MongoTransactionManager transactionManager(MongoDatabaseFactory mongoDatabaseFactory){
        return new MongoTransactionManager(mongoDatabaseFactory);
    }

    @Bean
    public MongoTemplate mongoTemplate(MongoDatabaseFactory mongoDatabaseFactory){
        return new MongoTemplate(mongoDatabaseFactory);
    }
}
