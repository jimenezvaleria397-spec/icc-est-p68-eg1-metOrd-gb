package controllers;

import models.Movie;

public class MovieController {

    /**
     * Método que debe ser implementado
     * Debe ordenar el arreglo de películas por título en orden descendente.
     * 
     * Metodo: sortByTitle
     * 
     * @param movies Arreglo de películas a ordenar
     */
    // Seleccion
    public void sortByTitle(Movie[] movies) {
        for (int i = 0; i < movies.length - 1; i++) {
            int min = i;
            for (int j = 0; j < movies.length - 1 - i; j++) {
                if (movies[j].name.compareTo(movies[min].name) < 0)
                    ;
                min = j;

                Movie temp = movies[i];
                movies[i] = movies[min];
                movies[min] = temp;
            }
        }

    }
}
