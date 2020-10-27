package com.javastudio.tutorial.multidb.datasource;

import com.javastudio.tutorial.multidb.model.mongo.ProductSpecification;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "com.javastudio.tutorial.multidb.repository.mongo",
        entityManagerFactoryRef = "mongoEntityManagerFactory",
        transactionManagerRef = "mongoTransactionManager"
)
public class MongoDataSourceConfiguration {

   @Bean
    @ConfigurationProperties("datasource.mongo")
    public DataSourceProperties mongoDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("datasource.mongo.configuration")
    public DataSource mongoDataSource() {
        return mongoDataSourceProperties()
                .initializeDataSourceBuilder()
                .type(HikariDataSource.class)
                .build();
    }

    @Bean(name = "mongoEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean mongoEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(mongoDataSource())
                .packages(ProductSpecification.class)
                .build();
    }

    @Bean("mongoTransactionManager")
    public PlatformTransactionManager mongoTransactionManager(
            final @Qualifier("mongoEntityManagerFactory") LocalContainerEntityManagerFactoryBean mongoEntityManagerFactory) {
        return new JpaTransactionManager(mongoEntityManagerFactory.getObject());
    }
}
