
package ventanas;

import javax.swing.JFrame;

/**
 *
 * @author Edward Henao1
 */
public class ventana_principal extends javax.swing.JFrame 
{


    public ventana_principal() 
    {
        initComponents();
    }
    
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1_registrar_personal = new javax.swing.JButton();
        jLabel1_fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(0, 255, 255));
        jLabel1.setText("SIRCCHI");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, -1, -1));

        jButton1_registrar_personal.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton1_registrar_personal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/chicas_1.png"))); // NOI18N
        jButton1_registrar_personal.setText("Registrar Chicas");
        jButton1_registrar_personal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_registrar_personalActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1_registrar_personal, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 400, 158, 25));

        jLabel1_fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/imagen_9.jpg"))); // NOI18N
        getContentPane().add(jLabel1_fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 500));
        jLabel1_fondo.getAccessibleContext().setAccessibleParent(jLabel1_fondo);

        getAccessibleContext().setAccessibleParent(jLabel1_fondo);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1_registrar_personalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_registrar_personalActionPerformed
        // TODO add your handling code here:
        
                       
    }//GEN-LAST:event_jButton1_registrar_personalActionPerformed


    public static void main(String args[]) 
    {
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
            java.util.logging.Logger.getLogger(ventana_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventana_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventana_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventana_principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventana_principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1_registrar_personal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel1_fondo;
    // End of variables declaration//GEN-END:variables
}
