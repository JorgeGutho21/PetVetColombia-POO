package services;

import entities.Cita;
import entities.Dueno;
import entities.Servicio;
import entities.ServicioBasico;
import entities.ServicioEspecializado;
import repositories.PetVetRepository;

import java.util.ArrayList;

public class PetVetService {

    // En esta capa quedan las reglas: registrar, agendar, cancelar y validar.
    private PetVetRepository repository = new PetVetRepository();

    public String registrarDueno(Dueno dueno) {
        if (repository.buscarDueno(dueno.getCedula()) != null) {
            return "Ya existe un dueño registrado con esa cédula";
        }

        if (campoVacio(dueno.getCedula()) || campoVacio(dueno.getNombres()) ||
                campoVacio(dueno.getApellidos()) || campoVacio(dueno.getEmail()) ||
                campoVacio(dueno.getTelefono()) || campoVacio(dueno.getDireccion()) ||
                campoVacio(dueno.getNombreMascota()) || campoVacio(dueno.getEspecieMascota()) ||
                campoVacio(dueno.getRazaMascota())) {
            return "Todos los campos son obligatorios";
        }

        if (!dueno.getEmail().contains("@")) {
            return "El email debe contener el símbolo @";
        }

        if (dueno.getEdadMascota() < 0) {
            return "La edad de la mascota debe ser mayor o igual a 0";
        }

        repository.guardarDueno(dueno);
        return "Dueño registrado correctamente.";
    }

    public String registrarServicioBasico(ServicioBasico servicio) {
        String mensaje = validarServicio(servicio);

        if (mensaje != null) {
            return mensaje;
        }

        if (servicio.getDuracionEstimada() <= 0 ||
                campoVacio(servicio.getIncluyeCertificado())) {
            return "Todos los campos son obligatorios";
        }

        repository.guardarServicio(servicio);
        return "Servicio básico registrado correctamente.";
    }

    public String registrarServicioEspecializado(ServicioEspecializado servicio) {
        String mensaje = validarServicio(servicio);

        if (mensaje != null) {
            return mensaje;
        }

        if (campoVacio(servicio.getEspecialidadRequerida()) ||
                campoVacio(servicio.getRequiereExamenes())) {
            return "Todos los campos son obligatorios";
        }

        if (servicio.getCargoAdicional() < 0) {
            return "El cargo adicional no puede ser negativo";
        }

        repository.guardarServicio(servicio);
        return "Servicio especializado registrado correctamente.";
    }

    private String validarServicio(Servicio servicio) {
        if (repository.buscarServicio(servicio.getCodigo()) != null) {
            return "Ya existe un servicio registrado con ese código";
        }

        if (campoVacio(servicio.getCodigo()) || campoVacio(servicio.getNombre()) ||
                campoVacio(servicio.getDescripcion()) ||
                campoVacio(servicio.getFechaDisponibilidad()) ||
                campoVacio(servicio.getHoraInicio()) || campoVacio(servicio.getHoraFin())) {
            return "Todos los campos son obligatorios";
        }

        if (servicio.getCuposTotales() <= 0) {
            return "Los cupos totales deben ser mayor a cero";
        }

        if (servicio.getPrecioBase() <= 0) {
            return "El precio del servicio debe ser mayor a cero";
        }

        return null;
    }

    public String agendarCita(String codigo, String cedula, String codigoServicio,
                              int cupos, String fecha) {
        if (campoVacio(codigo) || campoVacio(cedula) || campoVacio(codigoServicio) ||
                campoVacio(fecha)) {
            return "Todos los campos son obligatorios";
        }

        if (repository.buscarCita(codigo) != null) {
            return "Ya existe una cita registrada con ese código";
        }

        Dueno dueno = repository.buscarDueno(cedula);
        if (dueno == null) {
            return "No se encontró el dueño con esa cédula";
        }

        Servicio servicio = repository.buscarServicio(codigoServicio);
        if (servicio == null) {
            return "No se encontró el servicio con ese código";
        }

        if (!servicio.getEstado().equalsIgnoreCase("Disponible")) {
            return "No se puede agendar en un servicio que no está Disponible";
        }

        if (cupos < 1) {
            return "La cita debe reservar mínimo 1 cupo";
        }

        if (cupos > 3) {
            return "No se pueden reservar más de 3 cupos por cita";
        }

        if (servicio.getCuposRestantes() < cupos) {
            return "No hay cupos disponibles para este servicio";
        }

        Cita cita = new Cita(codigo, dueno, servicio, cupos, fecha, "Confirmada");
        repository.guardarCita(cita);
        servicio.descontarCupos(cupos);

        return "Cita agendada correctamente.\n" +
                "Precio total de la cita: " + cita.getPrecioTotal() + "\n" +
                "Cupos restantes del servicio: " + servicio.getCuposRestantes();
    }

    public String cancelarCita(String codigo) {
        if (campoVacio(codigo)) {
            return "Todos los campos son obligatorios";
        }

        Cita cita = repository.buscarCita(codigo);

        if (cita == null) {
            return "No se encontró la cita con ese código";
        }

        if (cita.getEstado().equalsIgnoreCase("Cancelada")) {
            return "La cita ya se encuentra cancelada";
        }

        cita.setEstado("Cancelada");
        cita.getServicio().devolverCupos(cita.getCantidadCupos());

        return "Cita cancelada correctamente.\n" +
                "Cupos devueltos al servicio: " + cita.getCantidadCupos();
    }

    public Dueno buscarDueno(String cedula) {
        return repository.buscarDueno(cedula);
    }

    public Cita buscarCita(String codigo) {
        return repository.buscarCita(codigo);
    }

    public ArrayList<Cita> buscarCitasPorDueno(String cedula) {
        return repository.buscarCitasPorDueno(cedula);
    }

    public ArrayList<Dueno> listarDuenos() {
        return repository.listarDuenos();
    }

    public ArrayList<Servicio> listarServicios() {
        return repository.listarServicios();
    }

    public int totalDuenos() {
        return repository.listarDuenos().size();
    }

    private boolean campoVacio(String dato) {
        return dato == null || dato.trim().equals("");
    }
}
