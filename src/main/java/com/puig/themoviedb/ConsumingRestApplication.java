package com.puig.themoviedb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumingRestApplication {
    
    // API Key tomada del archivo application.properties
    @Value("${tmdb.api.key}")
    private String apiKey;

    private static final Logger log = LoggerFactory.getLogger(ConsumingRestApplication.class);
    private static final String API_URL = "https://api.themoviedb.org/3/movie/popular";

    public static void main(String[] args) {
        SpringApplication.run(ConsumingRestApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) {
        return args -> {
            try {
                // Construye la URL de la API con la página de resultados
                String url = API_URL + "?language=en-US&page=1";
                
                // Configura los headers para la solicitud, incluyendo la API Key
                org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
                headers.set("Authorization", "Bearer " + apiKey);  // Usando la API Key desde application.properties
                headers.set("Accept", "application/json");

                // Crea el objeto HttpEntity con los headers
                org.springframework.http.HttpEntity<String> entity = new org.springframework.http.HttpEntity<>(headers);

                // Realiza la solicitud GET a la API y recibe la respuesta como String
                org.springframework.http.ResponseEntity<String> response = restTemplate.exchange(
                        url,
                        org.springframework.http.HttpMethod.GET,
                        entity,
                        String.class
                );

                // Imprime la respuesta de la API en el log
                log.info("### Respuesta de TMDb: OK! ###");
                log.info("Respuesta: {}", response.getBody());
            } catch (Exception e) {
                // En caso de error, imprime el mensaje de error en el log
                log.error("Error al consumir la API de TMDb", e);
            }
        };
    }
}
