package definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pageobjects.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static pageobjects.datosPasajerosPage.div_cabina;

public class bookingDefinition {
    busquedaTicketsPage busquedaTickets;
    elegirCabinaPage elegirCabina;
    resumenCompraPage resumenCompra;
    datosPasajerosPage datosPasajeros;
    confirmacionPagoPage comfirmacionPago;
    trenesPage trenes;
    datosPasajerosOp2Page datosPasajerosOp2;
    confirmacionPagoOp2Page confirmacionPagoOp2;

    public bookingDefinition() {
        busquedaTickets = new busquedaTicketsPage();
        elegirCabina = new elegirCabinaPage();
        resumenCompra = new resumenCompraPage();
        datosPasajeros = new datosPasajerosPage();
        comfirmacionPago = new confirmacionPagoPage();
        trenes = new trenesPage();
        datosPasajerosOp2 = new datosPasajerosOp2Page();
        confirmacionPagoOp2 = new confirmacionPagoOp2Page();
    }

    @Dado("que la web perurail este disponible")
    public void queLaWebPerurailEsteDisponible() {
        hooks.driver.get("https://www.perurail.com/");
        String titulo = hooks.driver.getTitle();
        Assert.assertEquals("PeruRail - Train to Machu Picchu on discount | PeruRail", titulo);
    }

    @Cuando("eliges un tipo de viaje {string}")
    public void eligesUnTipoDeViaje(String tipo) {
        busquedaTickets.elegirTipoViaje(tipo);
    }

    @Y("selecciona el destino {string}")
    public void seleccionaElDestino(String destino) {
        busquedaTickets.seleccionarDestino(destino);
    }

    @Y("selecciona la ruta {string}")
    public void seleccionaLaRuta(String ruta) {
        busquedaTickets.seleccionarRuta(ruta);
    }

    @Y("se ingresa la fecha de salida {string}")
    public void seIngresaLaFechaDeSalida(String fecha) throws IOException {
        if (!fecha.equals("")){
            busquedaTickets.ingresarFechaSalida();
            busquedaTickets.datepicker(fecha);
        }
        busquedaTickets.evidencia();
    }

    @Y("se ingresa la fecha de regreso {string}")
    public void seIngresaLaFechaDeRegreso(String fecha) {
        if (!fecha.equals("")){
            busquedaTickets.ingresarFechaRegreso(fecha);
            busquedaTickets.datepicker(fecha);
        }
    }

    @Y("selecciona el tipo de tren {string}")
    public void seleccionaElTipoDeTren(String tren) throws IOException {
        if (!tren.equals("")){
            busquedaTickets.seleccionarTren(tren);
            busquedaTickets.evidencia();
        }
    }

    @Y("se ingresa la cantidad {string} de adultos")
    public void seIngresaLaCantidadDeAdultos(String cantidad) {
        busquedaTickets.ingresarCantidadAdultos(cantidad);
    }

    @Y("se ingresa la cantidad {string}de niños")
    public void seIngresaLaCantidadDeNiños(String cantidad) {
        busquedaTickets.ingresarCantidadNiños(cantidad);
        busquedaTickets.cerrarVentanaPasajeros();
    }

    @Y("se ingresa a la opción de pasajeros")
    public void seIngresaALaOpciónDePasajeros() {
        busquedaTickets.ingresarPasajeros();
    }

    @Y("buscar la disponibilidad del ticket")
    public void buscarLaDisponibilidadDelTicket() throws IOException {
        busquedaTickets.clickBuscarTickets();
        busquedaTickets.evidencia();
    }

    @Entonces("validar el mensaje {string} de disponibilidad de cabinas")
    public void validarDisponibilidadDeCabinas(String mensaje) {
        elegirCabina.validarMensajeCabinaDisponible(mensaje);
    }

    @Y("seleccionar el número de cabinas {string} del tipo de cabina {string}")
    public void seleccionarElNúmeroDeCabinasDelTipoDeCabina(String cabina, String tipo_cabina) {
        elegirCabina.seleccionarCabinas(tipo_cabina, cabina);
    }

    @Y("seleccionar la cantidad {string} de pasajeros adultos")
    public void seleccionarLaCantidadDePasajerosAdultos(String cantidad) {
        elegirCabina.seleccionarCantidadPasajerosAdultos(cantidad);
    }

    @Y("seleccionar la cantidad {string} de pasajeros niños")
    public void seleccionarLaCantidadDePasajerosNiños(String cantidad) throws IOException {
        if (!cantidad.equals("0")){
            elegirCabina.seleccionarCantidadPasajerosNinos(cantidad);
            busquedaTickets.evidencia();
        }
    }

    @Y("validar que el monto a pagar sea el mismo del resumen de compra")
    public void validarQueElMontoAPagarSeaElMismoDelResumenDeCompra() {
        elegirCabina.obtenerSubTotal();
        resumenCompra.clickResumen();
        resumenCompra.validarPrecioCompra();
    }

    @Y("continuar con la compra")
    public void continuarConLaCompra() {
        elegirCabina.clickContinuar();
    }

    @E("ingresar los datos de los pasajeros")
    public void ingresarLosDatosDeLosPasajeros(DataTable pasajeros) throws IOException {
        List<Map<String, String>> lista= pasajeros.asMaps(String.class, String.class);
        for (int i=1; i<=div_cabina.size();i++){
            List<WebElement> div_pasajero = hooks.driver.findElements(By.xpath("//div[contains(@id,'itm"+i+"')]"));
            if (i!=1){
                div_cabina.get(i-1).click();
                div_pasajero.get(0).click();
            }
            for (int j=0; j<div_pasajero.size(); j++){
                if (j !=0){
                    div_pasajero.get(j).click();
                }
                datosPasajeros.ingresarNombre(i,j,lista.get(j).get("nombre"));
                datosPasajeros.ingresarApellido(i,j,lista.get(j).get("apellido"));
                datosPasajeros.ingresarFecha(i,j,lista.get(j).get("fecha_nacimiento"));
                datosPasajeros.seleccionarNacionalidad(i,j,lista.get(j).get("nacionalidad"));
                datosPasajeros.seleccionarTipoDocumento(i,j,lista.get(j).get("tipo_documento"));
                datosPasajeros.ingresarDocumento(i,j,lista.get(j).get("nro_documento"));
                datosPasajeros.seleccionarGenero(i,j,lista.get(j).get("genero"));
                String[] date =lista.get(j).get("fecha_nacimiento").split("-");
                int year = 2021-Integer.parseInt(date[2]);
                if (year>11){
                    datosPasajeros.ingresarTelefono(i,j,lista.get(j).get("telefono"));
                    datosPasajeros.ingresarEmail(i,j,lista.get(j).get("email"));
                    datosPasajeros.ingresarConfirmacionEmail(i,j,lista.get(j).get("email"));
                    datosPasajeros. aceptarPromociones(i,j,lista.get(j).get("promociones"));
                }
                datosPasajeros.evidencia();
            }
        }

    }

    @Y("continuar con el pago de los tickets")
    public void continuarConElPagoDeLosTickets() throws IOException {
        datosPasajeros.clickContinuar();
        datosPasajeros.evidencia();
    }

    @Y("elegir el medio de pago {string}")
    public void elegirElMedioDePago(String medio) {
        comfirmacionPago.validarTitulo();
        comfirmacionPago.seleccionarMedioPago(medio);
    }

    @Y("aceptar los terminos y condiciones")
    public void aceptarLosTerminosYCondiciones() {
        comfirmacionPago.aceptarTerminos();
    }

    @Y("dar click a la opción de ingresar número de tarjeta")
    public void darClickALaOpciónDeIngresarNúmeroDeTarjeta() {
        comfirmacionPago.clickIngresarNroTarjeta();
    }

    @Y("seleccionar tickets de viaje de ida {string} - regreso {string}")
    public void seleccionarTicketsDeViaje(String ida, String regreso) throws IOException {
        trenes.seleccionarTickets(ida, regreso);
        trenes.evidencia();
    }

    @Y("continuar con el proceso")
    public void continuarConElRegistroDeDatos() {
        trenes.clickContinuar();
    }

    @Y("registrar datos de pasajeros")
    public void registrarDatosDePasajeros(DataTable pasajeros) throws IOException {
        List<Map<String, String>> lista= pasajeros.asMaps(String.class, String.class);
        List<WebElement> div_pasajero = hooks.driver.findElements(By.xpath("//div/span[text()='ADULT']"));
        for (int i=0; i<div_pasajero.size(); i++) {
            if (i != 0) {
                div_pasajero.get(i).click();
            }
            datosPasajerosOp2.ingresarNombre(i,lista.get(i).get("nombre"));
            datosPasajerosOp2.ingresarApellido(i,lista.get(i).get("apellido"));
            datosPasajerosOp2.ingresarFecha(i,lista.get(i).get("fecha_nacimiento"));
            datosPasajerosOp2.seleccionarNacionalidad(i,lista.get(i).get("nacionalidad"));
            datosPasajerosOp2.seleccionarTipoDocumento(i,lista.get(i).get("tipo_documento"));
            datosPasajerosOp2.ingresarDocumento(i,lista.get(i).get("nro_documento"));
            datosPasajerosOp2.seleccionarGenero(i,lista.get(i).get("genero"));
            datosPasajerosOp2.ingresarTelefono(i,lista.get(i).get("telefono"));
            datosPasajerosOp2.ingresarEmail(i,lista.get(i).get("email"));
            datosPasajerosOp2.ingresarConfirmarEmail(i,lista.get(i).get("email"));
            datosPasajerosOp2.aceptarPromociones(i,lista.get(i).get("promociones"));
            datosPasajerosOp2.evidencia();
        }
    }

    @Y("seleccionar el medio de pago {string}")
    public void seleccionarElMedioDePago(String medio) {
        confirmacionPagoOp2.validarTitulo();
        confirmacionPagoOp2.seleccionarMedioPago(medio);
    }

    @Y("aceptar los terminos y condiciones de pago")
    public void aceptarLosTerminosYCondicionesDePago() {
        confirmacionPagoOp2.aceptarTerminos();
    }

    @Y("dar click a la opción de pagar")
    public void darClickALaOpciónDePagar() throws IOException {
        confirmacionPagoOp2.clickPagar();
        confirmacionPagoOp2.evidencia();
    }
}
