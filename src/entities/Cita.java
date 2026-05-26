package entities;

public class Cita {

    private String codigo;
    private Dueno dueno;
    private Servicio servicio;
    private int cantidadCupos;
    private String fechaAgendada;
    private double precioTotal;
    private String estado;

    // Una cita relaciona al dueño con el servicio elegido para su mascota.
    public Cita(String codigo, Dueno dueno, Servicio servicio, int cantidadCupos,
                String fechaAgendada, String estado) {
        this.codigo = codigo;
        this.dueno = dueno;
        this.servicio = servicio;
        this.cantidadCupos = cantidadCupos;
        this.fechaAgendada = fechaAgendada;
        this.estado = estado;
        this.precioTotal = servicio.calcularPrecioFinal() * cantidadCupos;
    }

    public void printData() {
        System.out.println("Código cita: " + codigo);
        System.out.println("Cédula dueño: " + dueno.getCedula());
        System.out.println("Dueño: " + dueno.getNombres() + " " + dueno.getApellidos());
        System.out.println("Mascota: " + dueno.getNombreMascota());
        System.out.println("Código servicio: " + servicio.getCodigo());
        System.out.println("Servicio: " + servicio.getNombre());
        System.out.println("Cupos reservados: " + cantidadCupos);
        System.out.println("Fecha agendada: " + fechaAgendada);
        System.out.println("Precio total: " + precioTotal);
        System.out.println("Estado cita: " + estado);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Dueno getDueno() {
        return dueno;
    }

    public void setDueno(Dueno dueno) {
        this.dueno = dueno;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public int getCantidadCupos() {
        return cantidadCupos;
    }

    public void setCantidadCupos(int cantidadCupos) {
        this.cantidadCupos = cantidadCupos;
    }

    public String getFechaAgendada() {
        return fechaAgendada;
    }

    public void setFechaAgendada(String fechaAgendada) {
        this.fechaAgendada = fechaAgendada;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
