/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delivery_system;

import static delivery_system.myvariables.password;
import static delivery_system.myvariables.path;
import static delivery_system.myvariables.place;
import static delivery_system.myvariables.username;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author sparsh
 */
public class login extends javax.swing.JFrame {

    static String lguser;
    public login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("Username");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(160, 130, 140, 40);
        getContentPane().add(jTextField1);
        jTextField1.setBounds(320, 130, 200, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setText("Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(160, 210, 140, 40);
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(320, 210, 200, 40);

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(260, 300, 143, 45);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delivery_system/img/l_176.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 700, 450);

        setSize(new java.awt.Dimension(718, 499));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
         try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(rootPane, "Theme Applying Error."+e.getMessage());
        }
         
         lguser=jTextField1.getText();
         Connection myconnection;
          try
        {
        myconnection=DriverManager.getConnection(path+place, username, password);
        try
        { 
            String query="select * from adminlogin where username=? and password=?";
            PreparedStatement mystatement=myconnection.prepareStatement(query);
            mystatement.setString(1, login.lguser);
            mystatement.setString(2, jPasswordField1.getText());
            ResultSet myresult=mystatement.executeQuery();
            
            String query2="select * from employeelogin where username=? and password=?";
            PreparedStatement mystatement2=myconnection.prepareStatement(query2);
            mystatement2.setString(1, login.lguser);
            mystatement2.setString(2, jPasswordField1.getText());
            ResultSet myresult2=mystatement2.executeQuery();
            
            if(myresult.next())
            {
                JOptionPane.showMessageDialog(rootPane, "Welcome Administrator!");
                MainPage mp=new MainPage();
                mp.setVisible(true);
                this.dispose();
            }
            else if(myresult2.next())
            {
                JOptionPane.showMessageDialog(rootPane, "Welcome "+lguser+"!");
                EmployeePage ep=new EmployeePage();
                ep.setVisible(true);
                this.dispose();
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Incorrect Username/Password");
            }
        }
          catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Loging Error."+e.getMessage());
        }
        finally
        {
            myconnection.close();
        }
    }
           catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Connection Error."+e.getMessage());
        }
       
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
