package entities;

public class ServicioBasico extends Servicio {

    private int duracionEstimada;
    private String incluyeCertificado;

    public ServicioBasico(String codigo, String nombre, String descripcion, String fechaDisponibilidad,
                          String horaInicio, String horaFin, int cuposTotales,
                          double precioBase, String estado, int duracionEstimada,
                          String incluyeCertificado) {
        super(codigo, nombre, descripcion, fechaDisponibilidad, horaInicio, horaFin,
                cuposTotales, precioBase, estado);
        this.duracionEstimada = duracionEstimada;
        this.incluyeCertificado = incluyeCertificado;
    }

    @Override
    public double calcularPrecioFinal() {
        // El servicio basico no tiene cargo adicional
        return getPrecioBase();
    }

    @Override
    public void printData() {
        super.printData();
        System.out.println("Tipo: Basico");
        System.out.println("Duracion estimada: " + duracionEstimada + " minutos");
        System.out.println("Incluye certificado: " + incluyeCertificado);
    }

    public int getDuracionEstimada() {
        return duracionEstimada;
    }

    public void setDuracionEstimada(int duracionEstimada) {
        this.duracionEstimada = duracionEstimada;
    }

    public String getIncluyeCertificado() {
        return incluyeCertificado;
    }

    public void setIncluyeCertificado(String incluyeCertificado) {
        this.incluyeCertificado = incluyeCertificado;
    }
}
