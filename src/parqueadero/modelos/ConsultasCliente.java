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
public class ConsultasCliente extends ModeloBD {
    PreparedStatement consultaSQL;
    ResultSet resultadoSQL;
    
    
public boolean registrarCliente(Cliente cliente){
        
        Connection conexion=conectarBD();
        String query="INSERT INTO cliente(id,nombre,apellido,telefono,fecha_inicio,fecha_salida,id_placa)"
                + "VALUES (null,?,?,?,?,?,?)";
                    System.out.println("SQL:" + query);

        try{
//Peparate que voy con toa
            consultaSQL=conexion.prepareStatement(query);
            
            //Ajusto la consulta
            consultaSQL.setString(1,cliente.getNombre());
            consultaSQL.setString(2,cliente.getApellido());
            consultaSQL.setString(3,cliente.getTelefono());
            consultaSQL.setString(4,cliente.getFechaIn());
            consultaSQL.setString(5,cliente.getFechaOut());
            consultaSQL.setString(6,cliente.getId_placa());
            
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
    
    public Cliente buscarCliente(int id){
       
        Connection conexion=conectarBD();
        String query="SELECT * from cliente where id=?";
        
        try{
            
            //Peparate que voy con toa
            consultaSQL=conexion.prepareStatement(query);
            
            //Ajusto la consulta
            consultaSQL.setInt(1, id);
            
            //Ejecuto la consulta
            resultadoSQL=consultaSQL.executeQuery();
            
            //Orgaizo el resultado
            Cliente cliente= new Cliente();
            if(resultadoSQL.next()){
                
                cliente.setId(resultadoSQL.getInt("id"));
                cliente.setNombre(resultadoSQL.getString("nombre"));
                cliente.setTelefono(resultadoSQL.getString("telefono"));
                cliente.setFechaIn(resultadoSQL.getString("fecha_inicio"));
                cliente.setFechaOut(resultadoSQL.getString("fecha_salida"));
                cliente.setId_placa(resultadoSQL.getString("id_placa"));
                
                return cliente;
                
                
            }else{
                return null;
            }
            
         
            
        }catch(Exception error){
            System.out.println("upsss... "+error);
            return null;
        }
        
       
   }
    
    
   public  boolean actualizarCliente(Cliente cliente){
       
       Connection conexion=conectarBD();
       String query="UPDATE cliente SET fecha_salida=? WHERE id=?";
       
       try{
            //Peparate que voy con toa
            consultaSQL=conexion.prepareStatement(query);
            
            //Ajusto la consulta
            consultaSQL.setString(1,cliente.getFechaOut());
            consultaSQL.setInt(2,cliente.getId());
           
            
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
        
        
        
        
        
        
    
}
