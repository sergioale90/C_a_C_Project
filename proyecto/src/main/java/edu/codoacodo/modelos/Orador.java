package edu.codoacodo.modelos;
public class Orador {
    private String nombre;
    private String apellido;
    private String email;
    private String tema;
    private boolean estado;
    private int id;
    private String fechaAlta;

    public Orador(String nombre, String apellido, String email, String tema, String fechaAlta, boolean estado, int id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.tema = tema;
        this.estado = estado;
        this.id = id;
        this.fechaAlta = fechaAlta;
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
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getfechaAlta() {
        return fechaAlta;
    }
    public void setfechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

}
