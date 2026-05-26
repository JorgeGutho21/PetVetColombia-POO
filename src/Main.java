import entities.Cita;
import entities.Dueno;
import entities.Servicio;
import entities.ServicioBasico;
import entities.ServicioEspecializado;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Autor: Jorge Alfonso Gutierrez Thomas
    // Parcial POO - Sistema de Gestion Veterinaria PetVet Colombia

    static Scanner sc = new Scanner(System.in);

    // Se usan ArrayList porque la rubrica pide colecciones de objetos en memoria
    static ArrayList<Dueno> duenos = new ArrayList<>();
    static ArrayList<Servicio> servicios = new ArrayList<>();
    static ArrayList<Cita> citas = new ArrayList<>();

    public static void main(String[] args) {

        int op = 0;

        cargarDatosPrueba();

        do {
            System.out.println("\n==============================================");
            System.out.println("       SISTEMA PETVET COLOMBIA - POO");
            System.out.println("       Autor: Jorge Alfonso Gutierrez Thomas");
            System.out.println("==============================================");
            System.out.println("1. Registrar dueño");
            System.out.println("2. Registrar servicio basico");
            System.out.println("3. Registrar servicio especializado");
            System.out.println("4. Agendar cita");
            System.out.println("5. Cancelar cita");
            System.out.println("6. Consultar cita por codigo");
            System.out.println("7. Listar citas por dueño");
            System.out.println("8. Mostrar total de dueños");
            System.out.println("9. Mostrar servicios");
            System.out.println("10. Mostrar dueños");
            System.out.println("0. Salir");
            System.out.print("Digite una opcion: ");

            try {
                op = Integer.parseInt(sc.nextLine());

                switch (op) {
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
                        System.out.println("Total de dueños registrados: " + duenos.size());
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
                        System.out.println("Opcion no valida.");
                        break;
                }

            } catch (Exception e) {
                System.out.println("Ocurrio un error: " + e.getMessage());
            }

        } while (op != 0);
    }

    public static void registrarDueno() {
        System.out.println("\n--- REGISTRO DE DUEÑO ---");

        System.out.print("Cedula: ");
        String cedula = sc.nextLine();

        if (buscarDueno(cedula) != null) {
            System.out.println("Ya existe un dueño registrado con esa cedula");
            return;
        }

        System.out.print("Nombres completos: ");
        String nombres = sc.nextLine();

        System.out.print("Apellidos completos: ");
        String apellidos = sc.nextLine();

        System.out.print("Correo electronico: ");
        String email = sc.nextLine();

        if (!email.contains("@")) {
            System.out.println("El email debe contener el simbolo @");
            return;
        }

        System.out.print("Telefono: ");
        String telefono = sc.nextLine();

        System.out.print("Direccion: ");
        String direccion = sc.nextLine();

        System.out.print("Nombre de la mascota: ");
        String mascota = sc.nextLine();

        System.out.print("Especie de la mascota: ");
        String especie = sc.nextLine();

        System.out.print("Raza de la mascota: ");
        String raza = sc.nextLine();

        System.out.print("Edad de la mascota: ");
        int edad = Integer.parseInt(sc.nextLine());

        if (campoVacio(cedula) || campoVacio(nombres) || campoVacio(apellidos) ||
                campoVacio(email) || campoVacio(telefono) || campoVacio(direccion) ||
                campoVacio(mascota) || campoVacio(especie) || campoVacio(raza)) {
            System.out.println("Todos los campos son obligatorios");
            return;
        }

        if (edad < 0) {
            System.out.println("La edad de la mascota debe ser mayor o igual a 0");
            return;
        }

        Dueno d = new Dueno(cedula, nombres, apellidos, email, telefono,
                direccion, mascota, especie, raza, edad);

        duenos.add(d);

        System.out.println("Dueño registrado correctamente.");
    }

    public static void registrarServicioBasico() {
        System.out.println("\n--- REGISTRO DE SERVICIO BASICO ---");

        System.out.print("Codigo del servicio: ");
        String codigo = sc.nextLine();

        if (buscarServicio(codigo) != null) {
            System.out.println("Ya existe un servicio registrado con ese codigo");
            return;
        }

        System.out.print("Nombre del servicio: ");
        String nombre = sc.nextLine();

        System.out.print("Descripcion: ");
        String descripcion = sc.nextLine();

        System.out.print("Fecha disponibilidad DD/MM/YYYY: ");
        String fecha = sc.nextLine();

        System.out.print("Hora inicio HH:MM: ");
        String hi = sc.nextLine();

        System.out.print("Hora fin HH:MM: ");
        String hf = sc.nextLine();

        System.out.print("Cupos totales: ");
        int cupos = Integer.parseInt(sc.nextLine());

        if (cupos <= 0) {
            System.out.println("Los cupos totales deben ser mayor a cero");
            return;
        }

        System.out.print("Precio base: ");
        double precio = Double.parseDouble(sc.nextLine());

        if (precio <= 0) {
            System.out.println("El precio del servicio debe ser mayor a cero");
            return;
        }

        System.out.print("Duracion estimada en minutos: ");
        int duracion = Integer.parseInt(sc.nextLine());

        System.out.print("Incluye certificado de salud Si/No: ");
        String certificado = sc.nextLine();

        ServicioBasico s = new ServicioBasico(codigo, nombre, descripcion, fecha,
                hi, hf, cupos, precio, "Disponible", duracion, certificado);

        servicios.add(s);

        System.out.println("Servicio basico registrado correctamente.");
    }

    public static void registrarServicioEspecializado() {
        System.out.println("\n--- REGISTRO DE SERVICIO ESPECIALIZADO ---");

        System.out.print("Codigo del servicio: ");
        String codigo = sc.nextLine();

        if (buscarServicio(codigo) != null) {
            System.out.println("Ya existe un servicio registrado con ese codigo");
            return;
        }

        System.out.print("Nombre del servicio: ");
        String nombre = sc.nextLine();

        System.out.print("Descripcion: ");
        String descripcion = sc.nextLine();

        System.out.print("Fecha disponibilidad DD/MM/YYYY: ");
        String fecha = sc.nextLine();

        System.out.print("Hora inicio HH:MM: ");
        String hi = sc.nextLine();

        System.out.print("Hora fin HH:MM: ");
        String hf = sc.nextLine();

        System.out.print("Cupos totales: ");
        int cupos = Integer.parseInt(sc.nextLine());

        if (cupos <= 0) {
            System.out.println("Los cupos totales deben ser mayor a cero");
            return;
        }

        System.out.print("Precio base: ");
        double precio = Double.parseDouble(sc.nextLine());

        if (precio <= 0) {
            System.out.println("El precio del servicio debe ser mayor a cero");
            return;
        }

        System.out.print("Especialidad requerida: ");
        String especialidad = sc.nextLine();

        System.out.print("Requiere examenes previos Si/No: ");
        String examenes = sc.nextLine();

        System.out.print("Cargo adicional por especializacion: ");
        double cargo = Double.parseDouble(sc.nextLine());

        ServicioEspecializado s = new ServicioEspecializado(codigo, nombre, descripcion,
                fecha, hi, hf, cupos, precio, "Disponible", especialidad, examenes, cargo);

        servicios.add(s);

        System.out.println("Servicio especializado registrado correctamente.");
    }

    public static void agendarCita() {
        System.out.println("\n--- AGENDAR CITA ---");

        System.out.print("Codigo de cita: ");
        String codigoCita = sc.nextLine();

        if (buscarCita(codigoCita) != null) {
            System.out.println("Ya existe una cita registrada con ese codigo");
            return;
        }

        System.out.print("Cedula del dueño: ");
        String cedula = sc.nextLine();

        Dueno d = buscarDueno(cedula);

        if (d == null) {
            System.out.println("No se encontro el dueño con esa cedula");
            return;
        }

        System.out.print("Codigo del servicio: ");
        String codigoServicio = sc.nextLine();

        Servicio s = buscarServicio(codigoServicio);

        if (s == null) {
            System.out.println("No se encontro el servicio con ese codigo");
            return;
        }

        if (!s.getEstado().equalsIgnoreCase("Disponible")) {
            System.out.println("No se puede agendar en un servicio que no esta Disponible");
            return;
        }

        System.out.print("Cantidad de cupos a reservar: ");
        int cupos = Integer.parseInt(sc.nextLine());

        if (cupos < 1 || cupos > 3) {
            System.out.println("No se pueden reservar mas de 3 cupos por cita");
            return;
        }

        if (s.getCuposRestantes() < cupos) {
            System.out.println("No hay cupos disponibles para este servicio");
            return;
        }

        System.out.print("Fecha en que se agenda la cita DD/MM/YYYY: ");
        String fecha = sc.nextLine();

        Cita c = new Cita(codigoCita, d, s, cupos, fecha, "Confirmada");

        citas.add(c);
        s.descontarCupos(cupos);

        System.out.println("Cita agendada correctamente.");
        System.out.println("Precio total de la cita: " + c.getPrecioTotal());
        System.out.println("Cupos restantes del servicio: " + s.getCuposRestantes());
    }

    public static void cancelarCita() {
        System.out.println("\n--- CANCELAR CITA ---");

        System.out.print("Codigo de cita: ");
        String codigo = sc.nextLine();

        Cita c = buscarCita(codigo);

        if (c == null) {
            System.out.println("No se encontro la cita con ese codigo");
            return;
        }

        if (c.getEstado().equalsIgnoreCase("Cancelada")) {
            System.out.println("La cita ya se encuentra cancelada");
            return;
        }

        c.setEstado("Cancelada");
        c.getServicio().devolverCupos(c.getCantidadCupos());

        System.out.println("Cita cancelada correctamente.");
        System.out.println("Cupos devueltos al servicio: " + c.getCantidadCupos());
    }

    public static void consultarCita() {
        System.out.println("\n--- CONSULTAR CITA POR CODIGO ---");

        System.out.print("Codigo de cita: ");
        String codigo = sc.nextLine();

        Cita c = buscarCita(codigo);

        if (c == null) {
            System.out.println("No se encontro la cita con ese codigo");
            return;
        }

        c.printData();
    }

    public static void listarCitasPorDueno() {
        System.out.println("\n--- CITAS POR DUEÑO ---");

        System.out.print("Cedula del dueño: ");
        String cedula = sc.nextLine();

        Dueno d = buscarDueno(cedula);

        if (d == null) {
            System.out.println("No se encontro el dueño con esa cedula");
            return;
        }

        int cont = 0;

        for (int i = 0; i < citas.size(); i++) {
            if (citas.get(i).getDueno().getCedula().equals(cedula)) {
                System.out.println("\nCita No. " + (cont + 1));
                citas.get(i).printData();
                cont++;
            }
        }

        if (cont == 0) {
            System.out.println("El dueño no tiene citas registradas.");
        }
    }

    public static void mostrarServicios() {
        System.out.println("\n--- LISTA DE SERVICIOS ---");

        if (servicios.size() == 0) {
            System.out.println("No hay servicios registrados.");
            return;
        }

        for (int i = 0; i < servicios.size(); i++) {
            System.out.println("\nServicio No. " + (i + 1));
            servicios.get(i).printData();
        }
    }

    public static void mostrarDuenos() {
        System.out.println("\n--- LISTA DE DUEÑOS ---");

        if (duenos.size() == 0) {
            System.out.println("No hay dueños registrados.");
            return;
        }

        for (int i = 0; i < duenos.size(); i++) {
            System.out.println("\nDueño No. " + (i + 1));
            duenos.get(i).printData();
        }
    }

    public static Dueno buscarDueno(String cedula) {
        for (int i = 0; i < duenos.size(); i++) {
            if (duenos.get(i).getCedula().equals(cedula)) {
                return duenos.get(i);
            }
        }
        return null;
    }

    public static Servicio buscarServicio(String codigo) {
        for (int i = 0; i < servicios.size(); i++) {
            if (servicios.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                return servicios.get(i);
            }
        }
        return null;
    }

    public static Cita buscarCita(String codigo) {
        for (int i = 0; i < citas.size(); i++) {
            if (citas.get(i).getCodigo().equalsIgnoreCase(codigo)) {
                return citas.get(i);
            }
        }
        return null;
    }

    public static boolean campoVacio(String dato) {
        return dato == null || dato.trim().equals("");
    }

    public static void cargarDatosPrueba() {
        // Estos datos permiten probar rapido el caso de uso del parcial sin digitar todo desde cero

        Dueno d = new Dueno("1122334455", "Sofia", "Morales",
                "sofia.morales@email.com", "3208765432",
                "Cra 10 #45-20, Bogota", "Max", "Perro",
                "Golden Retriever", 3);

        duenos.add(d);

        Servicio s1 = new ServicioEspecializado("SV050", "Cirugia de cadera",
                "Procedimiento especializado para mascota",
                "10/04/2025", "09:00", "12:00",
                2, 350000, "Disponible",
                "Ortopedia", "Si", 80000);

        Servicio s2 = new ServicioBasico("SV001", "Consulta general",
                "Revision general de la mascota",
                "10/04/2025", "08:00", "08:30",
                5, 50000, "Disponible",
                30, "Si");

        servicios.add(s1);
        servicios.add(s2);
    }
}
