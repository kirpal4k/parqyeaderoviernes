/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parqueadero;

import parqueadero.controladores.ControladorHome;
import parqueadero.modelos.Vehiculo;
import parqueadero.modelos.Cliente;
import parqueadero.vistas.VistaHome;



/**
 *
 * @author Kirpak Villa
 */
public class Parqueadero {
    


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        VistaHome vistahome = new VistaHome();
        vistahome.setVisible(true);
        Vehiculo vehiculo= new Vehiculo();
        Cliente cliente = new Cliente();
             
        ControladorHome controladorHome = 
                new ControladorHome(vistahome,vehiculo,cliente);
        
    }
    
    
}
