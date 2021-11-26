/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parqueadero.controladores;

import parqueadero.modelos.ConsultasVehiculo;
import parqueadero.modelos.ConsultasCliente;
import parqueadero.modelos.Vehiculo;
import parqueadero.modelos.Cliente;
import parqueadero.vistas.VistaHome;
import parqueadero.vistas.VistaIngreso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Kirpak Villa
 */
public class ControladorIngreso implements ActionListener {
    
    //ATRIBUTOS
    VistaIngreso vistaingreso = new VistaIngreso();
    Vehiculo vehiculo= new Vehiculo();
    Cliente cliente = new Cliente();
    
    public ControladorIngreso(VistaIngreso vistaingreso,
            Vehiculo vehiculo,Cliente cliente) {
        
        this.vehiculo=vehiculo;
        this.cliente=cliente;
        this.vistaingreso=vistaingreso;
        vistaingreso.botonAgregar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
         ConsultasVehiculo consultasVehiculo= 
                 new ConsultasVehiculo();
         
         ConsultasCliente consultasCliente = 
                 new ConsultasCliente();
         
         
         //registro de escuderia
         vehiculo.setId(vistaingreso.cajaIdPlaca.getText());
         vehiculo.setModelo(vistaingreso.cajaModelo.getText());
         vehiculo.setVtsegundos(Integer.parseInt(vistaingreso.valortarifa.getText()));
        
         
         //registro de piloto
         cliente.setNombre(vistaingreso.cajaNombre.getText());
         cliente.setApellido(vistaingreso.cajaApellido.getText());
         cliente.setTelefono(vistaingreso.cajaTelefono.getText());
         
        Date entrada = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaEntrada=formato.format(entrada);
        cliente.setFechaIn(fechaEntrada);
        
        cliente.setId_placa(vistaingreso.cajaIdPlaca.getText());
        
         //Imprimir objetos
             System.out.println("Vehiculo: " + vehiculo);
             System.out.println("Cliente: " + cliente);
        //llamar las consultas SQL para agregar una escuderia y un piloto
        if(consultasVehiculo.registrarVehiculo(vehiculo)
                &&consultasCliente.registrarCliente(cliente)){
            
            JOptionPane.showMessageDialog(null, "Exito agregando los datos");
            
        }else{
            
            JOptionPane.showMessageDialog(null, "Error agregando los datos");
            
        }
        
        
    }
    
}
