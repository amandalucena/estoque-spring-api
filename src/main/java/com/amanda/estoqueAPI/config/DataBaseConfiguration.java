package com.amanda.estoqueAPI.config;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataBaseConfiguration {

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.driver-class-name}")
    private String driver;

    @Bean
    public DataSource hikariDataSource (){
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(username);
        config.setPassword(password);
        config.setDriverClassName(driver);


        //O máximo que o poll vai receber de conexões de usuarios
        config.setMaximumPoolSize(10);

        //Tamanho inicial do Pool de conexões
        config.setMinimumIdle(1);

        config.setPoolName("estoque-db-pool"); // nome do Pool
        config.setMaxLifetime(600000); // 600mil ms
        config.setConnectionTimeout(100000); // se passar de 100mil ms a aplicação vai dar erro
        config.setConnectionTestQuery("select 1"); // teste de query para saber se o banco esta funcionando

        return new HikariDataSource(config);
    }
}
