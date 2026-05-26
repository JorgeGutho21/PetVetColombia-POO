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
        validarCampo(cedula);
        this.cedula = cedula;
        setNombres(nombres);
        setApellidos(apellidos);
        setEmail(email);
        setTelefono(telefono);
        setDireccion(direccion);
        setNombreMascota(nombreMascota);
        setEspecieMascota(especieMascota);
        setRazaMascota(razaMascota);
        setEdadMascota(edadMascota);
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        validarCampo(nombres);
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        validarCampo(apellidos);
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        validarCampo(email);
        if (!email.contains("@")) {
            throw new IllegalArgumentException("El email debe contener el símbolo @");
        }
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        validarCampo(telefono);
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        validarCampo(direccion);
        this.direccion = direccion;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        validarCampo(nombreMascota);
        this.nombreMascota = nombreMascota;
    }

    public String getEspecieMascota() {
        return especieMascota;
    }

    public void setEspecieMascota(String especieMascota) {
        validarCampo(especieMascota);
        if (!especieMascota.equalsIgnoreCase("Perro") &&
                !especieMascota.equalsIgnoreCase("Gato") &&
                !especieMascota.equalsIgnoreCase("Conejo") &&
                !especieMascota.equalsIgnoreCase("Ave") &&
                !especieMascota.equalsIgnoreCase("Otro")) {
            throw new IllegalArgumentException("La especie debe ser Perro, Gato, Conejo, Ave u Otro");
        }
        this.especieMascota = especieMascota;
    }

    public String getRazaMascota() {
        return razaMascota;
    }

    public void setRazaMascota(String razaMascota) {
        validarCampo(razaMascota);
        this.razaMascota = razaMascota;
    }

    public int getEdadMascota() {
        return edadMascota;
    }

    public void setEdadMascota(int edadMascota) {
        if (edadMascota < 0) {
            throw new IllegalArgumentException("La edad de la mascota debe ser mayor o igual a 0");
        }

        this.edadMascota = edadMascota;
    }

    private void validarCampo(String dato) {
        if (dato == null || dato.trim().equals("")) {
            throw new IllegalArgumentException("Todos los campos son obligatorios");
        }
    }

    public void printData() {
        System.out.println("Cédula: " + cedula);
        System.out.println("Dueño: " + nombres + " " + apellidos);
        System.out.println("Email: " + email);
        System.out.println("Teléfono: " + telefono);
        System.out.println("Dirección: " + direccion);
        System.out.println("Mascota: " + nombreMascota);
        System.out.println("Especie: " + especieMascota);
        System.out.println("Raza: " + razaMascota);
        System.out.println("Edad mascota: " + edadMascota);
    }
}
