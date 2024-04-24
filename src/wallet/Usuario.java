package wallet;

public class Usuario {

    private String nombre, apellido, email, rut;
    private int pass;

    /**
     * Constructor de la clase Usuario.
     * 
     * @param nombre   Nombre del usuario.
     * @param apellido Apellido del usuario.
     * @param email    Correo electrónico del usuario.
     * @param rut      RUT del usuario
     * @param pass     Contraseña del usuario titular de la cuenta (int porque esta
     *                 pensado como clave numérica de cajero).
     */
    public Usuario(String nombre, String apellido, String email, String rut, int pass) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.rut = rut;
        this.pass = pass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getPass() {
        return pass;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }
}