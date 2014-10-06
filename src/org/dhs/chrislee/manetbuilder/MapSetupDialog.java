/*
 * MapSetupDialog.java
 *
 * Created on August 20, 2004, 10:31 PM
 */

package org.dhs.chrislee.manetbuilder;

/**
 *
 * @author  chris
 */
public class MapSetupDialog extends javax.swing.JDialog {
    MapPanel mp = null;
    java.awt.Image background = null;
    
    /** Creates new form MapSetupDialog */
    public MapSetupDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldBgImage = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldWidth = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldHeight = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldSimTime = new javax.swing.JTextField();
        jButtonBrowse = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabelRatio = new javax.swing.JLabel();
        jButtonCancel = new javax.swing.JButton();
        jButtonOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("New Map");
        jPanel1.setLayout(null);

        jPanel1.setPreferredSize(new java.awt.Dimension(440, 170));
        jLabel1.setText("Background");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 20, 74, 16);

        jTextFieldBgImage.setText("<none>");
        jTextFieldBgImage.setFocusCycleRoot(true);
        jTextFieldBgImage.setNextFocusableComponent(jTextFieldWidth);
        jTextFieldBgImage.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextFieldBgImagePropertyChange(evt);
            }
        });

        jPanel1.add(jTextFieldBgImage);
        jTextFieldBgImage.setBounds(120, 15, 175, 21);

        jLabel2.setText("Width");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 50, 36, 16);

        jTextFieldWidth.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldWidth.setText("1000");
        jTextFieldWidth.setNextFocusableComponent(jTextFieldHeight);
        jTextFieldWidth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldWidthActionPerformed(evt);
            }
        });

        jPanel1.add(jTextFieldWidth);
        jTextFieldWidth.setBounds(120, 45, 75, 21);

        jLabel3.setText("Height");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 80, 42, 16);

        jTextFieldHeight.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldHeight.setText("1000");
        jTextFieldHeight.setNextFocusableComponent(jTextFieldSimTime);
        jTextFieldHeight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldHeightActionPerformed(evt);
            }
        });

        jPanel1.add(jTextFieldHeight);
        jTextFieldHeight.setBounds(120, 75, 75, 21);

        jLabel4.setText("Simulation Time");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 110, 102, 16);

        jTextFieldSimTime.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldSimTime.setText("600");
        jTextFieldSimTime.setNextFocusableComponent(jButtonOk);
        jPanel1.add(jTextFieldSimTime);
        jTextFieldSimTime.setBounds(120, 105, 75, 21);

        jButtonBrowse.setMnemonic('b');
        jButtonBrowse.setText("Browse...");
        jButtonBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBrowseActionPerformed(evt);
            }
        });

        jPanel1.add(jButtonBrowse);
        jButtonBrowse.setBounds(305, 10, 100, 29);

        jLabel5.setText("Ratio");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(200, 60, 32, 16);

        jLabelRatio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelRatio.setText("1.0");
        jPanel1.add(jLabelRatio);
        jLabelRatio.setBounds(235, 60, 45, 16);

        jButtonCancel.setMnemonic('c');
        jButtonCancel.setText("Cancel");
        jButtonCancel.setNextFocusableComponent(jTextFieldBgImage);
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jPanel1.add(jButtonCancel);
        jButtonCancel.setBounds(245, 100, 75, 29);

        jButtonOk.setMnemonic('o');
        jButtonOk.setText("OK");
        jButtonOk.setNextFocusableComponent(jButtonCancel);
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        jPanel1.add(jButtonOk);
        jButtonOk.setBounds(325, 100, 75, 29);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }//GEN-END:initComponents

    private void jTextFieldHeightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHeightActionPerformed
        // TODO add your handling code here:
        try {
            System.out.println("Height: "+jTextFieldHeight.getText() );
            System.out.println("Width: "+jTextFieldWidth.getText() );
            jLabelRatio.setText( Double.toString( Double.parseDouble(jTextFieldHeight.getText()) / Double.parseDouble(jTextFieldWidth.getText()) ) );
        } catch ( NumberFormatException e ) {
            jLabelRatio.setText( "0.0" );
        }
    }//GEN-LAST:event_jTextFieldHeightActionPerformed

    private void jTextFieldWidthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldWidthActionPerformed
        try {
            System.out.println("Height: "+jTextFieldHeight.getText() );
            System.out.println("Width: "+jTextFieldWidth.getText() );
            jLabelRatio.setText( Double.toString( Double.parseDouble(jTextFieldHeight.getText()) / Double.parseDouble(jTextFieldWidth.getText()) ) );
        } catch ( NumberFormatException e ) {
            jLabelRatio.setText( "0.0" );
        }
    }//GEN-LAST:event_jTextFieldWidthActionPerformed

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
        // TODO add your handling code here:
        if ( background == null )
            mp = new MapPanel( Double.parseDouble( jTextFieldHeight.getText() ),
            Double.parseDouble( jTextFieldWidth.getText() ),
            Double.parseDouble( jTextFieldSimTime.getText() ) );
        else
            mp = new MapPanel( Double.parseDouble( jTextFieldHeight.getText() ),
            Double.parseDouble( jTextFieldWidth.getText() ),
            Double.parseDouble( jTextFieldSimTime.getText() ),
            background, jTextFieldBgImage.getText() );
            
        dispose();
        setVisible(false);
    }//GEN-LAST:event_jButtonOkActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        // TODO add your handling code here:
        dispose();
        setVisible(false);
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jTextFieldBgImagePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextFieldBgImagePropertyChange
        // TODO add your handling code here:
        java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
        background = toolkit.getImage( jTextFieldBgImage.getText() );
    }//GEN-LAST:event_jTextFieldBgImagePropertyChange

    private void jButtonBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBrowseActionPerformed
        // TODO add your handling code here:
        javax.swing.JFileChooser chooser;
        chooser = new javax.swing.JFileChooser();
        com.darwinsys.util.JFileFilter filter = new com.darwinsys.util.JFileFilter();
        filter.addType( "jpg" );
        filter.addType( "gif" );
        filter.addType( "png" );
        filter.addType( "bmp" );
        filter.setDescription( "Image Files (*.jpg, *.gif, *.png, *.bmp )" );
        chooser.addChoosableFileFilter( filter );
        int returnVal = chooser.showOpenDialog( null );       
        if ( returnVal == javax.swing.JFileChooser.APPROVE_OPTION ) {
            String filename = chooser.getSelectedFile().getName();
            jTextFieldBgImage.setText( chooser.getSelectedFile().getAbsolutePath() );
        }
        java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
        background = toolkit.getImage( jTextFieldBgImage.getText() );
    }//GEN-LAST:event_jButtonBrowseActionPerformed
    
    public MapPanel getNewMap() {
        return mp;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        MapSetupDialog msd = new MapSetupDialog(new javax.swing.JFrame(), true);
        msd.setVisible( true );
        MapPanel mymp = msd.getNewMap();
        if ( mymp == null )
            System.out.println("Map was null");
        else
            System.out.println("You created a map: "+mymp.getWidth()+"x"+mymp.getHeight());
        msd.dispose();
        System.exit(0);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBrowse;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelRatio;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldBgImage;
    private javax.swing.JTextField jTextFieldHeight;
    private javax.swing.JTextField jTextFieldSimTime;
    private javax.swing.JTextField jTextFieldWidth;
    // End of variables declaration//GEN-END:variables
    
}
