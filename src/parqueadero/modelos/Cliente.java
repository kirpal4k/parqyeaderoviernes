/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parqueadero.modelos;

/**
 *
 * @author Kirpak Villa
 */
public class Cliente {
    
    private int id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String id_placa;
    private String fechaIn;
    private String fechaOut;

    public Cliente() {
    }

    public Cliente(int id, String nombre, String apellido, String telefono, String id_placa, String fechaIn, String fechaOut) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.id_placa = id_placa;
        this.fechaIn = fechaIn;
        this.fechaOut = fechaOut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getId_placa() {
        return id_placa;
    }

    public void setId_placa(String id_placa) {
        this.id_placa = id_placa;
    }

    public String getFechaIn() {
        return fechaIn;
    }

    public void setFechaIn(String fechaIn) {
        this.fechaIn = fechaIn;
    }

    public String getFechaOut() {
        return fechaOut;
    }

    public void setFechaOut(String fechaOut) {
        this.fechaOut = fechaOut;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", id_placa=" + id_placa + ", fechaIn=" + fechaIn + ", fechaOut=" + fechaOut + '}';
    }
    
    
    
}
