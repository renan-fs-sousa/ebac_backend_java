package br.com.rsousa.vendas.online.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @author renan.sousa
 *
 */
@Configuration
@EnableMongoRepositories(basePackages = "br.com.rsousa.vendas.online.repository")
public class MongoConfig {

}
