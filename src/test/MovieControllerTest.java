package test;

import controllers.MovieController;
import models.Movie;
import validaciones.ValidatorsM;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

public class MovieControllerTest {

    private MovieController controller;

    @BeforeEach
    public void setUp() {
        controller = new MovieController();
    }

    public static Movie[] makeMovieList() {
        Movie[] movies = new Movie[20];
        movies[0] = new Movie("Inception", 2010);
        movies[1] = new Movie("Avatar", 2009);
        movies[2] = new Movie("The Dark Knight", 2008);
        movies[3] = new Movie("Interstellar", 2014);
        movies[4] = new Movie("Pulp Fiction", 1994);
        movies[5] = new Movie("Forrest Gump", 1994);
        movies[6] = new Movie("The Matrix", 1999);
        movies[7] = new Movie("Gladiator", 2000);
        movies[8] = new Movie("The Shawshank Redemption", 1994);
        movies[9] = new Movie("The Godfather", 1972);
        movies[10] = new Movie("The Lord of the Rings", 2001);
        movies[11] = new Movie("Harry Potter", 2001);
        movies[12] = new Movie("Titanic", 1997);
        movies[13] = new Movie("Jurassic Park", 1993);
        movies[14] = new Movie("The Avengers", 2012);
        movies[15] = new Movie("Iron Man", 2008);
        movies[16] = new Movie("Spider-Man", 2002);
        movies[17] = new Movie("Batman Begins", 2005);
        movies[18] = new Movie("The Lion King", 1994);
        movies[19] = new Movie("Frozen", 2013);
        return movies;
    }

    @Test
    @DisplayName("Prueba ordenamiento básico por título")
    public void testOrdenamientoBasico() {
        Movie[] original = makeMovieList();
        Movie[] paraOrdenar = ValidatorsM.copiarArreglo(List.of(original));

        // El estudiante debe implementar este método
        controller.sortByTitle(paraOrdenar);

        // Validar que el ordenamiento sea correcto
        ValidatorsM.validarOrdenamientoPorTitulo(original, paraOrdenar);
        ValidatorsM.validarCasosEspeciales(paraOrdenar);
    }

    @Test
    @DisplayName("Prueba con títulos con mayúsculas y minúsculas")
    public void testCaseSensitive() {
        Movie[] original = new Movie[] {
                new Movie("avatar", 2009),
                new Movie("Avatar", 2012),
                new Movie("AVATAR", 2015),
                new Movie("inception", 2010) };
        Movie[] paraOrdenar = ValidatorsM.copiarArreglo(List.of(original));

        controller.sortByTitle(paraOrdenar);

        ValidatorsM.validarOrdenamientoPorTitulo(original, paraOrdenar);
        ValidatorsM.validarCasosEspeciales(paraOrdenar);
    }

    @Test
    @DisplayName("Prueba con títulos con espacios y caracteres especiales")
    public void testTitulosEspeciales() {
        Movie[] original = new Movie[] {
                new Movie("The Lord of the Rings", 2001),
                new Movie("Spider-Man: No Way Home", 2021),
                new Movie("La La Land", 2016),
                new Movie("Pirates of the Caribbean", 2003) };
        Movie[] paraOrdenar = ValidatorsM.copiarArreglo(List.of(original));

        controller.sortByTitle(paraOrdenar);

        ValidatorsM.validarOrdenamientoPorTitulo(original, paraOrdenar);
        ValidatorsM.validarCasosEspeciales(paraOrdenar);
    }

    @Test
    @DisplayName("Prueba con títulos duplicados (estabilidad)")
    public void testEstabilidadConTitulosDuplicados() {
        Movie[] original = new Movie[] {
                new Movie("Avatar", 2009),
                new Movie("Avatar", 2016),
                new Movie("Avatar", 2022),
                new Movie("Batman", 2005),
                new Movie("Batman", 2012) };
        Movie[] paraOrdenar = ValidatorsM.copiarArreglo(List.of(original));

        controller.sortByTitle(paraOrdenar);

        ValidatorsM.validarOrdenamientoPorTitulo(original, paraOrdenar);
        ValidatorsM.validarEstabilidadOrdenamiento(List.of(original), paraOrdenar);
        ValidatorsM.validarCasosEspeciales(paraOrdenar);
    }
}
