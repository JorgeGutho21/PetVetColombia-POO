import controllers.PetVetController;
import entities.Cita;
import entities.Dueno;
import entities.Servicio;
import entities.ServicioBasico;
import entities.ServicioEspecializado;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Autor: Jorge Alfonso Gutierrez Thomas
    // Parcial POO - Sistema de Gestión Veterinaria PetVet Colombia

    static Scanner sc = new Scanner(System.in);
    static PetVetController controlador = new PetVetController();

    public static void main(String[] args) {
        int opcion = 0;

        do {
            mostrarMenu();

            try {
                if (!sc.hasNextLine()) {
                    System.out.println("\nFin del programa.");
                    break;
                }

                opcion = Integer.parseInt(sc.nextLine());

                switch (opcion) {
                    case 1:
                        registrarDueno();
                        break;
                    case 2:
                        registrarServicioBasico();
                        break;
                    case 3:
                        registrarServicioEspecializado();
                        break;
                    case 4:
                        agendarCita();
                        break;
                    case 5:
                        cancelarCita();
                        break;
                    case 6:
                        consultarCita();
                        break;
                    case 7:
                        listarCitasPorDueno();
                        break;
                    case 8:
                        System.out.println("Total de dueños registrados: " + controlador.totalDuenos());
                        break;
                    case 9:
                        mostrarServicios();
                        break;
                    case 10:
                        mostrarDuenos();
                        break;
                    case 0:
                        System.out.println("Fin del programa.");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }
        } while (opcion != 0);
    }

    public static void mostrarMenu() {
        System.out.println("\n==============================================");
        System.out.println("       SISTEMA PETVET COLOMBIA - POO");
        System.out.println("       Autor: Jorge Alfonso Gutierrez Thomas");
        System.out.println("==============================================");
        System.out.println("1. Registrar dueño");
        System.out.println("2. Registrar servicio básico");
        System.out.println("3. Registrar servicio especializado");
        System.out.println("4. Agendar cita");
        System.out.println("5. Cancelar cita");
        System.out.println("6. Consultar cita por código");
        System.out.println("7. Listar citas por dueño");
        System.out.println("8. Mostrar total de dueños");
        System.out.println("9. Mostrar servicios");
        System.out.println("10. Mostrar dueños");
        System.out.println("0. Salir");
        System.out.print("Digite una opción: ");
    }

    public static void registrarDueno() {
        System.out.println("\n--- REGISTRO DE DUEÑO ---");

        System.out.print("Cédula: ");
        String cedula = sc.nextLine();

        if (controlador.buscarDueno(cedula) != null) {
            System.out.println("Ya existe un dueño registrado con esa cédula");
            return;
        }

        System.out.print("Nombres completos: ");
        String nombres = sc.nextLine();
        System.out.print("Apellidos completos: ");
        String apellidos = sc.nextLine();
        System.out.print("Correo electrónico: ");
        String email = sc.nextLine();
        System.out.print("Teléfono: ");
        String telefono = sc.nextLine();
        System.out.print("Dirección: ");
        String direccion = sc.nextLine();
        System.out.print("Nombre de la mascota: ");
        String mascota = sc.nextLine();
        System.out.print("Especie de la mascota: ");
        String especie = sc.nextLine();
        System.out.print("Raza de la mascota: ");
        String raza = sc.nextLine();
        System.out.print("Edad de la mascota: ");
        int edad = Integer.parseInt(sc.nextLine());

        Dueno dueno = new Dueno(cedula, nombres, apellidos, email, telefono,
                direccion, mascota, especie, raza, edad);

        System.out.println(controlador.registrarDueno(dueno));
    }

    public static void registrarServicioBasico() {
        System.out.println("\n--- REGISTRO DE SERVICIO BÁSICO ---");

        System.out.print("Código del servicio: ");
        String codigo = sc.nextLine();
        System.out.print("Nombre del servicio: ");
        String nombre = sc.nextLine();
        System.out.print("Descripción: ");
        String descripcion = sc.nextLine();
        System.out.print("Fecha disponibilidad DD/MM/YYYY: ");
        String fecha = sc.nextLine();
        System.out.print("Hora inicio HH:MM: ");
        String horaInicio = sc.nextLine();
        System.out.print("Hora fin HH:MM: ");
        String horaFin = sc.nextLine();
        System.out.print("Cupos totales: ");
        int cupos = Integer.parseInt(sc.nextLine());
        System.out.print("Precio base: ");
        double precio = Double.parseDouble(sc.nextLine());
        System.out.print("Duración estimada en minutos: ");
        int duracion = Integer.parseInt(sc.nextLine());
        System.out.print("Incluye certificado de salud Si/No: ");
        String certificado = sc.nextLine();

        ServicioBasico servicio = new ServicioBasico(codigo, nombre, descripcion, fecha,
                horaInicio, horaFin, cupos, precio, "Disponible", duracion, certificado);

        System.out.println(controlador.registrarServicioBasico(servicio));
    }

    public static void registrarServicioEspecializado() {
        System.out.println("\n--- REGISTRO DE SERVICIO ESPECIALIZADO ---");

        System.out.print("Código del servicio: ");
        String codigo = sc.nextLine();
        System.out.print("Nombre del servicio: ");
        String nombre = sc.nextLine();
        System.out.print("Descripción: ");
        String descripcion = sc.nextLine();
        System.out.print("Fecha disponibilidad DD/MM/YYYY: ");
        String fecha = sc.nextLine();
        System.out.print("Hora inicio HH:MM: ");
        String horaInicio = sc.nextLine();
        System.out.print("Hora fin HH:MM: ");
        String horaFin = sc.nextLine();
        System.out.print("Cupos totales: ");
        int cupos = Integer.parseInt(sc.nextLine());
        System.out.print("Precio base: ");
        double precio = Double.parseDouble(sc.nextLine());
        System.out.print("Especialidad requerida: ");
        String especialidad = sc.nextLine();
        System.out.print("Requiere exámenes previos Si/No: ");
        String examenes = sc.nextLine();
        System.out.print("Cargo adicional por especialización: ");
        double cargo = Double.parseDouble(sc.nextLine());

        ServicioEspecializado servicio = new ServicioEspecializado(codigo, nombre, descripcion,
                fecha, horaInicio, horaFin, cupos, precio, "Disponible",
                especialidad, examenes, cargo);

        System.out.println(controlador.registrarServicioEspecializado(servicio));
    }

    public static void agendarCita() {
        System.out.println("\n--- AGENDAR CITA ---");

        System.out.print("Código de cita: ");
        String codigo = sc.nextLine();
        System.out.print("Cédula del dueño: ");
        String cedula = sc.nextLine();
        System.out.print("Código del servicio: ");
        String codigoServicio = sc.nextLine();
        System.out.print("Cantidad de cupos a reservar: ");
        int cupos = Integer.parseInt(sc.nextLine());
        System.out.print("Fecha en que se agenda la cita DD/MM/YYYY: ");
        String fecha = sc.nextLine();

        System.out.println(controlador.agendarCita(codigo, cedula, codigoServicio, cupos, fecha));
    }

    public static void cancelarCita() {
        System.out.println("\n--- CANCELAR CITA ---");

        System.out.print("Código de cita: ");
        String codigo = sc.nextLine();
        System.out.println(controlador.cancelarCita(codigo));
    }

    public static void consultarCita() {
        System.out.println("\n--- CONSULTAR CITA POR CÓDIGO ---");

        System.out.print("Código de cita: ");
        String codigo = sc.nextLine();
        Cita cita = controlador.buscarCita(codigo);

        if (cita == null) {
            System.out.println("No se encontró la cita con ese código");
            return;
        }

        cita.printData();
    }

    public static void listarCitasPorDueno() {
        System.out.println("\n--- CITAS POR DUEÑO ---");

        System.out.print("Cédula del dueño: ");
        String cedula = sc.nextLine();

        if (controlador.buscarDueno(cedula) == null) {
            System.out.println("No se encontró el dueño con esa cédula");
            return;
        }

        ArrayList<Cita> citas = controlador.buscarCitasPorDueno(cedula);

        if (citas.size() == 0) {
            System.out.println("El dueño no tiene citas registradas.");
            return;
        }

        for (int i = 0; i < citas.size(); i++) {
            System.out.println("\nCita No. " + (i + 1));
            citas.get(i).printData();
        }
    }

    public static void mostrarServicios() {
        System.out.println("\n--- LISTA DE SERVICIOS ---");
        ArrayList<Servicio> servicios = controlador.listarServicios();

        for (int i = 0; i < servicios.size(); i++) {
            System.out.println("\nServicio No. " + (i + 1));
            servicios.get(i).printData();
        }
    }

    public static void mostrarDuenos() {
        System.out.println("\n--- LISTA DE DUEÑOS ---");
        ArrayList<Dueno> duenos = controlador.listarDuenos();

        for (int i = 0; i < duenos.size(); i++) {
            System.out.println("\nDueño No. " + (i + 1));
            duenos.get(i).printData();
        }
    }
}
