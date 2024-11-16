import com.toedter.calendar.JMonthChooser;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class sales extends javax.swing.JFrame {

    public sales() {
        initComponents();
    }
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        check = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        MonthChooser = new com.toedter.calendar.JMonthChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        productSales = new javax.swing.JTable();
        dateChooser = new com.toedter.calendar.JDateChooser();
        dates = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        sales = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("MONTHLY SALES");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 260, 30));

        check.setText("CHECK");
        check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkActionPerformed(evt);
            }
        });
        getContentPane().add(check, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 380, 130, 30));

        jButton3.setText("CLOSE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, 70, 30));
        getContentPane().add(MonthChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 380, 130, 30));

        productSales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "PRODUCT", "QUANTITY", "PRICE", "DATE"
            }
        ));
        jScrollPane2.setViewportView(productSales);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 670, 240));
        getContentPane().add(dateChooser, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 80, 130, 30));

        dates.setText("CHECK");
        dates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datesActionPerformed(evt);
            }
        });
        getContentPane().add(dates, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 120, 130, 30));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 28)); // NOI18N
        jLabel3.setText("PRODUCTS SALES");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 280, 40));

        sales.setFont(new java.awt.Font("STXihei", 1, 20)); // NOI18N
        sales.setForeground(new java.awt.Color(204, 204, 204));
        getContentPane().add(sales, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 310, 60));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bg.PNG"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkActionPerformed
    calculateAndDisplayMonthlyData();
    }

    private void calculateAndDisplayMonthlyData() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/products?useSSL=false", "root", "password")) {

        int selectedMonth = MonthChooser.getMonth() + 1; // Adding 1 because months are 0-based

        String selectQuery = "SELECT SUM(PRICE) AS monthly_sales " +
                "FROM checkout " +
                "WHERE MONTH(DATE) = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setInt(1, selectedMonth);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                // Display monthly sales in the existing JLabel named 'sales'
                if (resultSet.next()) {
                    double monthlySales = resultSet.getDouble("monthly_sales");

                    // Format the monthly sales as currency with the peso sign and two decimal places
                    NumberFormat pesoFormat = NumberFormat.getCurrencyInstance(new Locale("en", "PH"));
                    String formattedMonthlySales = pesoFormat.format(monthlySales);

                    sales.setText("Monthly Sales: ₱ " + formattedMonthlySales);
                } else {
                    // No sales data for the selected month
                    sales.setText("No sales for the selected month");
                }
            }

            System.out.println("Monthly data calculation and display successful.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } catch (SQLException ex) {
        Logger.getLogger(sales.class.getName()).log(Level.SEVERE, null, ex);
    }

    
    }//GEN-LAST:event_checkActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
            owner o = new owner();
            this.hide();
            o.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void datesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datesActionPerformed
     checkProductSales();
    }

    private void checkProductSales() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/products?useSSL=false", "root", "password")) {
            // Get the selected date from JDateChooser
            java.sql.Date selectedDate = new java.sql.Date(dateChooser.getDate().getTime());

            // Fetch product sales data for the selected date
            String selectQuery = "SELECT * FROM checkout WHERE DATE = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
                preparedStatement.setDate(1, selectedDate);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    DefaultTableModel productSalesTableModel = (DefaultTableModel) productSales.getModel();
                    productSalesTableModel.setRowCount(0);

                            if (resultSet.next()) {
                        // Sales data exists for the selected date
                        do {
                            int id = resultSet.getInt("ID");
                            String product = resultSet.getString("PRODUCT");
                            int quantity = resultSet.getInt("QUANTITY");
                            double price = resultSet.getDouble("PRICE");
                            java.sql.Date date = resultSet.getDate("DATE");

                            Object[] rowData = {id, product, quantity, price, date};
                            productSalesTableModel.addRow(rowData);
                        } while (resultSet.next());
                    } else {
                        // No sales data for the selected date
                        JOptionPane.showMessageDialog(this, "No sales from this date", "No Sales", JOptionPane.INFORMATION_MESSAGE);
                        productSalesTableModel.setRowCount(0);
                    }
                }

                System.out.println("Product sales data for the selected date retrieved and displayed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException ex) {
            Logger.getLogger(sales.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_datesActionPerformed

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
            java.util.logging.Logger.getLogger(sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(sales.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new sales().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JMonthChooser MonthChooser;
    private javax.swing.JButton check;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JButton dates;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable productSales;
    private javax.swing.JLabel sales;
    // End of variables declaration//GEN-END:variables
}
