package autotradingsim.ui;

import java.util.ArrayList;
import javax.swing.ListModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author billfeng
 */
public class ExperimentViewer extends javax.swing.JFrame {

    /**
     * Creates new form ExperimentViewer
     */
    public ExperimentViewer() {
        initComponents();
    }
    
    ExperimentList parent;
    ArrayList<String> strategyListModel = new ArrayList();
    ArrayList<String> stockListModel = new ArrayList();
    public ExperimentViewer(ExperimentList parent) {
        this.parent = parent;
        initComponents();
        this.setLocation(parent.getX(), parent.getY());
        strategyList.setModel((ListModel) strategyListModel);
        stockList.setModel((ListModel) stockListModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        name = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        strategyList = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        stockList = new javax.swing.JList();
        edit = new javax.swing.JButton();
        back = new javax.swing.JButton();
        addStrategy = new javax.swing.JButton();
        addStock = new javax.swing.JButton();
        deleteStrategy = new javax.swing.JButton();
        deleteStock = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Experiment");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        name.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        name.setText("Name: NAME_OF_EXPERIMENT");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel2.setText("Strategies");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel3.setText("Stocks");

        strategyList.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        strategyList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(strategyList);

        stockList.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        stockList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(stockList);

        edit.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        edit.setText("Edit");
        edit.setPreferredSize(new java.awt.Dimension(100, 50));
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        back.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        back.setText("Back");
        back.setPreferredSize(new java.awt.Dimension(100, 50));
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        addStrategy.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        addStrategy.setText("Add");
        addStrategy.setPreferredSize(new java.awt.Dimension(190, 50));
        addStrategy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStrategyActionPerformed(evt);
            }
        });

        addStock.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        addStock.setText("Add");
        addStock.setPreferredSize(new java.awt.Dimension(190, 50));
        addStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStockActionPerformed(evt);
            }
        });

        deleteStrategy.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        deleteStrategy.setText("Delete");
        deleteStrategy.setPreferredSize(new java.awt.Dimension(190, 50));
        deleteStrategy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteStrategyActionPerformed(evt);
            }
        });

        deleteStock.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        deleteStock.setText("Delete");
        deleteStock.setPreferredSize(new java.awt.Dimension(190, 50));
        deleteStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteStockActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addStrategy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                                .addComponent(deleteStrategy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                                .addComponent(deleteStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addStrategy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteStrategy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        parent.setLocation(this.getX(), this.getY());
        parent.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
        dialogInput di = new dialogInput(this, true);
        String text = di.run();
        if(text.length() > 0){
            name.setText(text);
        }
    }//GEN-LAST:event_editActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        parent.setLocation(this.getX(), this.getY());
        parent.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    private void addStrategyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStrategyActionPerformed
        // TODO add your handling code here:
        StrategyPicker sp = new StrategyPicker(this, true);
        String strategyName = sp.run();
        if(!strategyName.equals("") && !strategyListModel.contains(strategyName)){
            strategyListModel.add(strategyName);
        }
    }//GEN-LAST:event_addStrategyActionPerformed

    private void deleteStrategyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteStrategyActionPerformed
        // TODO add your handling code here:
        if(strategyList.getSelectedIndex() == -1){
            dialogMessage dm = new dialogMessage(this, true, "Select an item to delete!");
            dm.setVisible(true);
        }else{
            dialogConfirm dc = new dialogConfirm(this, true);
            if(dc.run()){
                strategyListModel.remove(strategyList.getSelectedIndex());
            }
        }
    }//GEN-LAST:event_deleteStrategyActionPerformed

    private void addStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStockActionPerformed
        // TODO add your handling code here:
        StockPicker sp = new StockPicker(this, true);
        String stockName = sp.run();
        if(!stockName.equals("") && !stockListModel.contains(stockName)){
            stockListModel.add(stockName);
        }
    }//GEN-LAST:event_addStockActionPerformed

    private void deleteStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteStockActionPerformed
        // TODO add your handling code here:
        if(stockList.getSelectedIndex() == -1){
            dialogMessage dm = new dialogMessage(this, true, "Select an item to delete!");
            dm.setVisible(true);
        }else{
            dialogConfirm dc = new dialogConfirm(this, true);
            if(dc.run()){
                stockListModel.remove(stockList.getSelectedIndex());
            }
        }
    }//GEN-LAST:event_deleteStockActionPerformed

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
            java.util.logging.Logger.getLogger(ExperimentViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ExperimentViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ExperimentViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ExperimentViewer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ExperimentViewer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addStock;
    private javax.swing.JButton addStrategy;
    private javax.swing.JButton back;
    private javax.swing.JButton deleteStock;
    private javax.swing.JButton deleteStrategy;
    private javax.swing.JButton edit;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel name;
    private javax.swing.JList stockList;
    private javax.swing.JList strategyList;
    // End of variables declaration//GEN-END:variables
}
