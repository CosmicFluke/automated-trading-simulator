package autotradingsim.ui;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author Bill Feng
 */
public class AutomatedTradingSimulator extends javax.swing.JFrame {
Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    /**
     * Creates new form Application
     */
    public AutomatedTradingSimulator() {

        initComponents();
        int x = (screenSize.width/2)-(this.getBounds().width/2);
        int y = (screenSize.height/2)-(this.getBounds().height/2);
        //System.out.println(this.getBounds().width);
        this.setLocation(x,y);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        experiments = new javax.swing.JButton();
        strategies = new javax.swing.JButton();
        stocks = new javax.swing.JButton();
        indicators = new javax.swing.JButton();
        quit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Automated Trading Simulator");
        setResizable(false);

        experiments.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        experiments.setText("Experiments");
        experiments.setPreferredSize(new java.awt.Dimension(125, 85));
        experiments.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                experimentsActionPerformed(evt);
            }
        });

        strategies.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        strategies.setText("Strategies");
        strategies.setPreferredSize(new java.awt.Dimension(125, 85));
        strategies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                strategiesActionPerformed(evt);
            }
        });

        stocks.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        stocks.setText("Stocks");
        stocks.setPreferredSize(new java.awt.Dimension(125, 85));
        stocks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stocksActionPerformed(evt);
            }
        });

        indicators.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        indicators.setText("Indicators");
        indicators.setPreferredSize(new java.awt.Dimension(125, 85));
        indicators.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                indicatorsActionPerformed(evt);
            }
        });

        quit.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        quit.setText("Quit");
        quit.setPreferredSize(new java.awt.Dimension(125, 85));
        quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome to ATS!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 390, Short.MAX_VALUE)
                    .addComponent(quit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(indicators, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(stocks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(experiments, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(strategies, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(experiments, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(strategies, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stocks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(indicators, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void experimentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_experimentsActionPerformed
        ExperimentList e = new ExperimentList(this);
        this.setVisible(false);
        e.setVisible(true);
    }//GEN-LAST:event_experimentsActionPerformed

    private void strategiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_strategiesActionPerformed
        StrategyList s = new StrategyList(this);
        this.setVisible(false);
        s.setVisible(true);
    }//GEN-LAST:event_strategiesActionPerformed

    private void stocksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stocksActionPerformed
        StockList s = new StockList(this);
        this.setVisible(false);
        s.setVisible(true);
    }//GEN-LAST:event_stocksActionPerformed

    private void indicatorsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_indicatorsActionPerformed
        IndicatorList i = new IndicatorList(this);
        this.setVisible(false);
        i.setVisible(true);
    }//GEN-LAST:event_indicatorsActionPerformed

    private void quitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_quitActionPerformed

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
            java.util.logging.Logger.getLogger(AutomatedTradingSimulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AutomatedTradingSimulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AutomatedTradingSimulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AutomatedTradingSimulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AutomatedTradingSimulator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton experiments;
    private javax.swing.JButton indicators;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton quit;
    private javax.swing.JButton stocks;
    private javax.swing.JButton strategies;
    // End of variables declaration//GEN-END:variables
}
