/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parqueadero.modelos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author juan sanchez jimenez
 */
public class ModeloBD {
    
    private String servidor="jdbc:mysql://localhost/parqueadero";
    private String usuario="root";
    private String password="";

    
    public Connection conectarBD(){
        
        Connection conexion=null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion=DriverManager.getConnection(servidor,usuario,password);
            System.out.println("Exito conectandonos");
            return conexion;
            
        }catch(Exception error){
            
            System.out.println("UPSS.. "+error);
            return null;
            
        }
    
}
}