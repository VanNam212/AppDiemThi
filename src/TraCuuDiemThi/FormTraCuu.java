/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TraCuuDiemThi;

import App.MainApp;
import Connection.FileThiSinh;
import Data.ThiSinh;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Van Nam
 */
public class FormTraCuu extends javax.swing.JFrame {

    /**
     * Creates new form FormTraCuu
     */
    private ArrayList<ThiSinh> listStudent = new FileThiSinh().getStudent();
    
    public FormTraCuu() {
        initComponents();
        setLocationRelativeTo(null);    //giao diện hiện giữa màn hình
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelGoogle = new javax.swing.JLabel();
        jLabelDangNhap = new javax.swing.JLabel();
        jTextFieldMa = new javax.swing.JTextField();
        jButtonDangNhap = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonDangBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sign in");

        jLabelGoogle.setFont(new java.awt.Font("Arial Narrow", 1, 24)); // NOI18N
        jLabelGoogle.setText("Google");

        jLabelDangNhap.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabelDangNhap.setText("Đăng nhập");

        jTextFieldMa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextFieldMa.setToolTipText("Mã thí sinh");
        jTextFieldMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMaActionPerformed(evt);
            }
        });

        jButtonDangNhap.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonDangNhap.setText("Đăng nhập");
        jButtonDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDangNhapActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Mã thí sinh:");

        jButtonDangBack.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonDangBack.setText("Back");
        jButtonDangBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDangBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(171, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelDangNhap)
                        .addGap(150, 150, 150))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelGoogle)
                        .addGap(178, 178, 178))))
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonDangBack)
                        .addGap(205, 205, 205)
                        .addComponent(jButtonDangNhap))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jTextFieldMa, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabelGoogle)
                .addGap(27, 27, 27)
                .addComponent(jLabelDangNhap)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(jTextFieldMa, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonDangBack, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDangNhapActionPerformed
        // TODO add your handling code here:
        boolean ktra = false;
        try {
            for (int i = 0; i < listStudent.size(); i++) {
                if (Integer.parseInt(jTextFieldMa.getText()) == (listStudent.get(i).getMaThiSinh())) {
                    this.setVisible(false);
                    ScoreForm scoreForm = new ScoreForm(Integer.parseInt(jTextFieldMa.getText()));
                    scoreForm.setVisible(true);
                    ktra = true;
                    break;
                }
            }
        } catch (Exception e) {
        }
        
        if (ktra == false) {
            JOptionPane.showMessageDialog(rootPane, "Mã thí sinh không đúng");
        }
    }//GEN-LAST:event_jButtonDangNhapActionPerformed

    private void jTextFieldMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMaActionPerformed
        // TODO add your handling code here:
        jButtonDangNhapActionPerformed(evt);
    }//GEN-LAST:event_jTextFieldMaActionPerformed

    private void jButtonDangBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDangBackActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        MainApp app = new MainApp();
        app.setVisible(true);
    }//GEN-LAST:event_jButtonDangBackActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FormTraCuu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FormTraCuu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FormTraCuu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FormTraCuu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FormTraCuu().setVisible(false);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDangBack;
    private javax.swing.JButton jButtonDangNhap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelDangNhap;
    private javax.swing.JLabel jLabelGoogle;
    private javax.swing.JTextField jTextFieldMa;
    // End of variables declaration//GEN-END:variables
}
