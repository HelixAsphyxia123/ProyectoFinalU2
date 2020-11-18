/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoFinalGraficacion;

/**
 *
 * @author valti
 */
public class Principal {
    public static void main(String[] args) {
        Punto figura[] = {
            new Punto(40,40),
            new Punto (60,40),
            new Punto (40,60),
            new Punto (60,60),
            new Punto (80,80),
            new Punto (100,80),
            new Punto (80,100),
            new Punto(100, 100),
            new Punto(120, 100),
            new Punto(100, 120),
            new Punto(120, 120),
            new Punto(140, 140),
            new Punto(160, 140),
            new Punto(140, 160),
            new Punto(160, 160),
            new Punto(150, 150),
            new Punto(140, 140),
            new Punto(210, 210),
            new Punto(200, 200),
            new Punto(220, 200),
            new Punto(200, 220),
            new Punto(240, 240),
            new Punto(260, 240),
            new Punto(240, 260),
            new Punto(260, 260),
            new Punto(140, 140),
            new Punto(60, 60),
            new Punto(50, 50),
            new Punto(170, 130),
            new Punto(130, 170),
            new Punto (300,300),
            new Punto (200,150),
            new Punto (200,140),
            new Punto (200,130),
            new Punto (200,100),
            new Punto (200,90),
            new Punto (200,80),
            new Punto (200,70),
            new Punto (200,60),
            new Punto (200,50),
            new Punto (200,40),
            new Punto (200,30),
            new Punto (200,20),
            new Punto(130, 260),
            new Punto(130, 130),
            new Punto(140, 160),
            new Punto(170, 170), 
            new Punto (200,60),
            new Punto (220,220),
            new Punto (180,180),
            new Punto (190,190)
        };
        //Crear instancia de ventana
        new Ventana("Transformaciones geometricas VLCA", figura);
    }
    
}
