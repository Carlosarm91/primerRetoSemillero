package com.demoqa.book.stepdefinitions;

import com.demoqa.book.steps.*;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class AgregarColeccionLibroStepDefinitions {

    @Managed
    private static WebDriver driver;

    @Steps
    HomeStep homeStep;
    @Steps
    TiendaStep tiendaStep;
    @Steps
    LoginStep loginStep;
    @Steps
    LibroSteps libroSteps;
    @Steps
    ColeccionStep coleccionStep;

    @Before
    private void setup() {
        driver = getDriver();
    }

    @Dado("que ingreso a la pagina de demoqa books")
    public void queIngresoALaPaginaDeDemoqaBooks() {
        homeStep.abrirNavegador();
    }

    @Cuando("hago login en esta")
    public void hago_login_en_esta() {
        homeStep.clickBotonLogin();
        loginStep.digitarUsuarioYContrasena();
    }

    @Entonces("valido que este logueado")
    public void valido_que_este_logueado() {
        tiendaStep.validarLogin();
    }

    @Dado("que realizo la busqueda de un libro")
    public void que_realizo_la_busqueda_de_un_libro(io.cucumber.datatable.DataTable dataTable) {
        List<String> libro = dataTable.asList();
        tiendaStep.busquedaLibro(libro.get(0));
    }

    @Dado("despliego su informacion")
    public void despliego_su_informacion(io.cucumber.datatable.DataTable dataTable) {
       List<String> libro = dataTable.asList();
       tiendaStep.clicLibro(libro.get(0));
    }

    @Cuando("agrego el libro a la coleccion")
    public void agrego_el_libro_a_la_coleccion() throws InterruptedException {
        libroSteps.clicAddToYourCollection();
    }

    @Cuando("valido el mensaje de agregado {string}")
    public void valido_el_mensaje_de_agregado(String mensaje) throws InterruptedException {
        libroSteps.validarVentanaEmergente(mensaje);
    }

    @Entonces("valido que el libro se haya agregado {string}")
    public void valido_que_el_libro_se_haya_agregado(String libro) {
        coleccionStep.validarLibroAgregado(libro);
    }

    @Dado("que realizo la limpieza de la coleccion")
    public void que_realizo_la_limpieza_de_la_coleccion() {
        coleccionStep.eliminoLibrosColeccion();
    }

    @Entonces("valido que no arroje resultados")
    public void valido_que_no_arroje_resultados() {
        tiendaStep.validarNoResultados();
    }

}
