package me.symi.carshop.config;

import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;
import java.io.Console;

@Configuration
public class DatabaseConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public DataSourceInitializer dataSourceInitializer() {
        System.out.println("Tworzenie tabel i wstawianie przykladowych danych...");
        DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(dataSource);

        Resource resource = new ClassPathResource("schema.sql");
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator(resource);

        initializer.setDatabasePopulator(populator);
        System.out.println("Gotowe - tabele zostały utworzone.");
        return initializer;
    }

    @PreDestroy
    public void onShutdown() {
        System.out.println("Usuwanie tabel i danych...");
        Resource resource = new ClassPathResource("shutdown-script.sql");
        ResourceDatabasePopulator populator = new ResourceDatabasePopulator(resource);
        populator.execute(dataSource);
        System.out.println("Tabele zostały usuniete.");
    }
}