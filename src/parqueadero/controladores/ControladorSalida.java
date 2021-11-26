/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parqueadero.controladores;

/**
 *
 * @author Kirpak Villa
 */
import parqueadero.modelos.ConsultasVehiculo;
import parqueadero.modelos.ConsultasCliente;
import parqueadero.modelos.Vehiculo;
import parqueadero.modelos.Cliente;
import parqueadero.vistas.VistaSalida;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

/**
 *
 * @author 503
 */
public class ControladorSalida implements ActionListener {
    
    //Atributos
    VistaSalida vistasalida = new VistaSalida();
    Vehiculo vehiculo = new Vehiculo();
    Cliente cliente = new Cliente();

    public ControladorSalida(VistaSalida vistasalida, Vehiculo vehiculo,Cliente cliente) {
        
        this.vistasalida = vistasalida;
        this.vehiculo = vehiculo;
        this.cliente = cliente;
        vistasalida.botonSalir.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
         ConsultasVehiculo consultasVehiculo= 
                 new ConsultasVehiculo();
         
         ConsultasCliente consultasCliente = 
                 new ConsultasCliente();
         
         //Consultar los datos del piloto a buscar para poder editarlo
         cliente=consultasCliente.buscarCliente(Integer.parseInt(vistasalida.cajaIdCliente.getText()));
         vehiculo=consultasVehiculo.buscarVehiculo(vistasalida.idVehiculo);
         
         //consultar la fecha entrada STRING
         String fechaEntrada=cliente.getFechaIn();
         

         
         //convertir la FECHA STRING EN DATE
         try{
             Date entrada = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fechaEntrada);
             
             Date salida = new Date();
             SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
             String fechaSalida =formato.format(salida);
             
             //rutina para calcular la resta de tiempo
             long tiempoDiferencia=salida.getTime()-entrada.getTime();
             /*System.out.println("Tiempo D: " + tiempoDiferencia);
             TimeUnit unidadTiempo=TimeUnit.MINUTES;
             long tiempoEnEscuderia=unidadTiempo.convert(tiempoDiferencia,TimeUnit.SECONDS);
             System.out.println("Tiempo C: " + tiempoEnEscuderia);
             //llevemos el valor de la fecha salida STRING al objeto piloto
             */cliente.setFechaOut(fechaSalida);
             long tiempoEnEscuderia = tiempoDiferencia / 1000;
            
             //ejecutar la consulta para actualizar el piloto
             if(consultasCliente.actualizarCliente(cliente)){
                  JOptionPane.showMessageDialog(null, "Exito retirando, se quedo: "+tiempoEnEscuderia+" el total de tu Cuenta seria: "+tiempoEnEscuderia*vehiculo.getVtsegundos());
             }else{
                 JOptionPane.showMessageDialog(null, "Fallamos retirando");
             }
                     
         }catch(ParseException error){
             System.out.println("upsss.. "+error);
         }
         
         
    }
    
    
    
    
    
}