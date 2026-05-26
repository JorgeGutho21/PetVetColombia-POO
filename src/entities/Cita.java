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
        validarCampo(codigo);
        this.codigo = codigo;
        setDueno(dueno);
        setServicio(servicio);
        setCantidadCupos(cantidadCupos);
        setFechaAgendada(fechaAgendada);
        setEstado(estado);
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

    public Dueno getDueno() {
        return dueno;
    }

    public void setDueno(Dueno dueno) {
        if (dueno == null) {
            throw new IllegalArgumentException("El dueño es obligatorio");
        }
        this.dueno = dueno;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        if (servicio == null) {
            throw new IllegalArgumentException("El servicio es obligatorio");
        }
        this.servicio = servicio;

        if (cantidadCupos > 0) {
            precioTotal = servicio.calcularPrecioFinal() * cantidadCupos;
        }
    }

    public int getCantidadCupos() {
        return cantidadCupos;
    }

    public void setCantidadCupos(int cantidadCupos) {
        if (cantidadCupos < 1 || cantidadCupos > 3) {
            throw new IllegalArgumentException("La cita debe tener entre 1 y 3 cupos");
        }

        this.cantidadCupos = cantidadCupos;

        if (servicio != null) {
            precioTotal = servicio.calcularPrecioFinal() * cantidadCupos;
        }
    }

    public String getFechaAgendada() {
        return fechaAgendada;
    }

    public void setFechaAgendada(String fechaAgendada) {
        validarCampo(fechaAgendada);
        if (!fechaAgendada.matches("\\d{2}/\\d{2}/\\d{4}")) {
            throw new IllegalArgumentException("La fecha debe tener formato DD/MM/YYYY");
        }
        this.fechaAgendada = fechaAgendada;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        validarCampo(estado);
        if (!estado.equalsIgnoreCase("Confirmada") &&
                !estado.equalsIgnoreCase("Cancelada") &&
                !estado.equalsIgnoreCase("Completada")) {
            throw new IllegalArgumentException("Estado de cita no válido");
        }

        this.estado = estado;
    }

    private void validarCampo(String dato) {
        if (dato == null || dato.trim().equals("")) {
            throw new IllegalArgumentException("Todos los campos son obligatorios");
        }
    }
}
