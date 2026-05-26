package entities;

public abstract class Servicio {

    // Esta clase padre reúne los datos que comparten todos los servicios veterinarios.
    private String codigo;
    private String nombre;
    private String descripcion;
    private String fechaDisponibilidad;
    private String horaInicio;
    private String horaFin;
    private int cuposTotales;
    private int cuposRestantes;
    private double precioBase;
    private String estado;

    public Servicio(String codigo, String nombre, String descripcion, String fechaDisponibilidad,
                    String horaInicio, String horaFin, int cuposTotales,
                    double precioBase, String estado) {
        validarCampo(codigo);
        this.codigo = codigo;
        setNombre(nombre);
        setDescripcion(descripcion);
        setFechaDisponibilidad(fechaDisponibilidad);
        setHoraInicio(horaInicio);
        setHoraFin(horaFin);
        setCuposTotales(cuposTotales);
        this.cuposRestantes = cuposTotales;
        setPrecioBase(precioBase);
        setEstado(estado);
    }

    // Cada clase hija resuelve el precio según el tipo de servicio.
    public abstract double calcularPrecioFinal();

    public void printData() {
        System.out.println("Código servicio: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Fecha: " + fechaDisponibilidad);
        System.out.println("Hora: " + horaInicio + " - " + horaFin);
        System.out.println("Cupos totales: " + cuposTotales);
        System.out.println("Cupos restantes: " + cuposRestantes);
        System.out.println("Precio base: " + precioBase);
        System.out.println("Precio final: " + calcularPrecioFinal());
        System.out.println("Estado: " + estado);
    }

    public void descontarCupos(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad de cupos debe ser mayor a cero");
        }
        if (cantidad > cuposRestantes) {
            throw new IllegalArgumentException("No hay cupos disponibles para este servicio");
        }

        cuposRestantes = cuposRestantes - cantidad;
    }

    public void devolverCupos(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad de cupos debe ser mayor a cero");
        }

        cuposRestantes = cuposRestantes + cantidad;
        if (cuposRestantes > cuposTotales) {
            cuposRestantes = cuposTotales;
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        validarCampo(nombre);
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        validarCampo(descripcion);
        this.descripcion = descripcion;
    }

    public String getFechaDisponibilidad() {
        return fechaDisponibilidad;
    }

    public void setFechaDisponibilidad(String fechaDisponibilidad) {
        validarCampo(fechaDisponibilidad);
        if (!fechaDisponibilidad.matches("\\d{2}/\\d{2}/\\d{4}")) {
            throw new IllegalArgumentException("La fecha debe tener formato DD/MM/YYYY");
        }
        this.fechaDisponibilidad = fechaDisponibilidad;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        validarCampo(horaInicio);
        validarHora(horaInicio);
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        validarCampo(horaFin);
        validarHora(horaFin);
        this.horaFin = horaFin;
    }

    public int getCuposTotales() {
        return cuposTotales;
    }

    public void setCuposTotales(int cuposTotales) {
        if (cuposTotales <= 0) {
            throw new IllegalArgumentException("Los cupos totales deben ser mayor a cero");
        }

        this.cuposTotales = cuposTotales;

        if (cuposRestantes > cuposTotales) {
            cuposRestantes = cuposTotales;
        }
    }

    public int getCuposRestantes() {
        return cuposRestantes;
    }

    public void setCuposRestantes(int cuposRestantes) {
        if (cuposRestantes < 0 || cuposRestantes > cuposTotales) {
            throw new IllegalArgumentException("La cantidad de cupos restantes no es válida");
        }

        this.cuposRestantes = cuposRestantes;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        if (precioBase <= 0) {
            throw new IllegalArgumentException("El precio del servicio debe ser mayor a cero");
        }

        this.precioBase = precioBase;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        validarCampo(estado);
        if (!estado.equalsIgnoreCase("Disponible") &&
                !estado.equalsIgnoreCase("En Curso") &&
                !estado.equalsIgnoreCase("Finalizado") &&
                !estado.equalsIgnoreCase("Cancelado")) {
            throw new IllegalArgumentException("Estado de servicio no válido");
        }

        this.estado = estado;
    }

    private void validarCampo(String dato) {
        if (dato == null || dato.trim().equals("")) {
            throw new IllegalArgumentException("Todos los campos son obligatorios");
        }
    }

    private void validarHora(String hora) {
        if (!hora.matches("([01]\\d|2[0-3]):[0-5]\\d")) {
            throw new IllegalArgumentException("La hora debe tener formato HH:MM");
        }
    }
}
