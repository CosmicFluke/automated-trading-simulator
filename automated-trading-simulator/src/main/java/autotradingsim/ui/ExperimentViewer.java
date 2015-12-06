package autotradingsim.ui;
import autotradingsim.application.*;
import autotradingsim.engine.*;
import autotradingsim.experiment.*;
import autotradingsim.stocks.*;
import autotradingsim.strategy.IStrategy;
import java.time.LocalDate;
import javax.swing.*;
import java.util.*;
import autotradingsim.util.Pair;
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
    DefaultListModel strategyListModel = new DefaultListModel();
    DefaultListModel stockListModel = new DefaultListModel();
    IExperiment experiment;
    //IExperiment experiment = application.getExperiment(name.getText());
    public ExperimentViewer(ExperimentList parent, IExperiment experiment) {
        this.parent = parent;
        initComponents();
        this.setLocation(parent.getX() + parent.getWidth()/2 - this.getWidth()/2,
                parent.getY() + parent.getHeight()/2 - this.getHeight()/2);
        startDate.setText("2015-10-16");
        endDate.setText("2015-10-17");
        strategyList.setModel(strategyListModel);
        stockList.setModel(stockListModel);
        this.experiment = experiment;
    }
    
    protected void settimeSetValidationField(){
        Pair<LocalDate, LocalDate> timeset= experimentEngine.generateTimeSet(experiment);
        if(timeset == null){
            //timeSetValidationField.setText("Experiment has no valid timeset");
        }else{
            //timeSetValidationField.setText("Valid time period: "+timeset.x+"-"+timeset.y);
        }
    }
    
    protected void setExperiment(IExperiment experiment){
        this.experiment = experiment;
        settimeSetValidationField();
    }

    protected void setNameText(String filename){
        name.setText("Name: " + filename);
    }
    /**
     * populates strategy drop down with list of strategy
     */
    protected void setStrategyList(){
        for(IStrategy stratname: experiment.getAllStrategies()){
            strategyListModel.addElement(stratname.getName());
        }
    }
    /**
     * populates stock drop down with list of stock symbols
    */
    protected void setStockList(){
       // Iterator symbols = application.getStockSymbols();
        Iterator<IStock> symbols = experiment.getAllStocks().iterator();
        while(symbols.hasNext()){
            stockListModel.addElement(symbols.next().getSymbol());
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

        edit = new javax.swing.JButton();
        back = new javax.swing.JButton();
        name = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        strategyList = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        stockList = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        run = new javax.swing.JButton();
        addTrial = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        startDate = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        endDate = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        trials = new javax.swing.JSpinner();
        duration = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Experiment Viewer");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        edit.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        edit.setText("Edit");
        edit.setPreferredSize(new java.awt.Dimension(150, 50));

        back.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        back.setText("Back");
        back.setPreferredSize(new java.awt.Dimension(150, 50));
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        name.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        name.setText("Name: NAME_OF_EXPERIMENT");
        name.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel2.setText("Strategies");

        strategyList.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        strategyList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        strategyList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                strategyListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(strategyList);

        stockList.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        stockList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(stockList);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setText("Stocks");

        run.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        run.setText("Run");
        run.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runActionPerformed(evt);
            }
        });

        addTrial.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        addTrial.setText("Add Trial");
        addTrial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTrialActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel4.setText("Start Date:");

        startDate.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        startDate.setPreferredSize(new java.awt.Dimension(140, 40));

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("End Date:");

        endDate.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        endDate.setPreferredSize(new java.awt.Dimension(140, 40));

        jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("# of Trials:");

        jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel6.setText("Duration (days):");

        trials.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N

        duration.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N

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
                        .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(1, 1, 1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(startDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(endDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(trials, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(duration))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(run, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(306, 306, 306)
                .addComponent(addTrial, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(edit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addTrial, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(startDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(trials, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(run, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(duration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        parent.setLocation(this.getX() + this.getWidth()/2 - parent.getWidth()/2,
                this.getY() + this.getHeight()/2 - parent.getHeight()/2);
        parent.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void strategyListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_strategyListMouseClicked
        /**Map<String, List<String>> strategyToStocks = this.experiment.getAllTrials();
        String strategy = (String)strategyListModel.get(strategyList.getSelectedIndex());
        for(Object s : strategyToStocks.keySet()){
            System.out.println(s.toString());
        }
        for(String stockname: strategyToStocks.get(strategy)){
            stockListModel.addElement(stockname);
        }**/
    }//GEN-LAST:event_strategyListMouseClicked

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        parent.setLocation(this.getX() + this.getWidth()/2 - parent.getWidth()/2, 
                           this.getY() + this.getHeight()/2 - parent.getHeight()/2);
        this.setVisible(false);
        parent.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    private void addTrialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTrialActionPerformed
        TrialPicker tp = new TrialPicker(this, true);
        Pair<String, String> trial = tp.run();
        experiment.addTrial(trial.x, trial.y);
        application.setExperiment(experiment.getName(), experiment);
        strategyListModel.addElement(trial.x);
        stockListModel.addElement(trial.y);
        
        
    }//GEN-LAST:event_addTrialActionPerformed

    private void runActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runActionPerformed
        // TODO add your handling code here:
        dialogResult dialogResult = new dialogResult(this, true);
        dialogResult.setVisible(true);

        // Retrieving All instantiate a TimeSet.
        int numTrials = (int) duration.getValue();
        int trialDuration = (int) trials.getValue();

        String[] startDateTokens = startDate.getText().trim().split("-");
        int startYear = Integer.parseInt(startDateTokens[0]),
                startMonth = Integer.parseInt(startDateTokens[1]),
                startDayOfMonth = Integer.parseInt(startDateTokens[2]);

        String[] endDateTokens = endDate.getText().trim().split("-");
        int endYear = Integer.parseInt(endDateTokens[0]),
                endMonth = Integer.parseInt(endDateTokens[1]),
                endDayOfMonth = Integer.parseInt(endDateTokens[2]);

        LocalDate startDate = LocalDate.of(startYear, startMonth, startDayOfMonth);
        LocalDate endDate = LocalDate.of(endYear, endMonth, endDayOfMonth);
        TimeSet timeSet = new TimeSet(numTrials, trialDuration, startDate, endDate);

        ExperimentResults experimentResults = this.experiment.runExperiment(timeSet);


    }//GEN-LAST:event_runActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTrial;
    private javax.swing.JButton back;
    private javax.swing.JSpinner duration;
    private javax.swing.JButton edit;
    private javax.swing.JTextField endDate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel name;
    private javax.swing.JButton run;
    private javax.swing.JTextField startDate;
    private javax.swing.JList stockList;
    private javax.swing.JList strategyList;
    private javax.swing.JSpinner trials;
    // End of variables declaration//GEN-END:variables
}
