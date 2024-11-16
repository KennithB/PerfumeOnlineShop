public class Customer extends javax.swing.JFrame {

  
    public Customer() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        shoppingCartButton = new javax.swing.JButton();
        productbutton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("RomanT", 0, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("PERFUME SHOP");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, 460, 50));

        shoppingCartButton.setBackground(new java.awt.Color(102, 102, 102));
        shoppingCartButton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        shoppingCartButton.setForeground(new java.awt.Color(255, 255, 255));
        shoppingCartButton.setText("SHOPPING CART");
        shoppingCartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shoppingCartButtonActionPerformed(evt);
            }
        });
        getContentPane().add(shoppingCartButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 255, 55));

        productbutton.setBackground(new java.awt.Color(51, 51, 51));
        productbutton.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        productbutton.setForeground(new java.awt.Color(255, 255, 255));
        productbutton.setText("PRODUCT LISTS");
        productbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(productbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 255, 55));

        backButton.setBackground(new java.awt.Color(153, 153, 153));
        backButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        backButton.setText("CLOSE");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, 255, 55));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backG.PNG"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 530));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void productbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productbuttonActionPerformed
          Categories c = new Categories();
          this.hide();
          c.setVisible(true);
    }//GEN-LAST:event_productbuttonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        Main m = new Main();
        this.hide();
        m.setVisible(true);
    }//GEN-LAST:event_backButtonActionPerformed

    private void shoppingCartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shoppingCartButtonActionPerformed
        ViewShoppingCart v = new ViewShoppingCart();
        this.hide();
        v.setVisible(true);
    }//GEN-LAST:event_shoppingCartButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton productbutton;
    private javax.swing.JButton shoppingCartButton;
    // End of variables declaration//GEN-END:variables
}
