package repositories;

import entities.Cita;
import entities.Dueno;
import entities.Servicio;

import java.util.ArrayList;

public class PetVetRepository {

    // Esta capa guarda las listas en memoria, como solicita el ejercicio.
    private ArrayList<Dueno> duenos = new ArrayList<>();
    private ArrayList<Servicio> servicios = new ArrayList<>();
    private ArrayList<Cita> citas = new ArrayList<>();

    public void guardarDueno(Dueno dueno) {
        duenos.add(dueno);
    }

    public void guardarServicio(Servicio servicio) {
        servicios.add(servicio);
    }

    public void guardarCita(Cita cita) {
        citas.add(cita);
    }

    public Dueno buscarDueno(String cedula) {
        for (int i = 0; i < duenos.size(); i++) {
            if (duenos.get(i).getCedula().equals(cedula)) {
                return duenos.get(i);
            }
        }
        return null;
    }

    public Servicio buscarServicio(String codigo) {
        for (int i = 0; i < servicios.size(); i++) {
            if (servicios.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                return servicios.get(i);
            }
        }
        return null;
    }

    public Cita buscarCita(String codigo) {
        for (int i = 0; i < citas.size(); i++) {
            if (citas.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                return citas.get(i);
            }
        }
        return null;
    }

    public ArrayList<Cita> buscarCitasPorDueno(String cedula) {
        ArrayList<Cita> resultado = new ArrayList<>();

        for (int i = 0; i < citas.size(); i++) {
            if (citas.get(i).getDueno().getCedula().equals(cedula)) {
                resultado.add(citas.get(i));
            }
        }
        return resultado;
    }

    public ArrayList<Dueno> listarDuenos() {
        return duenos;
    }

    public ArrayList<Servicio> listarServicios() {
        return servicios;
    }
}
