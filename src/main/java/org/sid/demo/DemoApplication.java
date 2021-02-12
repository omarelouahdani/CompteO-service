package org.sid.demo;

import lombok.Synchronized;
import org.hibernate.annotations.Synchronize;
import org.sid.demo.entities.Compte;
import org.sid.demo.entities.Operation;
import org.sid.demo.repository.CompteRepository;
import org.sid.demo.repository.OperationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    @Synchronized
    CommandLineRunner start(CompteRepository compteRepository, OperationRepository operationRepository, RepositoryRestConfiguration repositoryRestConfiguration) {
        repositoryRestConfiguration.exposeIdsFor(Compte.class);
        return args -> {

            Compte compte= compteRepository.save(new Compte(null,2000,new Date(),"COURANT","ACTIVE",null));
            List<Operation> operations = new ArrayList<>();
            operations.add(operationRepository.save(new Operation(null,new Date(),250,"DEBIT",compte)));
            compte.setOperations(operations);
            operations.forEach(o -> {
                operationRepository.save(o);
            });

        };
    }

}
