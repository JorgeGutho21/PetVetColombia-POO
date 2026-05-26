package entities;

public abstract class Servicio {

    // Esta clase padre representa la informacion comun de cualquier servicio veterinario
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
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaDisponibilidad = fechaDisponibilidad;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.cuposTotales = cuposTotales;
        this.cuposRestantes = cuposTotales;
        this.precioBase = precioBase;
        this.estado = estado;
    }

    // Metodo abstracto: cada hijo calcula el precio final a su manera
    public abstract double calcularPrecioFinal();

    public void printData() {
        System.out.println("Codigo servicio: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Descripcion: " + descripcion);
        System.out.println("Fecha: " + fechaDisponibilidad);
        System.out.println("Hora: " + horaInicio + " - " + horaFin);
        System.out.println("Cupos totales: " + cuposTotales);
        System.out.println("Cupos restantes: " + cuposRestantes);
        System.out.println("Precio base: " + precioBase);
        System.out.println("Precio final: " + calcularPrecioFinal());
        System.out.println("Estado: " + estado);
    }

    public void descontarCupos(int cantidad) {
        cuposRestantes = cuposRestantes - cantidad;
    }

    public void devolverCupos(int cantidad) {
        cuposRestantes = cuposRestantes + cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaDisponibilidad() {
        return fechaDisponibilidad;
    }

    public void setFechaDisponibilidad(String fechaDisponibilidad) {
        this.fechaDisponibilidad = fechaDisponibilidad;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public int getCuposTotales() {
        return cuposTotales;
    }

    public void setCuposTotales(int cuposTotales) {
        this.cuposTotales = cuposTotales;
    }

    public int getCuposRestantes() {
        return cuposRestantes;
    }

    public void setCuposRestantes(int cuposRestantes) {
        this.cuposRestantes = cuposRestantes;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
