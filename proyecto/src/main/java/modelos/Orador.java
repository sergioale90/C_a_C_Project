package modelos;

public class Orador {
    private String nombre;
    private String apellido;
    private String email;
    private String tema;
    private boolean estado;
    private String id;
    private String fechaAlta;

    public Orador(String nombre, String apellido, String email, String tema) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.tema = tema;
        estado = true;
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
    public String getTema() {
        return tema;
    }
    public void setTema(String tema) {
        this.tema = tema;
    }
    public boolean isEstado() {
        return estado;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getFechaAlta() {
        return fechaAlta;
    }
    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    @Override
    public String toString() {
        return "Orador [nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", tema=" + tema
                + ", estado=" + estado + ", id=" + id + ", fechaAlta=" + fechaAlta + "]";
    }

}
