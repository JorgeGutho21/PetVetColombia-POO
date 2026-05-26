package entities;

public abstract class Servicio {

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

    public abstract double calcularPrecioFinal();

    public void printData() {
        System.out.println("Codigo servicio: " + codigo);
        System.out.println("Nombre: " + nombre);
    }

    public String getCodigo() {
        return codigo;
    }

    public double getPrecioBase() {
        return precioBase;
    }
}
