import com.mysql.jdbc.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane; 
import javax.swing.SwingUtilities;
import javax.swing.JLabel;

public class ViewShoppingCart extends javax.swing.JFrame {
    
    public ViewShoppingCart() {
        initComponents();
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        viewcart = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        check = new javax.swing.JButton();
        returnproduct = new javax.swing.JButton();
        checkout = new javax.swing.JButton();
        amount = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        viewcart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "PRODUCT", "QUANTITY", "PRICE", "DATE"
            }
        ));
        jScrollPane1.setViewportView(viewcart);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 760, 280));

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setFont(new java.awt.Font("RomanT", 1, 14)); // NOI18N
        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 440, 80, -1));

        check.setBackground(new java.awt.Color(153, 153, 153));
        check.setFont(new java.awt.Font("RomanT", 1, 14)); // NOI18N
        check.setText("CHECK");
        check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkActionPerformed(evt);
            }
        });
        getContentPane().add(check, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 440, 90, -1));

        returnproduct.setBackground(new java.awt.Color(153, 153, 153));
        returnproduct.setFont(new java.awt.Font("RomanT", 1, 14)); // NOI18N
        returnproduct.setText("RETURN PRODUCT");
        returnproduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnproductActionPerformed(evt);
            }
        });
        getContentPane().add(returnproduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, 200, -1));

        checkout.setBackground(new java.awt.Color(51, 51, 51));
        checkout.setFont(new java.awt.Font("RomanT", 0, 14)); // NOI18N
        checkout.setForeground(new java.awt.Color(255, 255, 255));
        checkout.setText("CHECK OUT");
        checkout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkoutActionPerformed(evt);
            }
        });
        getContentPane().add(checkout, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 440, -1, -1));

        amount.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        amount.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 350, 240, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/backG.PNG"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 530));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void displayDataFromDatabase() {
        // JDBC URL, username, and password of MySQL server
        String URL = "jdbc:mysql://127.0.0.1:3306/products?useSSL=false";
        String USER = "root"; // Replace with your MySQL username
        String PASSWORD = "password"; // Replace with your MySQL password

        // SQL query to retrieve data
        String selectQuery = "SELECT * FROM viewcart"; // Assuming your table name is viewcart

        try (
                // Establish a connection to the database
                Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

                // Create a statement to execute the SQL query
                Statement statement = connection.createStatement();

                // Execute the SQL query and get the result set
                ResultSet resultSet = statement.executeQuery(selectQuery)
        ) {
            // Process the result set and update your Swing components
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID");
            model.addColumn("PRODUCT");
            model.addColumn("QUANTITY");
            model.addColumn("PRICE");
            model.addColumn("DATE");

            while (resultSet.next()) {
                // Retrieve data from the result set
                int id = resultSet.getInt("ID");
                String product = resultSet.getString("PRODUCT");
                int quantity = resultSet.getInt("QUANTITY");
                double price = resultSet.getDouble("PRICE");
                String date = resultSet.getString("DATE");
              
                // Add the data to the table model
                model.addRow(new Object[]{id, product, quantity, price, date});
            }

            // Set the table model to your JTable
            viewcart.setModel(model);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Categories c = new Categories();
        this.hide();
        c.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkActionPerformed
        // Trigger data retrieval when the button is clicked
        displayDataFromDatabase();
        //Calculate the total amount
        calculateTotalPrice();
    
    

    }//GEN-LAST:event_checkActionPerformed

    private void returnproductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnproductActionPerformed
     deleteSelectedItem();
      // Calculate the total price after loading data
     calculateTotalPrice();
}

private void deleteSelectedItem() {
    DefaultTableModel model = (DefaultTableModel) viewcart.getModel();

    // Check if a row is selected
    if (viewcart.getSelectedRow() == -1) {
        JOptionPane.showMessageDialog(this, "Please select a row to delete.");
        return;
    }

    // Get the selected row index
    int selectedRowIndex = viewcart.getSelectedRow();

    // Get the ID from the selected row
    String selectedID = model.getValueAt(selectedRowIndex, 0).toString();

    // Remove the selected row from the table
    model.removeRow(selectedRowIndex);

    // Delete the corresponding data from the database
    deleteDataFromDatabase(selectedID);
}

private void deleteDataFromDatabase(String idToDelete) {
// JDBC URL, username, and password of MySQL server
    String URL = "jdbc:mysql://127.0.0.1:3306/products?useSSL=false";
    String USER = "root"; // Replace with your MySQL username
    String PASSWORD = "password"; // Replace with your MySQL password

    // SQL query to delete data based on ID
    String deleteQuery = "DELETE FROM viewcart WHERE ID = '" + idToDelete + "'";

    try (
            // Establish a connection to the database
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Create a statement to execute the SQL query
            Statement statement = connection.createStatement()
    ) {
        // Execute the DELETE SQL query
        statement.executeUpdate(deleteQuery);
        
      JOptionPane.showMessageDialog(this, "Successfully returned");
      
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
// Add this method to set the totalAmount text field
private void calculateTotalPrice() {
     DefaultTableModel model = (DefaultTableModel) viewcart.getModel();

    // Using an array to hold the result, making it effectively final
    final double[] totalPrice = {0.0};

    // Iterate through the rows of the table and sum up the prices
    for (int i = 0; i < model.getRowCount(); i++) {
        try {
            double price = Double.parseDouble(model.getValueAt(i, 3).toString()); 
            int quantity = Integer.parseInt(model.getValueAt(i, 2).toString()); 
            totalPrice[0] += price * quantity;
        } catch (NumberFormatException e) {
            // Handle parsing errors, if any
            e.printStackTrace();
        }
    }

    // Update the UI components on the Event Dispatch Thread (EDT)
    SwingUtilities.invokeLater(() -> {
        
        // Display the total price in the amount JLabel
        amount.setText("Total Price: ₱" + String.format("%.2f", totalPrice[0]));
        System.out.println("Total Price Calculated: " + totalPrice[0]);
    });
    }//GEN-LAST:event_returnproductActionPerformed

    private void checkoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkoutActionPerformed
 // Get the data from the current cart
    DefaultTableModel model = (DefaultTableModel) viewcart.getModel();

    // Check if there are items in the cart
    if (model.getRowCount() == 0) {
        JOptionPane.showMessageDialog(this, "No items to checkout.");
        return;
    }

    // JDBC URL, username, and password for the checkout database
    String checkoutURL = "jdbc:mysql://127.0.0.1:3306/products?useSSL=false";
    String checkoutUSER = "root"; 
    String checkoutPASSWORD = "password"; 

    // Initialize the connection outside the try-with-resources to make it accessible in the finally block
    Connection checkoutConnection = null;

    // SQL query to insert data into the checkout database
    String insertQuery = "INSERT INTO checkout (PRODUCT, QUANTITY, PRICE, DATE) VALUES (?, ?, ?, ?)";

    // SQL query to delete data from the original database
    String deleteQuery = "DELETE FROM viewcart WHERE ID = ?";

    try {
        // Establish a connection to the checkout database
        checkoutConnection = DriverManager.getConnection(checkoutURL, checkoutUSER, checkoutPASSWORD);

        // Prepared statement to execute the insert query
        PreparedStatement insertStatement = (PreparedStatement) checkoutConnection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);

        // Prepared statement to execute the delete query
        PreparedStatement deleteStatement = (PreparedStatement) checkoutConnection.prepareStatement(deleteQuery);

        // Disable auto-commit to manage transactions
        checkoutConnection.setAutoCommit(false);

        // Iterate through the rows of the cart and insert data into the checkout database
        for (int i = 0; i < model.getRowCount(); i++) {
            String product = model.getValueAt(i, 1).toString();
            int quantity = Integer.parseInt(model.getValueAt(i, 2).toString());
            double price = Double.parseDouble(model.getValueAt(i, 3).toString());
            String date = model.getValueAt(i, 4).toString();

            // Set parameters for the insert statement
            insertStatement.setString(1, product);
            insertStatement.setInt(2, quantity);
            insertStatement.setDouble(3, price);
            insertStatement.setString(4, date);

            // Execute the insert query
            insertStatement.executeUpdate();

            // Retrieve the auto-generated ID if needed
            ResultSet generatedKeys = insertStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int generatedId = generatedKeys.getInt(1);
                System.out.println("Generated ID: " + generatedId);
                // You can use the generated ID as needed
            }

            // Set parameter for the delete statement
            deleteStatement.setInt(1, Integer.parseInt(model.getValueAt(i, 0).toString())); // Assuming ID is in the 1st column (index 0)

            // Execute the delete query
            deleteStatement.executeUpdate();
        }

        // Commit the changes
        checkoutConnection.commit();

        // Clear the cart
        model.setRowCount(0);

        // Update the total amount display
        calculateTotalPrice();

        JOptionPane.showMessageDialog(this, "Checkout successful. Cart cleared.");
    } catch (SQLException e) {
        e.printStackTrace();

        // Rollback in case of an error
        try {
            if (checkoutConnection != null) {
                checkoutConnection.rollback();
            }
        } catch (SQLException rollbackException) {
            rollbackException.printStackTrace();
        }

        JOptionPane.showMessageDialog(this, "Checkout failed. Please try again.");
    } finally {
        // Close the connection in the finally block to ensure it is always closed
        try {
            if (checkoutConnection != null) {
                checkoutConnection.close();
            }
        } catch (SQLException closeException) {
            closeException.printStackTrace();
        }
    }

    }//GEN-LAST:event_checkoutActionPerformed
  
   
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
            java.util.logging.Logger.getLogger(ViewShoppingCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewShoppingCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewShoppingCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewShoppingCart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewShoppingCart().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amount;
    private javax.swing.JButton check;
    private javax.swing.JButton checkout;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton returnproduct;
    private javax.swing.JTable viewcart;
    // End of variables declaration//GEN-END:variables

    Object getViewcart() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
