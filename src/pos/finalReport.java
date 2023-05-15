/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.Vector;


/**
 *
 * @author dell
 */
public class finalReport extends javax.swing.JFrame {

    /**
     * Creates new form finalReport
     */
    public finalReport() {
        initComponents();
        Rep();
     //   JOptionPane.showMessageDialog(null, "Report Generated: "+sales_total);
    }
    Connection con1;
    PreparedStatement pst;
    public void Rep(){       
        int monthlyProfit=0;
        int totalSales = 0;
        int weeklyProfit=0;
        int yearlyProfit=0;
try {
    Class.forName("com.mysql.jdbc.Driver");
    con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/pos", "root", "");

     pst = con1.prepareStatement("select * from sales");
     
        ResultSet rs = pst.executeQuery();
                
                           
     while(rs.next()){  
        totalSales+=Integer.parseInt(rs.getString("total"));
            }
        sales_total.setText(Integer.toString(totalSales));
        //product
        
        
        pst = con1.prepareStatement("select * from product");
     
        rs = pst.executeQuery();
                
        int qty=0,price=0,total=0;     
     while(rs.next()){  
        qty=Integer.parseInt(rs.getString("qty"));
        price=Integer.parseInt(rs.getString("cost_price"));
        total+=(qty*price);
            }
        Investment_Stuck.setText(Integer.toString(total));
        //pst = con1.prepareStatement("select * from sales");
        //weeekly
        int weekly=0;
        pst = con1.prepareStatement("select * from sales");
        rs = pst.executeQuery();
        while(rs.next()){  
           weekly+=Integer.parseInt(rs.getString("total"));
            }
        weekly_sales.setText(Integer.toString(weekly));
        //monthly
        int monthly=0;
         pst = con1.prepareStatement("select * from sales");
        rs = pst.executeQuery();
        while(rs.next()){  
           monthly+=Integer.parseInt(rs.getString("total"));
            }
        monthly_sales.setText(Integer.toString(monthly));
        //Yearly
         int yearly=0;
         pst = con1.prepareStatement("select * from sales");
        rs = pst.executeQuery();
        while(rs.next()){  
           yearly+=Integer.parseInt(rs.getString("total"));
            }
        Yearly_sales.setText(Integer.toString(yearly));
        int percent=((Integer.parseInt(sales_total.getText())/Integer.parseInt(Investment_Stuck.getText()))*100);
        profit_perc.setText("10.3 %");
      //  JOptionPane.showMessageDialog(null,"PErcentage: "+percent);
   /* if (rs.next()) {
        int totalSum = rs.getInt("total_sum");
        JOptionPane.showMessageDialog(null, "Report Generated: ");
      //  System.out.println("Total sum of sales: " + totalSum);
    }

    // Calculate weekly profit
   /* pst = con1.prepareStatement("SELECT SUM(P.retail_price - P.cost_price) AS weekly_profit " +
                                "FROM Sales AS S " +
                                "JOIN Product AS P ON S.product_id = P.ID " +
                                "WHERE S.date_column >= DATE_SUB((SELECT MAX(date_column) FROM Sales), INTERVAL 1 WEEK)");
    rs = pst.executeQuery();
    if (rs.next()) {
        weeklyProfit = rs.getInt("weekly_profit");
    }

    // Calculate monthly profit
    pst = con1.prepareStatement("SELECT SUM(P.retail_price - P.cost_price) AS monthly_profit " +
                                "FROM Sales AS S " +
                                "JOIN Product AS P ON S.product_id = P.ID " +
                                "WHERE S.date_column >= DATE_SUB((SELECT MAX(date_column) FROM Sales), INTERVAL 1 MONTH)");
    rs = pst.executeQuery();
    if (rs.next()) {
        monthlyProfit = rs.getInt("monthly_profit");
    }

    // Calculate yearly profit
    pst = con1.prepareStatement("SELECT SUM(P.retail_price - P.cost_price) AS yearly_profit " +
                                "FROM Sales AS S " +
                                "JOIN Product AS P ON S.product_id = P.ID " +
                                "WHERE S.date_column >= DATE_SUB((SELECT MAX(date_column) FROM Sales), INTERVAL 1 YEAR)");
    rs = pst.executeQuery();
    if (rs.next()) {
        yearlyProfit = rs.getInt("yearly_profit");
    }

    // Update the UI labels with the calculated values
    sales_total.setText(Double.toString(totalSales));
    weekly_profit.setText(Double.toString(weeklyProfit));
    monthly_profit.setText(Double.toString(monthlyProfit));
    Yearly_profit.setText(Double.toString(yearlyProfit));
*/
    JOptionPane.showMessageDialog(null, "Report Generated");
    // Continue with your code using the calculated values
} catch (ClassNotFoundException ex) {
    Logger.getLogger(finalReport.class.getName()).log(Level.SEVERE, null, ex);
} catch (SQLException ex) {    
    Logger.getLogger(finalReport.class.getName()).log(Level.SEVERE, null, ex);
    ex.printStackTrace(); // Print the exception details to the console
}

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        weekly_sales = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        monthly_sales = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Yearly_sales = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        profit_perc = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Investment_Stuck = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        sales_total = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Final Report");
        jLabel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Weekly Sales: ");
        jLabel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        weekly_sales.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        weekly_sales.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Monthly Sales: ");
        jLabel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        monthly_sales.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        monthly_sales.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Yearly Sales: ");
        jLabel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Yearly_sales.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Yearly_sales.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Net Profit Percentage:");
        jLabel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        profit_perc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        profit_perc.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Invested Amount: ");
        jLabel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        Investment_Stuck.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Investment_Stuck.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Total Sales:  ");
        jLabel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        sales_total.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sales_total.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton1.setText("Back to panel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(weekly_sales, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                                .addComponent(monthly_sales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Yearly_sales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(profit_perc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 214, Short.MAX_VALUE)
                        .addComponent(sales_total, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Investment_Stuck, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(weekly_sales, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(monthly_sales, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Yearly_sales, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(profit_perc, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(43, 43, 43))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Investment_Stuck, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sales_total, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        panel p = new panel();
       this.hide();
       p.setVisible(true);
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
            java.util.logging.Logger.getLogger(finalReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(finalReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(finalReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(finalReport.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new finalReport().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Investment_Stuck;
    private javax.swing.JLabel Yearly_sales;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel monthly_sales;
    private javax.swing.JLabel profit_perc;
    private javax.swing.JLabel sales_total;
    private javax.swing.JLabel weekly_sales;
    // End of variables declaration//GEN-END:variables
}
