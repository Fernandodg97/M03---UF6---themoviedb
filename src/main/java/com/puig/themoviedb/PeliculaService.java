package com.puig.themoviedb;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service // Marca la clase como un servicio Spring que puede ser inyectado
public class PeliculaService {

    // API Key tomada del archivo application.properties
    @Value("${tmdb.api.key}")
    private String apiKey;

    // Creación del objeto RestTemplate, que se usará para hacer solicitudes HTTP
    private final RestTemplate restTemplate = new RestTemplate();

    // Método que obtiene las primeras 10 películas desde TMDb
    public List<Pelicula> getTop10Peliculas() {
        // Construir la URL con el endpoint de películas populares
        String url = UriComponentsBuilder.fromHttpUrl("https://api.themoviedb.org/3/movie/popular")
                .queryParam("language", "es-ES")
                .toUriString();

        // Configurar los encabezados con la API Key
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.set("Accept", "application/json");

        // Crear el objeto HttpEntity con los encabezados
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Realizar la solicitud GET utilizando RestTemplate y la URL construida
        ResponseEntity<PeliculaResponse> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                PeliculaResponse.class
        );

        // Verificar si la respuesta es válida y contiene resultados
        if (response != null && response.getBody() != null && response.getBody().getResults() != null
                && !response.getBody().getResults().isEmpty()) {
            // Devolver las primeras 10 películas (o menos si no hay suficientes)
            return response.getBody().getResults().subList(0, Math.min(10, response.getBody().getResults().size()));
        }

        // Si no se obtuvo ninguna película, retornamos una lista vacía
        return List.of();
    }
}
