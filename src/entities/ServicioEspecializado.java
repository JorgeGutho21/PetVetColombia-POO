package entities;

public class ServicioEspecializado extends Servicio {

    private String especialidadRequerida;
    private String requiereExamenes;
    private double cargoAdicional;

    public ServicioEspecializado(String codigo, String nombre, String descripcion,
                                 String fechaDisponibilidad, String horaInicio,
                                 String horaFin, int cuposTotales, double precioBase,
                                 String estado, String especialidadRequerida,
                                 String requiereExamenes, double cargoAdicional) {
        super(codigo, nombre, descripcion, fechaDisponibilidad, horaInicio, horaFin,
                cuposTotales, precioBase, estado);
        this.especialidadRequerida = especialidadRequerida;
        this.requiereExamenes = requiereExamenes;
        this.cargoAdicional = cargoAdicional;
    }

    @Override
    public double calcularPrecioFinal() {
        // El servicio especializado necesita sumar el cargo del especialista.
        return getPrecioBase() + cargoAdicional;
    }

    @Override
    public void printData() {
        super.printData();
        System.out.println("Tipo: Especializado");
        System.out.println("Especialidad requerida: " + especialidadRequerida);
        System.out.println("Requiere exámenes: " + requiereExamenes);
        System.out.println("Cargo adicional: " + cargoAdicional);
    }

    public String getEspecialidadRequerida() {
        return especialidadRequerida;
    }

    public void setEspecialidadRequerida(String especialidadRequerida) {
        this.especialidadRequerida = especialidadRequerida;
    }

    public String getRequiereExamenes() {
        return requiereExamenes;
    }

    public void setRequiereExamenes(String requiereExamenes) {
        this.requiereExamenes = requiereExamenes;
    }

    public double getCargoAdicional() {
        return cargoAdicional;
    }

    public void setCargoAdicional(double cargoAdicional) {
        this.cargoAdicional = cargoAdicional;
    }
}
