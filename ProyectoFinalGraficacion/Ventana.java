/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProyectoFinalGraficacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;


public class Ventana extends JPanel implements ActionListener,MouseListener{
    // ventana
    int op;
    private JFrame ventana;
    // contenedor
    private Container contenedor;
    //declarar la figura
    private Punto figura[];
    public JMenuBar arc,arc2;
    public JMenu uno, dos;
    public JMenuItem u1,u2,u3,u4,u5,u6,u7,u8,u9;
    public JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
    public JPanel panel;
   
    

    /**
     * Crear una ventana para representar la figura
     * @param titulo Titulo de la ventana
     * @param figura Figura representada por puntos
     */
    public Ventana(String titulo,Punto figura[]) {
        // inicializar la ventana
        ventana = new JFrame(titulo);
        // definir tamaño a ventana
        ventana.setSize(800, 600);
        setLayout(new FlowLayout(FlowLayout.RIGHT, 2, 0));
        arc = new JMenuBar();
        arc2 = new JMenuBar();
        
        dos= new JMenu("Valores predefinidos.");
        uno = new JMenu("Definir valores.");
        uno.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        dos.setBorder(BorderFactory.createLineBorder(Color.red));
        
        u3 = new JMenuItem("Traslacion         ",new javax.swing.ImageIcon(getClass().getResource("Traslacion.png")));
        u1 = new JMenuItem("Rotacion          ",new javax.swing.ImageIcon(getClass().getResource("Rotacion.png")));
        u2 = new JMenuItem("Escalacion          ",new javax.swing.ImageIcon(getClass().getResource("Escalacion.png")));
        u4 = new JMenuItem("Rotacion en contra",new javax.swing.ImageIcon(getClass().getResource("RotacionContra.png")));
        u5 = new JMenuItem("Reflexion en X    ",new javax.swing.ImageIcon(getClass().getResource("Reflexion.png")));
        u6 = new JMenuItem("Reflexion X/Y     ",new javax.swing.ImageIcon(getClass().getResource("Reflexion.png")));
        u7 = new JMenuItem("Reflexion en Y    ",new javax.swing.ImageIcon(getClass().getResource("Reflexion.png")));
        u8 = new JMenuItem("Restablacer",new javax.swing.ImageIcon(getClass().getResource("Redibujar.png")));
        u9 = new JMenuItem("Deformacion", new javax.swing.ImageIcon(getClass().getResource("Deformar.png")));
               
        b1 = new JButton("        Traslacion         ",new javax.swing.ImageIcon(getClass().getResource("Traslacion.png")));
        b2 = new JButton("          Rotacion           ",new javax.swing.ImageIcon(getClass().getResource("Rotacion.png")));
        b3 = new JButton("          Escalacion      ",new javax.swing.ImageIcon(getClass().getResource("Escalacion.png")));
        b4 = new JButton("Rotacion en contra ",new javax.swing.ImageIcon(getClass().getResource("RotacionContra.png")));
        b5 = new JButton("     Reflexion en X     ",new javax.swing.ImageIcon(getClass().getResource("Reflexion.png")));
        b6 = new JButton("      Reflexion X/Y      ",new javax.swing.ImageIcon(getClass().getResource("Reflexion.png")));
        b7 = new JButton("     Reflexion en Y     ",new javax.swing.ImageIcon(getClass().getResource("Reflexion.png")));
        b8 = new JButton("        Restablacer     ",new javax.swing.ImageIcon(getClass().getResource("Redibujar.png")));
        b9 = new JButton("      Deformacion    ", new javax.swing.ImageIcon(getClass().getResource("Deformar.png")));
        
        add(arc);
        arc.add(uno);
        
        add(arc2);
        arc2.add(dos);
        
        dos.add(b1);
        dos.add(b2);
        dos.add(b3);
        dos.add(b4);
        dos.add(b5);
        dos.add(b6);
        dos.add(b7);
        dos.add(b8);
        dos.add(b9);
        
        
        
        uno.add(u1);
        uno.add(u3);
        uno.add(u2);
        uno.add(u4);
        uno.add(u5);
        uno.add(u6);
        uno.add(u7);
        uno.add(u8);
        uno.add(u9);
        
        
        u1.addActionListener(this);
        u3.addActionListener(this);
        u2.addActionListener(this);
        u4.addActionListener(this);
        u5.addActionListener(this);
        u6.addActionListener(this);
        u7.addActionListener(this);
        u8.addActionListener(this);
        u9.addActionListener(this);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setResizable(false);
        
        contenedor = ventana.getContentPane();
        contenedor.setSize(800, 600);
        // agregar la ventana en el contenedor
        contenedor.add(this, BorderLayout.CENTER);
        this.figura=figura;
        ventana.setFocusable(true);
        ventana.addKeyListener(new Listener (this));
        ventana.addMouseListener(this);
       
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); 
        //Dibujar la figura original
        g.setColor(Color.BLACK);
        this.dibujar(g);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==u3){
            int x,y;
            x=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de traslado en X"));
            y=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de traslado en Y"));
            this.traslacion(x,y);
            ventana.repaint();
        }
        if(e.getSource()==u1){
            double angulo;
            angulo=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor del angulo para la rotacion"));
            this.Rotacion(angulo);
            ventana.repaint();
        }
        if(e.getSource()==u2){
            double xf,yf;
            xf=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor de x para escalar"));
            yf=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor de y para escalar"));
            this.escalar(xf,yf);
            ventana.repaint();
        }
        if(e.getSource()==u4){
            int angulo;
            angulo=Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor del angulo para la rotacion en contra"));
            this.rotacionContra(angulo);
            ventana.repaint();
        }
        if(e.getSource()==u5){
            int x;
            x=Integer.parseInt(JOptionPane.showInputDialog("Ingrese valor para la reflexion en x"));
            this.ReflexionX();
            ventana.repaint();
        }
        if(e.getSource()==u6){
            int x,y;
            x=Integer.parseInt(JOptionPane.showInputDialog("Ingrese valor en x para la reflexion"));
            y=Integer.parseInt(JOptionPane.showInputDialog("Ingrese valor en y para la reflexion"));
            this.reflexion_xy();
            ventana.repaint();
            
        }
        if(e.getSource()==u7){
            int ty;
            ty=Integer.parseInt(JOptionPane.showInputDialog("Ingrese valor para la reflexion en y"));
            this.reflexion_y();
            ventana.repaint();
            
        }
        if(e.getSource()==u8){
            this.redibujar();
            repaint();
        }
        if(e.getSource()==u9){
            double dx,dy;
            dx=Double.parseDouble(JOptionPane.showInputDialog("Ingrese valor de deformacion para X"));
            dy=Double.parseDouble(JOptionPane.showInputDialog("Ingrese valor de deformacion para Y"));
            this.deformacion(dx, dy);
            ventana.repaint();
            
        }
        if(e.getSource()==b1){
            this.traslacion(20,30);
            ventana.repaint();
        }
        if(e.getSource()==b2){
            this.Rotacion(15);
            ventana.repaint();
        }
        if(e.getSource()==b3){
            this.escalar(.9,.9);
            ventana.repaint();
        }
        if(e.getSource()==b4){
            this.rotacionContra(15);
            ventana.repaint();
        }
        if(e.getSource()==b5){
            this.ReflexionX();
            ventana.repaint();
        }
        if(e.getSource()==b6){
            this.reflexion_xy();
            ventana.repaint();

        }
        if(e.getSource()==b7){
            this.reflexion_y();
            ventana.repaint();

           
        }
        if(e.getSource()==b8){
            this.redibujar();
            repaint();
        }
        if(e.getSource()==b9){
            this.deformacion(.2, .2);
            repaint();
        }
         
    }
    // metodo de reflexion sobre el eje x, y
    private void reflexion_xy() {

        //obtener el punto de referencia
        int tx = figura[0].getX();
        int ty = figura[0].getY();

        //aplicar las formulas de transformacion
        for (Punto punto : figura) {
            // x -> -(a - tx) +tx
            punto.setX(
                    -(punto.getX() - tx) + tx
            );
            // y -> -(b - ty) +ty
            punto.setY(
                    -(punto.getY() - ty) + ty
            );

        }
    }

    // metodo de reflexion sobre el eje y
    private void reflexion_y() {

        // obtener el punto de referencia 
        int tx = figura[0].getX();
        int ty = figura[0].getY();

        for (Punto punto : figura) {
            // x -> (a-tx) + tx
            punto.setX(
                    -(punto.getX() - tx) + tx
            );
            // y -> -(b-ty) + ty
            punto.setY(
                    -(punto.getY() - ty) + ty
            );

        }
    }

    
    public void traslacion(int xf, int yf){
        for (Punto punto : figura) {
        //punto x:((x - xf) 
        //punto y: ((y - yf)
            punto.setX((int)(punto.getX() + xf));
            punto.setY((int)(punto.getY() + yf));
        }
    }
    public void Rotacion (double angulo){
        int tx=figura[0].getX(),ty=figura[0].getY();
        for (Punto punto : figura) {
        //punto x:(x - tx) * cos – (b – ty) * sin + tx
        //punto y: (x - ty) * sin + (b – ty) * cos + ty
            punto.setX((int)((punto.getX() - tx)*Math.cos(Math.toRadians(angulo))-(punto.getY()-ty)*Math.sin(Math.toRadians(angulo))+tx));
            //punto y
            punto.setY((int)((punto.getX() - ty)*Math.sin(Math.toRadians(angulo))+(punto.getY()-ty)*Math.cos(Math.toRadians(angulo))+ty));
        }
    }
     //Metodo de escalar por el profe. Escalamiento en un punto definindo
    private void escalar(double fx, double fy) {
        int tx = figura[0].getX();
        int ty = figura[0].getY();
        for (Punto punto : figura) {

            punto.setX(
                    (int) (((punto.getX() - tx) * fx) + tx)
            );
            punto.setY(
                    (int) (((punto.getY() - ty) * fy) + ty)
            );
        }
    }
    private void rotacionContra(int angulo) {
        int tx = figura[0].getX(), ty = figura[0].getY();
        for (Punto punto : figura) {
            punto.setX((int) ((punto.getX() - tx) * Math.cos(Math.toRadians(angulo)) + (punto.getY() - ty) * Math.sin(Math.toRadians(angulo)) + tx));
            punto.setY((int) ((-1) * (punto.getX() - tx) * Math.sin(Math.toRadians(angulo)) + (punto.getY() - ty) * Math.cos(Math.toRadians(angulo)) + ty));

        }
    }
    private void ReflexionX() {
        int tx = figura[0].getX();
        int ty = figura[0].getY();

        for (Punto punto : figura) {
            punto.setX(-(punto.getX() - tx) + tx);
            punto.setY((punto.getY() - ty) + ty);
        }
    }
    public void deformacion(double dx, double dy){
        int tx=figura[0].getX(),ty=figura[0].getY();
        for (Punto punto : figura) {
        //punto x:((x - tx) + (b - ty) * dx) + tx
        //punto y: ((y - ty) * dy + (b – ty )) + ty
            punto.setX((int)(((punto.getX() - tx)+ (punto.getY()-ty)*dx + tx)));
            punto.setY((int)(((punto.getY() - ty)* dy + (punto.getY()-ty) + ty)));
        }
    }
    
    private void dibujar(Graphics g){
        for (int i = 0; i < figura.length-1; i++) {
            g.drawLine(
                    this.figura[i].getX(),//punto A
                    this.figura[i].getY(),
                    this.figura[i+1].getX(),//punto B
                    this.figura[i+1].getY()
            );
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
       if (e.getButton() == 1) {
            System.out.println("Izquierda");            
           traslacion(-10, 0);
           repaint();
       }
       if (e.getButton() == 3) {                        
                System.out.println("Derecha");                
               traslacion(10, 0);
                repaint();            
        }
       if (e.getButton() == 4) {                        
                System.out.println("Diagonal");                
               traslacion(10, -10);
                repaint();            
        }
       if (e.getButton() == 5) {                        
                System.out.println("Diagonal inversa");                
               traslacion(-10, 10);
                repaint();            
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Estas presionando");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
                System.out.println("Soltaste");

    }

    @Override
    public void mouseEntered(MouseEvent e) {
                System.out.println("Estas dentro");

    }

    @Override
    public void mouseExited(MouseEvent e) {
           
    }

    class Listener implements KeyListener{
    Ventana ventana;

    public Listener(Ventana ventana){
        this.ventana = ventana;
    }        

   
    public void keyTyped(KeyEvent ke) {
        System.out.println("Se ha escrito en el teclado.");
    }

    
    public void keyPressed(KeyEvent ke) {
        
        if (ke.getKeyCode() == KeyEvent.VK_E){
            ventana.escalar(.9,.9 );
            repaint();
        }
        if (ke.getKeyCode() == KeyEvent.VK_T){
            ventana.traslacion(10, 1);
            repaint();
        }
        if (ke.getKeyCode() == KeyEvent.VK_R){
            ventana.Rotacion(5.0);
            repaint();
        }
        if (ke.getKeyCode() == KeyEvent.VK_Q){
            ventana.rotacionContra(5);
            repaint();
        }
        if (ke.getKeyCode() == KeyEvent.VK_X){
            ventana.ReflexionX();
            repaint();
        }
        if (ke.getKeyCode() == KeyEvent.VK_Y){
            ventana.reflexion_y();
            repaint();
        }
        if (ke.getKeyCode() == KeyEvent.VK_Z){
            ventana.reflexion_xy();
            repaint();
        }
        if (ke.getKeyCode() == KeyEvent.VK_D){
            ventana.deformacion(.1, .1);
            repaint();
        }
        if(ke.getKeyCode()==KeyEvent.VK_I){
            ventana.redibujar();
            repaint();
        }


        
    }

    public void keyReleased(KeyEvent ke) {
        System.out.println("Se ha dejado de presionar el boton del teclado.");
        
    }

    
}
    public void setFigura(Punto figura[]){
        this.figura=figura;
    }
    public void redibujar(){
        Punto fig[] = {
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
        setFigura(fig);
        repaint();
    }

    
}
