/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package reproductor;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;


/**
 *
 * @author salim
 */
public class reproductor extends JFrame {
    
    private JButton btnPlay;
    private JButton btnPause;
    private JButton btnStop;
    private JLabel lblStatus;
    private JProgressBar progressBar;
    private Clip clip; // Variable para almacenar el objeto Clip
    private String rutaCancion;  
    
    
    /**
     * Creates new form 
     */
    public reproductor() {
        JFileChooser fileChooser = new JFileChooser();
        int seleccion = fileChooser.showOpenDialog(this);
        
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            rutaCancion = fileChooser.getSelectedFile().getAbsolutePath();
        }
        
        initComponents();
        
        // Configurar la ventana principal
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Reproductor de Música/Audio");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
      private void initComponents() {
        // Configurar la interfaz gráfica
        btnPlay = new JButton("Abrir");
        btnPause = new JButton("Pausar");
        btnStop = new JButton("Continuar");
        JButton btnRestart = new JButton("Reiniciar"); //
        lblStatus = new JLabel("Estado: ");
        progressBar = new JProgressBar();
        
        Container contenedor = getContentPane();
        contenedor.setLayout(new BorderLayout());
        
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnPlay);
        panelBotones.add(btnPause);
        panelBotones.add(btnStop);
        panelBotones.add(btnRestart);
        
        contenedor.add(panelBotones, BorderLayout.CENTER);
        contenedor.add(progressBar, BorderLayout.SOUTH);
        contenedor.add(lblStatus, BorderLayout.NORTH);

        JPanel panelProgress = new JPanel(new BorderLayout());
        panelProgress.add(progressBar, BorderLayout.NORTH);
         contenedor.add(panelProgress, BorderLayout.SOUTH);
        
        // Agregar los listeners de eventos a los botones
        btnPlay.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reproducir();
            }
        });
        btnPause.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pausar();
            }
        });
        
        btnStop.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                continuar();
            }
        });
      
        btnRestart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reiniciar(); // Llamar al método reiniciar al hacer clic en el botón
            }
        });
        pack(); 
        
    }
    
private void reproducir() {
    Thread hiloReproduccion = new Thread(new Runnable() {
            public void run() {
                try {
                    File archivoMusica = new File(rutaCancion);
                    AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoMusica);
                    clip = AudioSystem.getClip();
                    clip.open(audioStream);

                    // Obtener la duración total de la canción en milisegundos
                    int duracionTotal = (int) clip.getMicrosecondLength() / 1000;

                    clip.start();

                    while (clip.isRunning()) {
                        // Obtener la posición de reproducción actual en milisegundos
                        int posicionActual = (int) clip.getMicrosecondPosition() / 1000;

                        // Calcular el progreso como un porcentaje
                        int progreso = (int) (((double) posicionActual / duracionTotal) * 100);


                        // Actualizar el valor del progressBar
                        progressBar.setValue(progreso);

                        // Esperar un breve período para evitar una actualización continua excesiva
                        Thread.sleep(100);
                    }

                    lblStatus.setText("Estado: Reproducción iniciada");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        hiloReproduccion.start();
    }

private int posicionPausa;

private void pausar() {
   if (clip != null && clip.isRunning()) {
        posicionPausa = clip.getFramePosition(); // Guardar la posición de pausa
        clip.stop();
        lblStatus.setText("Estado: Reproducción pausado");
    }
}

private void continuar() {
   if (clip != null && !clip.isRunning()) { // Comprobar si el clip no se está reproduciendo
        clip.setFramePosition(posicionPausa); // Establecer la posición de reproducción
        clip.start();
        lblStatus.setText("Estado: Reproducción reanudada");
    }
}

private void reiniciar() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.setFramePosition(0);
            clip.start();
        }
        lblStatus.setText("Estado: Reproducción reiniciada");
        progressBar.setValue(0);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
     /* @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new reproductor();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
