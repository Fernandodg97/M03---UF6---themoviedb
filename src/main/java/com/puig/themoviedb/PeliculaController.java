package com.puig.themoviedb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller // Anotación que marca esta clase como un controlador en Spring MVC
@RequestMapping(PeliculaController.PELICULA) // Define la ruta base para las solicitudes en este controlador ("/pelicula")
public class PeliculaController {

    // Ruta base constante para la ruta "/pelicula"
    public static final String PELICULA = "/pelicula";

    // Inyección automática del servicio PeliculaService para obtener películas
    @Autowired
    PeliculaService peliculaService;

    // Método que maneja solicitudes GET a "/pelicula"
    @GetMapping // El mapeo para solicitudes GET
    private String pelicula(Model model) {
        // Llama al servicio para obtener las 10 primeras películas
        List<Pelicula> p = peliculaService.getTop10Peliculas();
        
        // Agrega la lista de películas al modelo para que sea accesible en la vista
        model.addAttribute("peliculas", p);

        // Devuelve el nombre de la vista "pelicula" que se resolverá en un archivo de plantilla
        return "pelicula";
    }
}
