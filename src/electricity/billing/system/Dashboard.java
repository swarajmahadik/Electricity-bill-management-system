//
//package electricity.billing.system;
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class Dashboard extends JFrame {
//    private JLabel lblTotalRevenue, lblTotalConsumption;
//    private Timer timer;
//
//    /**
//     * Creates new form Dashboard
//     */
//    public Dashboard() {
//        initComponents();
//        setBackground(new Color(0, 0, 0, 0));
//        menu1.initMoving(Dashboard.this);
//        startDataUpdates();
//    }
//
//    private void initComponents() {
//        setTitle("Real-Time Dashboard");
//        setSize(400, 300);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        lblTotalRevenue = new JLabel("Total Revenue: $0.00");
//        lblTotalConsumption = new JLabel("Total Consumption: 0 kWh");
//
//        timer = new Timer(5000, new ActionListener() { // Update every 5 seconds
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                fetchAndDisplayData();
//            }
//        });
//
//        JPanel panel = new JPanel();
//        panel.setLayout(new GridLayout(2, 1));
//        panel.add(lblTotalRevenue);
//        panel.add(lblTotalConsumption);
//
//        getContentPane().add(panel, BorderLayout.CENTER);
//    }
//
//    private void fetchAndDisplayData() {
//        // Simulated data update
//        double totalRevenue = Math.random() * 10000;
//        double totalConsumption = Math.random() * 5000;
//
//        lblTotalRevenue.setText("Total Revenue: $" + String.format("%.2f", totalRevenue));
//        lblTotalConsumption.setText("Total Consumption: " + String.format("%.2f", totalConsumption) + " kWh");
//    }
//
//    private void startDataUpdates() {
//        timer.start();
//    }
//
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
//            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Dashboard().setVisible(true);
//            }
//        });
//    }
//
//    // Variables declaration - do not modify//GEN-BEGIN:variables
////    private com.raven.component.Header header2;
////    private com.raven.component.Menu menu1;
////    private com.raven.swing.PanelBorder panelBorder1;
//    // End of variables declaration//GEN-END:variables
//}