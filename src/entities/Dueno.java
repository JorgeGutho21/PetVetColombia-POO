package entities;

public class Dueno {

    // Datos del dueño
    private String cedula;
    private String nombres;
    private String apellidos;
    private String email;
    private String telefono;
    private String direccion;

    // Datos de la mascota principal
    private String nombreMascota;
    private String especieMascota;
    private String razaMascota;
    private int edadMascota;

    public Dueno(String cedula, String nombres, String apellidos, String email, String telefono,
                 String direccion, String nombreMascota, String especieMascota,
                 String razaMascota, int edadMascota) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.nombreMascota = nombreMascota;
        this.especieMascota = especieMascota;
        this.razaMascota = razaMascota;
        this.edadMascota = edadMascota;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getEspecieMascota() {
        return especieMascota;
    }

    public void setEspecieMascota(String especieMascota) {
        this.especieMascota = especieMascota;
    }

    public String getRazaMascota() {
        return razaMascota;
    }

    public void setRazaMascota(String razaMascota) {
        this.razaMascota = razaMascota;
    }

    public int getEdadMascota() {
        return edadMascota;
    }

    public void setEdadMascota(int edadMascota) {
        this.edadMascota = edadMascota;
    }

    public void printData() {
        System.out.println("Cedula: " + cedula);
        System.out.println("Dueño: " + nombres + " " + apellidos);
        System.out.println("Email: " + email);
        System.out.println("Telefono: " + telefono);
        System.out.println("Direccion: " + direccion);
        System.out.println("Mascota: " + nombreMascota);
        System.out.println("Especie: " + especieMascota);
        System.out.println("Raza: " + razaMascota);
        System.out.println("Edad mascota: " + edadMascota);
    }
}
