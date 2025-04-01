package com.puig.themoviedb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// Anotación que indica que se deben ignorar propiedades desconocidas al deserializar JSON
@JsonIgnoreProperties(ignoreUnknown = true)
public class Pelicula {

    // Atributo que almacenará el id de la película
    private int id;

    // Atributo que almacenará el título de la película
    private String title;

    // Atributo que almacenará la descripción de la película (overview)
    private String overview;

    // Atributo que almacenará la fecha de estreno de la película
    @JsonProperty("release_date")
    private String releaseDate;

    // Atributo que almacenará la URL de la imagen de la película
    @JsonProperty("poster_path")
    private String posterPath;

    // Constructor vacío necesario para la deserialización automática de JSON a objeto
    public Pelicula() {
    }

    // Método getter para obtener el id de la película
    public int getId() {
        return id;
    }

    // Método setter para establecer el id de la película
    public void setId(int id) {
        this.id = id;
    }

    // Método getter para obtener el título de la película
    public String getTitle() {
        return title;
    }

    // Método setter para establecer el título de la película
    public void setTitle(String title) {
        this.title = title;
    }

    // Método getter para obtener la descripción de la película
    public String getOverview() {
        return overview;
    }

    // Método setter para establecer la descripción de la película
    public void setOverview(String overview) {
        this.overview = overview;
    }

    // Método getter para obtener la fecha de estreno de la película
    public String getReleaseDate() {
        return releaseDate;
    }

    // Método setter para establecer la fecha de estreno de la película
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    // Método getter para obtener la URL de la imagen de la película
    public String getPosterPath() {
        return posterPath;
    }

    // Método setter para establecer la URL de la imagen de la película
    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    // Método toString para representar el objeto como una cadena de texto
    @Override
    public String toString() {
        return "Pelicula{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", overview='" + overview + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", posterPath='" + posterPath + '\'' +
                '}';
    }
}
