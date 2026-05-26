package controllers;

import entities.Cita;
import entities.Dueno;
import entities.Servicio;
import entities.ServicioBasico;
import entities.ServicioEspecializado;
import services.PetVetService;

import java.util.ArrayList;

public class PetVetController {

    // El controlador recibe la solicitud del menu y la entrega a la capa de servicio.
    private PetVetService service = new PetVetService();

    public String registrarDueno(Dueno dueno) {
        return service.registrarDueno(dueno);
    }

    public String registrarServicioBasico(ServicioBasico servicio) {
        return service.registrarServicioBasico(servicio);
    }

    public String registrarServicioEspecializado(ServicioEspecializado servicio) {
        return service.registrarServicioEspecializado(servicio);
    }

    public String agendarCita(String codigo, String cedula, String codigoServicio,
                              int cupos, String fecha) {
        return service.agendarCita(codigo, cedula, codigoServicio, cupos, fecha);
    }

    public String cancelarCita(String codigo) {
        return service.cancelarCita(codigo);
    }

    public Dueno buscarDueno(String cedula) {
        return service.buscarDueno(cedula);
    }

    public Cita buscarCita(String codigo) {
        return service.buscarCita(codigo);
    }

    public ArrayList<Cita> buscarCitasPorDueno(String cedula) {
        return service.buscarCitasPorDueno(cedula);
    }

    public ArrayList<Dueno> listarDuenos() {
        return service.listarDuenos();
    }

    public ArrayList<Servicio> listarServicios() {
        return service.listarServicios();
    }

    public int totalDuenos() {
        return service.totalDuenos();
    }
}
