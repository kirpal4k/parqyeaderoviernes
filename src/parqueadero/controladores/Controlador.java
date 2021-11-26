/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parqueadero.controladores;

import parqueadero.modelos.ModeloBD;
import parqueadero.vistas.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author 505
 */
public class Controlador implements ActionListener{
    
    ModeloBD modelo = new ModeloBD();
    Vista vista = new Vista();

    public Controlador(ModeloBD modelo, Vista vista) {
        this.modelo=modelo;
        this.vista=vista;
        vista.boton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        
        modelo.conectarBD();
    }

    
    
    
}

