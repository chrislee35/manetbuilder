/*
 * ApplicationMenu.java
 *
 * Created on August 29, 2004, 10:48 PM
 */

package org.dhs.chrislee.manetbuilder;
import org.dhs.chrislee.manetbuilder.application.Application;

/**
 *
 * @author  chris
 */
public class ApplicationMenu extends javax.swing.JDialog {
    java.util.Vector names;
    java.util.ArrayList backup;
    java.util.ArrayList nodes;
    Node node;
    
    /** Creates new form ApplicationMenu */
    public ApplicationMenu(java.awt.Frame parent, boolean modal, Node node, java.util.ArrayList nodes) {
        super(parent, modal);
        initComponents();
        backup = new java.util.ArrayList();
        names = new java.util.Vector();
        this.node = node;
        this.nodes = nodes;
        if ( node.app != null )
            for ( int i = 0; i < node.app.size(); i++ ) {
                backup.add( node.app.get( i ) );
                names.add( ((Application)node.app.get(i)).getName() );
                System.out.println("AppMenu: "+ ((Application)node.app.get( i )).getName());
            }
        jListApplication.setListData( names );
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPaneApplication = new javax.swing.JScrollPane();
        jListApplication = new javax.swing.JList();
        jPanel1 = new javax.swing.JPanel();
        jButtonAdd = new javax.swing.JButton();
        jButtonEdit = new javax.swing.JButton();
        jButtonRemove = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonCancel = new javax.swing.JButton();
        jButtonOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Application Menu");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        jListApplication.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jListApplication.setMinimumSize(new java.awt.Dimension(0, 230));
        jListApplication.setPreferredSize(new java.awt.Dimension(0, 230));
        jScrollPaneApplication.setViewportView(jListApplication);

        getContentPane().add(jScrollPaneApplication, java.awt.BorderLayout.WEST);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        jButtonAdd.setMnemonic('a');
        jButtonAdd.setText("Add");
        buttonGroup1.add(jButtonAdd);
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jPanel1.add(jButtonAdd);

        jButtonEdit.setMnemonic('e');
        jButtonEdit.setText("Edit");
        buttonGroup1.add(jButtonEdit);
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        jPanel1.add(jButtonEdit);

        jButtonRemove.setMnemonic('r');
        jButtonRemove.setText("Remove");
        buttonGroup1.add(jButtonRemove);
        jButtonRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemoveActionPerformed(evt);
            }
        });

        jPanel1.add(jButtonRemove);

        jPanel1.add(jSeparator1);

        jButtonCancel.setMnemonic('c');
        jButtonCancel.setText("Cancel");
        buttonGroup1.add(jButtonCancel);
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        jPanel1.add(jButtonCancel);

        jButtonOk.setMnemonic('o');
        jButtonOk.setText("Ok");
        buttonGroup1.add(jButtonOk);
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        jPanel1.add(jButtonOk);

        getContentPane().add(jPanel1, java.awt.BorderLayout.EAST);

        pack();
    }//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        jScrollPaneApplication.setSize( this.getWidth() - 87, this.getHeight() );
    }//GEN-LAST:event_formComponentResized

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
        node.app = backup;
        for ( int i = 0; i < backup.size(); i++ ) {
            System.out.println("AppMenu Ok: "+ ((Application)backup.get(i)).getName());
        }
        dispose();
    }//GEN-LAST:event_jButtonOkActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    private void jButtonRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemoveActionPerformed
        if ( jListApplication.getSelectedIndex() != -1 )
            return;
        backup.remove( jListApplication.getSelectedIndex() );
        names.remove( jListApplication.getSelectedIndex() );
        jListApplication.setListData( names );
    }//GEN-LAST:event_jButtonRemoveActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        if ( jListApplication.getSelectedIndex() != -1 )
            return;
        ((Application)backup.get( jListApplication.getSelectedIndex() )).showConfigurationDialog( (javax.swing.JFrame)this.getParent(), node, nodes );
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        NodePropertyDialogs.showApplicationDialog( (javax.swing.JFrame)this.getParent(), node, nodes );
        backup.add( node.app.get( node.app.size() - 1 ) );
        names.add( ((Application)node.app.get( node.app.size() - 1 ) ).getName() );
        jListApplication.setListData( names );
    }//GEN-LAST:event_jButtonAddActionPerformed
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonOk;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JList jListApplication;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPaneApplication;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
    
}
