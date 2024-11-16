
public class Categories extends javax.swing.JFrame {

   
    public Categories() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        returnButton = new javax.swing.JButton();
        men = new javax.swing.JButton();
        women = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("RomanT", 0, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("CATEGORIES");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 60, 380, 90));

        returnButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        returnButton.setText("RETURN");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });
        getContentPane().add(returnButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, 270, 50));

        men.setBackground(new java.awt.Color(51, 51, 51));
        men.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        men.setForeground(new java.awt.Color(255, 255, 255));
        men.setText("BEST FOR MEN");
        men.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menActionPerformed(evt);
            }
        });
        getContentPane().add(men, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 270, 50));

        women.setBackground(new java.awt.Color(153, 153, 153));
        women.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        women.setText("BEST FOR WOMEN");
        women.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                womenActionPerformed(evt);
            }
        });
        getContentPane().add(women, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 270, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backG.PNG"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menActionPerformed
        productsForMen p = new productsForMen();
            this.hide();
            p.setVisible(true);
    }//GEN-LAST:event_menActionPerformed

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        Customer c = new Customer();
        this.hide();
        c.setVisible(true);
    }//GEN-LAST:event_returnButtonActionPerformed

    private void womenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_womenActionPerformed
        productsForWomen p2 = new productsForWomen();
            this.hide();
            p2.setVisible(true);
    }//GEN-LAST:event_womenActionPerformed

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
            java.util.logging.Logger.getLogger(Categories.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Categories.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Categories.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Categories.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Categories().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton men;
    private javax.swing.JButton returnButton;
    private javax.swing.JButton women;
    // End of variables declaration//GEN-END:variables
}
