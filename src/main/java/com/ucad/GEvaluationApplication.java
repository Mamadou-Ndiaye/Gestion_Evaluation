package com.ucad;

import com.ucad.dao.EvaluationRepository;
import com.ucad.entities.Evaluation;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class GEvaluationApplication {

    public static void main(String[] args) {
        SpringApplication.run(GEvaluationApplication.class, args);
    }
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
    @Bean
    CommandLineRunner start(EvaluationRepository evaluationRepository)
    {
        return  args -> {
           //evaluationRepository.save(new Evaluation("20150A17","SOA",17));
        };
    }

}
