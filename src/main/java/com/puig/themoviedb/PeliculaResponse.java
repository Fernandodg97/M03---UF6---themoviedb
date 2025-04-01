package com.puig.themoviedb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PeliculaResponse {
    private List<Pelicula> results;

    public List<Pelicula> getResults() {
        return results;
    }

    public void setResults(List<Pelicula> results) {
        this.results = results;
    }
}
