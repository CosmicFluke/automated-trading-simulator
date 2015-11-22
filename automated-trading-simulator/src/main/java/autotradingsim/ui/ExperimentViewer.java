package autotradingsim.ui;
import autotradingsim.application.*;
import autotradingsim.engine.*;
import autotradingsim.experiment.*;
import java.time.LocalDate;
import javax.swing.*;
import java.util.*;

/**
 *
 * @author Bill Feng
 */
public class ExperimentViewer extends javax.swing.JFrame {

    /**
     * Creates new form ExperimentViewer
     */
    ExperimentList parent;
    TradingApplication application = TradingApplication.getInstance();
    ExperimentEngine experimentEngine = ExperimentEngine.getInstance();
    DefaultComboBoxModel StrategyComboBoxModel = new DefaultComboBoxModel();
    DefaultComboBoxModel StockComboBoxModel = new DefaultComboBoxModel();
    DefaultListModel pairingListModel = new DefaultListModel();
    DefaultListModel resultListModel = new DefaultListModel();
    IExperiment experiment = null;
    public ExperimentViewer(ExperimentList parent) {
        this.parent = parent;
        initComponents();
        this.setLocation(parent.getX() + parent.getWidth()/2 - this.getWidth()/2,
                parent.getY() + parent.getHeight()/2 - this.getHeight()/2);
        startDateField.setText("2015-10-16");
        endDateField.setText("2015-10-17");
        StrategyDropDown.setModel(StrategyComboBoxModel);
        StockDropDown.setModel(StockComboBoxModel);
        stockStrategyPair.setModel(pairingListModel);
        resultList.setModel(resultListModel);
    }
    
    protected void setExperiment(IExperiment experiment){
        this.experiment = experiment;
    }
    protected void loadStrategyStockPairs(){
        Map<String, List<String>> strategyToStocks=this.experiment.getAllTrials();
        for(String stratname: strategyToStocks.keySet()){
            for(String stockname: strategyToStocks.get(stratname)){
                pairingListModel.addElement(stratname+" applied to: "+stockname);
            }
        }
    }

    protected void setNameText(String filename){
        name.setText(filename);
    }
    /**
     * populates strategy dropdown with list of strategy
     */
    protected void setStrategyList(){
        for(String stratname: application.getAvailableStrategies()){
            StrategyComboBoxModel.addElement(stratname);
        }
    }
    /**
     * populates stock dropdown with list of stock symbols
     */
    protected void setStockList(){
        Iterator symbols = application.getStockSymbols();
        while(symbols.hasNext()){
            StockComboBoxModel.addElement(symbols.next().toString());
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

        name = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        edit = new javax.swing.JButton();
        back = new javax.swing.JButton();
        StrategyDropDown = new javax.swing.JComboBox();
        StockDropDown = new javax.swing.JComboBox();
        submitPairing = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        stockStrategyPair = new javax.swing.JList();
        RunExperiment = new javax.swing.JButton();
        trialField = new javax.swing.JSpinner();
        durationField = new javax.swing.JSpinner();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        startDateField = new javax.swing.JTextField();
        endDateField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        resultList = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Experiment");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        name.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        name.setText("Name: NAME_OF_EXPERIMENT");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel2.setText("Strategies");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel3.setText("Stocks");

        edit.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        edit.setText("Edit(?)");
        edit.setPreferredSize(new java.awt.Dimension(100, 50));
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        back.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        back.setText("Back");
        back.setPreferredSize(new java.awt.Dimension(100, 50));
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        StrategyDropDown.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        StrategyDropDown.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        StrategyDropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StrategyDropDownActionPerformed(evt);
            }
        });

        StockDropDown.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        StockDropDown.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        StockDropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StockDropDownActionPerformed(evt);
            }
        });

        submitPairing.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        submitPairing.setText("Submit Pairing");
        submitPairing.setPreferredSize(new java.awt.Dimension(190, 50));
        submitPairing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitPairingActionPerformed(evt);
            }
        });

        stockStrategyPair.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        stockStrategyPair.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(stockStrategyPair);

        RunExperiment.setText("Run Experiment");
        RunExperiment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RunExperimentActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Start Date");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("End Date");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("# Trials");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Duration (days)");

        startDateField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startDateFieldActionPerformed(evt);
            }
        });

        endDateField.setToolTipText("");

        resultList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(resultList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(name)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 229, Short.MAX_VALUE)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(RunExperiment)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(StrategyDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(StockDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 83, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(startDateField, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                                    .addComponent(endDateField)
                                    .addComponent(durationField, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                                    .addComponent(trialField)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(submitPairing, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(52, 52, 52))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(StrategyDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(StockDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(startDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(endDateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(trialField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(durationField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(RunExperiment))
                    .addComponent(submitPairing, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        parent.setLocation(this.getX() + this.getWidth()/2 - parent.getWidth()/2,
                this.getY() + this.getHeight()/2 - parent.getHeight()/2);
        parent.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        dialogInput di = new dialogInput(this, true);
        String text = di.run();
        if(text.length() > 0){
            name.setText("Name: " + text);
        }
    }//GEN-LAST:event_editActionPerformed
    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        this.setVisible(false);
        parent.setLocation(this.getX() + this.getWidth()/2 - parent.getWidth()/2,
                this.getY() + this.getHeight()/2 - parent.getHeight()/2);
        parent.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    private void StrategyDropDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StrategyDropDownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StrategyDropDownActionPerformed

    private void StockDropDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StockDropDownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StockDropDownActionPerformed

    private void submitPairingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitPairingActionPerformed
            String stock = StockComboBoxModel.getElementAt(StockDropDown.getSelectedIndex()).toString();
            String strategy = StrategyComboBoxModel.getElementAt(StrategyDropDown.getSelectedIndex()).toString();
            pairingListModel.addElement(strategy + " applied to: " + stock);
            this.experiment.addTrial(strategy, stock);

    }//GEN-LAST:event_submitPairingActionPerformed

    private void RunExperimentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RunExperimentActionPerformed
        // TODO add your handling code here:
        LocalDate startDate = LocalDate.parse(startDateField.getText().toString());
        LocalDate endDate =LocalDate.parse(endDateField.getText().toString());
        int ntrials = Integer.parseInt(trialField.getValue().toString());
        int duration = Integer.parseInt(durationField.getValue().toString());
        resultListModel.removeAllElements();
        //System.out.println(startDateField.getText());
        TimeSet ts = new TimeSet(ntrials, duration,startDate, endDate);
        List<String> resultString = experimentEngine.runExperiment(experiment, ts);
        for (String line: resultString){
            resultListModel.addElement(line);
        }
    }//GEN-LAST:event_RunExperimentActionPerformed

    private void startDateFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startDateFieldActionPerformed
            // TODO add your handling code here:
        System.out.println(startDateField.getText());
    }//GEN-LAST:event_startDateFieldActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RunExperiment;
    private javax.swing.JComboBox StockDropDown;
    private javax.swing.JComboBox StrategyDropDown;
    private javax.swing.JButton back;
    private javax.swing.JSpinner durationField;
    private javax.swing.JButton edit;
    private javax.swing.JTextField endDateField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel name;
    private javax.swing.JList resultList;
    private javax.swing.JTextField startDateField;
    private javax.swing.JList stockStrategyPair;
    private javax.swing.JButton submitPairing;
    private javax.swing.JSpinner trialField;
    // End of variables declaration//GEN-END:variables
}
