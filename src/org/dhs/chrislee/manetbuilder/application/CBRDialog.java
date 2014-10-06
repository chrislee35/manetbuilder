/*
 * CBRDialog.java
 *
 * Created on August 28, 2004, 9:11 PM
 */

package org.dhs.chrislee.manetbuilder.application;
import org.dhs.chrislee.manetbuilder.Node;
/**
 *
 * @author  chris
 */
public class CBRDialog extends javax.swing.JDialog {
    public static final int CANCEL = -1;
    public static final int OK = 0;
    
    public double starttime = 0;
    public double endtime = 600;
    public double packetInterval = 1.0;
    public int packetSize = 500;
    public int packetCount = 600;
    public double throughput = 300000;
    public int targetnodeid;
    public int returncode = 1;
    
    /** Creates new form CBRDialog */
    public CBRDialog(java.awt.Frame parent, boolean modal, Node node, java.util.ArrayList nodes) {
        super(parent, modal);
        initComponents();
        for ( int i = 0; i < nodes.size(); i++ ) {
            Node thisnode = (Node)nodes.get( i );
            if ( thisnode == null )
                continue;
            if ( thisnode.nodeId == node.nodeId )
                continue;
            jComboBoxTargetNode.addItem( new Integer( thisnode.nodeId ) );
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldStartTime = new javax.swing.JTextField();
        jTextFieldEndTime = new javax.swing.JTextField();
        jTextFieldPacketSize = new javax.swing.JTextField();
        jTextFieldPacketCount = new javax.swing.JTextField();
        jTextFieldPacketInterval = new javax.swing.JTextField();
        jTextFieldTotalThroughput = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButtonCancel = new javax.swing.JButton();
        jButtonOk = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jComboBoxTargetNode = new javax.swing.JComboBox();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CBR Properties Dialog");
        setModal(true);
        setResizable(false);
        jLabel1.setText("Start Time");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel2.setText("End Time");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel3.setText("Packet Size");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel4.setText("Packet Count");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel5.setText("Packet Interval");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jLabel6.setText("Total Throughput");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        jTextFieldStartTime.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldStartTime.setText("0.0");
        jTextFieldStartTime.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldStartTimeFocusLost(evt);
            }
        });
        jTextFieldStartTime.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextFieldStartTimePropertyChange(evt);
            }
        });

        getContentPane().add(jTextFieldStartTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 70, -1));

        jTextFieldEndTime.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldEndTime.setText("600.0");
        jTextFieldEndTime.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextFieldEndTimePropertyChange(evt);
            }
        });

        getContentPane().add(jTextFieldEndTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 70, -1));

        jTextFieldPacketSize.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldPacketSize.setText("500");
        jTextFieldPacketSize.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextFieldPacketSizePropertyChange(evt);
            }
        });

        getContentPane().add(jTextFieldPacketSize, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 70, -1));

        jTextFieldPacketCount.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldPacketCount.setText("600");
        jTextFieldPacketCount.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextFieldPacketCountPropertyChange(evt);
            }
        });

        getContentPane().add(jTextFieldPacketCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 70, -1));

        jTextFieldPacketInterval.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldPacketInterval.setText("1.0");
        jTextFieldPacketInterval.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextFieldPacketIntervalPropertyChange(evt);
            }
        });

        getContentPane().add(jTextFieldPacketInterval, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 70, -1));

        jTextFieldTotalThroughput.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldTotalThroughput.setText("300000");
        jTextFieldTotalThroughput.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextFieldTotalThroughputPropertyChange(evt);
            }
        });

        getContentPane().add(jTextFieldTotalThroughput, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 70, -1));

        jLabel7.setText("sec");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, -1, -1));

        jLabel8.setText("sec");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, -1, -1));

        jLabel9.setText("bytes");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, -1, -1));

        jLabel11.setText("bytes");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, -1, -1));

        jLabel12.setText("sec");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, -1, -1));

        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        getContentPane().add(jButtonCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, -1, -1));

        jButtonOk.setText("Ok");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        getContentPane().add(jButtonOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, -1, -1));

        jLabel10.setText("Target Node");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jComboBoxTargetNode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTargetNodeActionPerformed(evt);
            }
        });

        getContentPane().add(jComboBoxTargetNode, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        pack();
    }//GEN-END:initComponents

    private void jTextFieldStartTimeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldStartTimeFocusLost
        try {
            double starttime = Double.parseDouble(jTextFieldStartTime.getText());
            if ( starttime > 0 )
                this.starttime = starttime;
        } catch ( NumberFormatException e ) {
        }
        updateFields();
    }//GEN-LAST:event_jTextFieldStartTimeFocusLost

    private void jTextFieldTotalThroughputPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextFieldTotalThroughputPropertyChange
        try {
            double total = Double.parseDouble( jTextFieldEndTime.getText() );
            if ( total > 0 ) {
                throughput = total;
                packetCount = (int)Math.round( throughput / packetSize );
            }
        } catch ( NumberFormatException e ) {
        }
        updateFields();
    }//GEN-LAST:event_jTextFieldTotalThroughputPropertyChange

    private void jTextFieldPacketIntervalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextFieldPacketIntervalPropertyChange
        try {
            double packet_interval = Double.parseDouble( jTextFieldPacketInterval.getText() );
            if ( packet_interval > 0 )
                packetInterval = packet_interval;
        } catch ( NumberFormatException e ) {
        }
        updateFields();
    }//GEN-LAST:event_jTextFieldPacketIntervalPropertyChange

    private void jTextFieldPacketCountPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextFieldPacketCountPropertyChange
        try {
            int packet_count = Integer.parseInt( jTextFieldPacketCount.getText() );
            if ( packet_count > 0 ) {
                packetCount = packet_count;
                packetInterval = (endtime-starttime)/packetCount;
            }
        } catch ( NumberFormatException e ) {
        }
        updateFields();
    }//GEN-LAST:event_jTextFieldPacketCountPropertyChange

    private void jTextFieldPacketSizePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextFieldPacketSizePropertyChange
        try {
            int packet_size = Integer.parseInt( jTextFieldPacketSize.getText() );
            if ( packet_size > 0 )
               packetSize = packet_size;
        } catch ( NumberFormatException e ) {
        }
        updateFields();
    }//GEN-LAST:event_jTextFieldPacketSizePropertyChange

    private void jTextFieldEndTimePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextFieldEndTimePropertyChange
        try {
            double end_time = Double.parseDouble( jTextFieldEndTime.getText() );
            if ( end_time > starttime )
                endtime = end_time;
        } catch ( NumberFormatException e ) {
        }
        updateFields();
    }//GEN-LAST:event_jTextFieldEndTimePropertyChange

    private void jTextFieldStartTimePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextFieldStartTimePropertyChange
        try {
            double starttime = Double.parseDouble(jTextFieldStartTime.getText());
            if ( starttime > 0 )
                this.starttime = starttime;
        } catch ( NumberFormatException e ) {
        }
        updateFields();
    }//GEN-LAST:event_jTextFieldStartTimePropertyChange

    private void jComboBoxTargetNodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTargetNodeActionPerformed
        jButtonOk.enable( true );
    }//GEN-LAST:event_jComboBoxTargetNodeActionPerformed

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
        returncode = OK;
        targetnodeid = ((Integer)jComboBoxTargetNode.getSelectedItem()).intValue() - 1;
        this.dispose();
    }//GEN-LAST:event_jButtonOkActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        returncode = CANCEL;
        this.dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed
        
    void updateFields() {
        //System.out.println("Updating fields...");
        double duration = endtime - starttime;
        packetCount = (int) ( duration / packetInterval );
        throughput = packetSize * packetCount;
        jTextFieldStartTime.setText( new Double( this.starttime ).toString() );
        jTextFieldEndTime.setText( new Double( this.endtime ).toString() );
        jTextFieldPacketSize.setText( new Integer( this.packetSize ).toString() );
        jTextFieldPacketCount.setText( new Integer( this.packetCount ).toString() );
        jTextFieldPacketInterval.setText( new Double( this.packetInterval ).toString() );
        jTextFieldTotalThroughput.setText( new Double( this.throughput ).toString() );
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JComboBox jComboBoxTargetNode;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextFieldEndTime;
    private javax.swing.JTextField jTextFieldPacketCount;
    private javax.swing.JTextField jTextFieldPacketInterval;
    private javax.swing.JTextField jTextFieldPacketSize;
    private javax.swing.JTextField jTextFieldStartTime;
    private javax.swing.JTextField jTextFieldTotalThroughput;
    // End of variables declaration//GEN-END:variables
    
}