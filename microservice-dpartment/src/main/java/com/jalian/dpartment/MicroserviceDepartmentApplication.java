package com.jalian.dpartment;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Hooks;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@EnableDiscoveryClient
public class MicroserviceDepartmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceDepartmentApplication.class, args);
        //Hooks.enableAutomaticContextPropagation(); //for span id and trace id
    }

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }
}
