package com.javastudio.tutorial.multidb.datasource;

import org.assertj.core.util.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.HashMap;

import static java.util.Objects.requireNonNull;

@Configuration
@PropertySource("classpath:datasource.properties")
@EnableJpaRepositories(
        basePackages = "com.javastudio.tutorial.multidb.repository",
        entityManagerFactoryRef = "",
        transactionManagerRef = ""
)
public class MariaDBDataSourceConfiguration {

    @Autowired
    private Environment env;

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean userEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(primaryDataSource());
        em.setPackagesToScan(new String[]{"com.javastudio.tutorial.multidb.model"});

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", false);
        properties.put("hibernate.dialect", );
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Primary
    @Bean
    public DataSource primaryDataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(requireNonNull(env.getProperty("jdbc.driverClassName")));
        dataSource.setUrl(requireNonNull(env.getProperty("user.jdbc.url")));
        dataSource.setUsername(requireNonNull(env.getProperty("jdbc.user")));
        dataSource.setPassword(requireNonNull(env.getProperty("jdbc.pass")));

        return dataSource;
    }


}
