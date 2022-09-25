/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import static gui.T.inPut;
import static gui.T.outPut;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Kanishka
 */
public class ImageFrame extends javax.swing.JFrame {

    /**
     * Creates new form ImageFrame
     */
    JLabel jl;

    public ImageFrame() throws Exception {

        String name = "";
        this.setUndecorated(true);
        if (inPut == null) {
            File f = new File("C:/Nft");
            f.mkdir();
            new File(f, "Input").mkdir();
        }
        
        inPut = "C:/Nft/Input/";
        for (String n : getFileList(T.inPut)) {

            this.setBounds(0, 0, 1000, 1000);

            Random r = new Random();
            int li = getFileCount(getFileList(T.inPut + n));
            if (li != 0) {
                int im = r.nextInt(li);
             

                jl = new JLabel();
                jl.setBounds(0, 0,1000,1000);
                jl.setIcon(ChangeSize(1000, 1000, new ImageIcon(T.inPut + n + "/" + getFileList(T.inPut + n)[im])));
                this.add(jl);
                name = name + String.valueOf(im);
            }

        }
        System.out.println(name);
        this.setLocationRelativeTo(null);

        this.setVisible(true);
        BufferedImage bi = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        System.out.println(bi.getGraphics());

        paint(bi.getGraphics());
       

        if (outPut == null) {
            File f = new File("C:/Nft");
            f.mkdir();
            new File(f, "Output").mkdir();

        }

        outPut = "C:/Nft/Output/";

        File nf = new File(outPut + name + ".png");
        ImageIO.write(bi, "png", nf);

    }

    private String[] getFileList(String url) {

        return new File(url).list();

    }

    private int getFileCount(String[] l) {
        return l.length;
    }

    private ImageIcon ChangeSize(int width, int height, ImageIcon image) {

        return new ImageIcon(image.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ImageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImageFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new ImageFrame().setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(ImageFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}