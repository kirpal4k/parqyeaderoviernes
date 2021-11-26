/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parqueadero.modelos;

/**
 *
 * @author Kirpak Villa
 */
public class Vehiculo {
    
    private String id;
    private String modelo;
    private int vtsegundos;

    public Vehiculo() {
    }

    public Vehiculo(String id, String modelo, int vtsegundos) {
        this.id = id;
        this.modelo = modelo;
        this.vtsegundos = vtsegundos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getVtsegundos() {
        return vtsegundos;
    }

    public void setVtsegundos(int vtsegundos) {
        this.vtsegundos = vtsegundos;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "id=" + id + ", modelo=" + modelo + ", vtsegundos=" + vtsegundos + '}';
    }
    
    
    
}
