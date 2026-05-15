package controllers;

import models.Movie;

public class MovieController {

    /**
     * Método que debe ser implementado
     * Debe ordenar el arreglo de películas por título en orden ascendente.
     * 
     * @param movies Arreglo de películas a ordenar
     */
    public void sortByTitle(Movie[] movies) {
        // burbuja
        int n = movies.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (movies[j].getTitle().compareTo(movies[j + 1].getTitle()) > 0) {
                    // swap movies[j] and movies[j+1]
                    Movie temp = movies[j];
                    movies[j] = movies[j + 1];
                    movies[j + 1] = temp;
                }
            }
        }
    }

}
