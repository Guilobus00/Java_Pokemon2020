
package codigo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author xp
 */
public class VentanaPokedex extends javax.swing.JFrame {

    BufferedImage buffer1 = null;
    Image imagen1 = null;
    int contador = 0;
    
    Statement estado;
    ResultSet resultadoConsulta;
    Connection conexion;
    HashMap<String, Pokemon> listaPokemon = new HashMap();

    @Override
    public void paint(Graphics g){
        super.paintComponents(g);
        Graphics2D g2 = (Graphics2D) imagenPokemon.getGraphics();
        g2.drawImage(buffer1, 0, 0,
                imagenPokemon.getWidth(),
                imagenPokemon.getHeight(), null);
    }
    
    /**
     * Creates new form VentanaPokedex
     */
    public VentanaPokedex() {
        initComponents();
        try {
            imagen1 = ImageIO.read(getClass()
                    .getResource("/imagenes/black-white.png"));
        } catch (IOException ex) {
        }
        
        buffer1 = (BufferedImage) imagenPokemon.createImage(
                imagenPokemon.getWidth(),
                imagenPokemon.getHeight());
        Graphics2D g2 = buffer1.createGraphics();
        
        dibujaElPokemonQueEstaEnLaPosicion(30);
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://192.168.202.131/pokedex", "root", "");
            estado = conexion.createStatement();
        
            while (resultadoConsulta.next()) {
                Pokemon p = new Pokemon();
                p.nombre = resultadoConsulta.getString("nombre");
                p.especie = resultadoConsulta.getString("especie");
                p.movimiento1 = resultadoConsulta.getString("movimiento1");
                p.peso = resultadoConsulta.getString("peso");
                p.movimiento2 = resultadoConsulta.getString("movimiento2");
                p.movimiento3 = resultadoConsulta.getString("movimiento3");
                p.movimiento4 = resultadoConsulta.getString("movimiento4");
                p.descripcion = resultadoConsulta.getString("descripcion");
                p.tipo1 = resultadoConsulta.getString("tipo1");
                p.tipo2 = resultadoConsulta.getString("tipo2");
                p.altura = resultadoConsulta.getString("altura");
                p.habilidad = resultadoConsulta.getString("habilidad");
                p.habitad = resultadoConsulta.getString("habitat");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            
        }
    }

    private void dibujaElPokemonQueEstaEnLaPosicion(int posicion){
        int fila = posicion / 31;
        int columna = posicion % 31;
        Graphics2D g2 = (Graphics2D) buffer1.getGraphics();
        g2.setColor(Color.black);
        g2.fillRect(0, 0, //pinta el fondo del jpanel negro
                imagenPokemon.getWidth(),
                imagenPokemon.getHeight()); 
        g2.drawImage(imagen1,
                0,  //posicion X inicial dentro del jpanel 
                0,  // posicion Y inicial dentro del jpanel
                imagenPokemon.getWidth(), //ancho del jpanel
                imagenPokemon.getHeight(), //alto del jpanel
                columna*96, //posicion inicial X dentro de la imagen de todos los pokemon
                fila*96, //posicion inicial Y dentro de la imagen de todos los pokemon
                columna*96 + 96, //posicion final X
                fila*96 + 96, //posicion final Y
                null  //si no lo pones no va
                );
        repaint();
        
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imagenPokemon = new javax.swing.JPanel();
        izq = new javax.swing.JButton();
        der = new javax.swing.JButton();
        NombrePokemon = new javax.swing.JLabel();
        TipoPokemon = new javax.swing.JLabel();
        DescripcionPokemon = new javax.swing.JLabel();
        PesoPokemon = new javax.swing.JLabel();
        AlturaPokemon = new javax.swing.JLabel();
        EspeciePokemon = new javax.swing.JLabel();
        HabitadPokemon = new javax.swing.JLabel();
        Ataque1 = new javax.swing.JLabel();
        Ataque2 = new javax.swing.JLabel();
        Ataque3 = new javax.swing.JLabel();
        Ataque4 = new javax.swing.JLabel();
        Tipo2Pokemon = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        TipoPokemon1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        javax.swing.GroupLayout imagenPokemonLayout = new javax.swing.GroupLayout(imagenPokemon);
        imagenPokemon.setLayout(imagenPokemonLayout);
        imagenPokemonLayout.setHorizontalGroup(
            imagenPokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 230, Short.MAX_VALUE)
        );
        imagenPokemonLayout.setVerticalGroup(
            imagenPokemonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        getContentPane().add(imagenPokemon);
        imagenPokemon.setBounds(60, 165, 230, 150);

        izq.setText("<");
        izq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                izqActionPerformed(evt);
            }
        });
        getContentPane().add(izq);
        izq.setBounds(230, 426, 40, 20);

        der.setText(">");
        der.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                derActionPerformed(evt);
            }
        });
        getContentPane().add(der);
        der.setBounds(290, 426, 40, 20);

        NombrePokemon.setForeground(new java.awt.Color(255, 0, 0));
        NombrePokemon.setOpaque(true);
        getContentPane().add(NombrePokemon);
        NombrePokemon.setBounds(81, 446, 116, 51);

        TipoPokemon.setOpaque(true);
        getContentPane().add(TipoPokemon);
        TipoPokemon.setBounds(439, 457, 107, 34);

        DescripcionPokemon.setOpaque(true);
        getContentPane().add(DescripcionPokemon);
        DescripcionPokemon.setBounds(439, 178, 238, 83);

        PesoPokemon.setOpaque(true);
        getContentPane().add(PesoPokemon);
        PesoPokemon.setBounds(440, 387, 48, 30);

        AlturaPokemon.setOpaque(true);
        getContentPane().add(AlturaPokemon);
        AlturaPokemon.setBounds(490, 387, 48, 30);

        EspeciePokemon.setOpaque(true);
        getContentPane().add(EspeciePokemon);
        EspeciePokemon.setBounds(570, 390, 110, 40);

        HabitadPokemon.setOpaque(true);
        getContentPane().add(HabitadPokemon);
        HabitadPokemon.setBounds(440, 130, 110, 30);

        Ataque1.setOpaque(true);
        getContentPane().add(Ataque1);
        Ataque1.setBounds(442, 285, 110, 30);

        Ataque2.setOpaque(true);
        getContentPane().add(Ataque2);
        Ataque2.setBounds(565, 285, 110, 30);

        Ataque3.setOpaque(true);
        getContentPane().add(Ataque3);
        Ataque3.setBounds(442, 318, 110, 30);

        Ataque4.setOpaque(true);
        getContentPane().add(Ataque4);
        Ataque4.setBounds(565, 318, 110, 30);

        Tipo2Pokemon.setOpaque(true);
        getContentPane().add(Tipo2Pokemon);
        Tipo2Pokemon.setBounds(570, 457, 108, 34);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pokedex.png"))); // NOI18N
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-10, -10, 830, 560);

        TipoPokemon1.setText("jLabel2");
        TipoPokemon1.setOpaque(true);
        getContentPane().add(TipoPokemon1);
        TipoPokemon1.setBounds(440, 460, 100, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void izqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_izqActionPerformed
        contador --;
        if (contador <=0){
            contador = 0;
        }
        dibujaElPokemonQueEstaEnLaPosicion(contador);
        Pokemon p = listaPokemon.get(String.valueOf(contador + 1));
        if (p != null) {
            NombrePokemon.setText(p.nombre);
            TipoPokemon.setText(p.tipo1);
            Tipo2Pokemon.setText(p.tipo2);
            PesoPokemon.setText(p.peso);
            AlturaPokemon.setText(p.altura);
            Ataque1.setText(p.movimiento1);
            Ataque2.setText(p.movimiento2);
            Ataque3.setText(p.movimiento3);
            Ataque4.setText(p.movimiento4);
            DescripcionPokemon.setText(p.descripcion);
            EspeciePokemon.setText(p.especie);
            HabitadPokemon.setText(p.habitad);
            //sonidoPasar s = new sonidoPasar();
            //s.start();
        } else{
            NombrePokemon.setText("NO HAY DATOS");
        }
    }//GEN-LAST:event_izqActionPerformed

    private void derActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_derActionPerformed
         contador++;
        if (contador >= 150) {
            contador = 150;
        }
        
        dibujaElPokemonQueEstaEnLaPosicion(contador);
        Pokemon p = listaPokemon.get(String.valueOf(contador + 1));
        if (p != null) {
            NombrePokemon.setText(p.nombre);
            TipoPokemon.setText(p.tipo1);
            Tipo2Pokemon.setText(p.tipo2);
            PesoPokemon.setText(p.peso);
            AlturaPokemon.setText(p.altura);
            Ataque1.setText(p.movimiento1);
            Ataque2.setText(p.movimiento2);
            Ataque3.setText(p.movimiento3);
            Ataque4.setText(p.movimiento4);
            DescripcionPokemon.setText(p.descripcion);
            EspeciePokemon.setText(p.especie);
            HabitadPokemon.setText(p.habitad);
            //sonidoPasar s = new sonidoPasar();
            //s.start();
        } else {
            NombrePokemon.setText("NO HAY DATOS");
        }
    }//GEN-LAST:event_derActionPerformed

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPokedex.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPokedex().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AlturaPokemon;
    private javax.swing.JLabel Ataque1;
    private javax.swing.JLabel Ataque2;
    private javax.swing.JLabel Ataque3;
    private javax.swing.JLabel Ataque4;
    private javax.swing.JLabel DescripcionPokemon;
    private javax.swing.JLabel EspeciePokemon;
    private javax.swing.JLabel HabitadPokemon;
    private javax.swing.JLabel NombrePokemon;
    private javax.swing.JLabel PesoPokemon;
    private javax.swing.JLabel Tipo2Pokemon;
    private javax.swing.JLabel TipoPokemon;
    private javax.swing.JLabel TipoPokemon1;
    private javax.swing.JButton der;
    private javax.swing.JPanel imagenPokemon;
    private javax.swing.JButton izq;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
