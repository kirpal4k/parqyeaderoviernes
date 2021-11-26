/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parqueadero.modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Kirpak Villa
 */
public class ConsultasVehiculo extends ModeloBD {
    
    PreparedStatement consultaSQL;
    ResultSet resultadoSQL;
    
    public boolean registrarVehiculo(Vehiculo vehiculo){
        
        Connection conexion=conectarBD();
        String query="INSERT INTO vehiculo(id,modelo,vtsegundos)"
                + "VALUES (?,?,?)";
        
        try{
            //Peparate que voy con toa
            consultaSQL=conexion.prepareStatement(query);
            
            //Ajusto la consulta
            consultaSQL.setString(1,vehiculo.getId());
            consultaSQL.setString(2,vehiculo.getModelo());
            consultaSQL.setInt(3,vehiculo.getVtsegundos());
            
            
            //Ejecuto la consulta
            int resultado=consultaSQL.executeUpdate();
            
            //validando el resultado
            if(resultado>0){
              return true;  
            }else{
               return false; 
            }
            
        }catch(Exception error){
            System.out.println("upsss... "+error);
            return false;
        }
        
        }
               public Vehiculo buscarVehiculo(String id){
       
       
        Connection conexion=conectarBD();
        String query="SELECT * from vehiculo where id=?";
        
        try{
            
            //Peparate que voy con toa
            consultaSQL=conexion.prepareStatement(query);
            
            //Ajusto la consulta
            consultaSQL.setString(1, id);
            
            //Ejecuto la consulta
            resultadoSQL=consultaSQL.executeQuery();
            
            //Orgaizo el resultado
            Vehiculo vehiculo= new Vehiculo();
            if(resultadoSQL.next()){
                
                vehiculo.setId(resultadoSQL.getString("id"));
                vehiculo.setModelo(resultadoSQL.getString("modelo"));
                vehiculo.setVtsegundos(resultadoSQL.getInt("vtsegundos"));
                
                
                return vehiculo;
                
            }else{
                return null;
            }
            
         
            
        }catch(Exception error){
            System.out.println("upsss... "+error);
            return null;
        }
    }
    
    
}
