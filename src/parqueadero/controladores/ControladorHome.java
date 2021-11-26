/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parqueadero.controladores;

import parqueadero.modelos.ConsultasVehiculo;
import parqueadero.modelos.Vehiculo;
import parqueadero.modelos.Cliente;
import parqueadero.vistas.VistaHome;
import parqueadero.vistas.VistaIngreso;
import parqueadero.vistas.VistaSalida;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Kirpak Villa
 */
public class ControladorHome implements ActionListener {
    
    //ATRIBUTOS
    VistaHome vistahome = new VistaHome();
    Vehiculo vehiculo= new Vehiculo();
    Cliente cliente = new Cliente();

    public ControladorHome(VistaHome vistahome,
            Vehiculo vehiculo,Cliente cliente) {
        
        this.vehiculo=vehiculo;
        this.cliente=cliente;
        this.vistahome=vistahome;
        vistahome.botonAgregarte.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        ConsultasVehiculo consultasVehiculo= new ConsultasVehiculo();
        String id=vistahome.tctinicio.getText();
        
        //SI consulta una escuderia y esta SI se encuentra
        if(consultasVehiculo.buscarVehiculo(id)!=null){
            
            //lanzar la vista de retiro
            VistaSalida vistaSalida = new VistaSalida();
            vistahome.setVisible(false);
            vistaSalida.idVehiculo = id;
            vistaSalida.setVisible(true);
            ControladorSalida controladorSalida=
                    new ControladorSalida(vistaSalida,vehiculo,cliente);
            
            
        }else{
            
            //Ingresar el piloto a la escuderia
            VistaIngreso vistaIngreso = new VistaIngreso();
            vistahome.setVisible(false);
            vistaIngreso.setVisible(true);
            
            ControladorIngreso controladorIngreso = 
                    new ControladorIngreso(vistaIngreso,vehiculo,cliente);
            
        }
        
        
       
    }
    
    
    
    
}

