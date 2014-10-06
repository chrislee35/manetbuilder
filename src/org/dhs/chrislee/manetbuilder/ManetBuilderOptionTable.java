/*
 * ManetBuilderOptionTable.java
 *
 * Created on August 23, 2004, 7:41 PM
 */

package org.dhs.chrislee.manetbuilder;
import javax.swing.*;
/**
 *
 * @author  chris
 */
public class ManetBuilderOptionTable extends javax.swing.table.AbstractTableModel {
    static final boolean DEBUG = false;
    
    public static final int NODE_ID_ROW         = 0;
    public static final int NODE_LOCATION_ROW   = 1;
    public static final int NODE_MOBILITY_ROW   = 2;
    public static final int NODE_PHY_ROW        = 3;
    public static final int NODE_POWER_ROW      = 4;
    public static final int NODE_MAC_ROW        = 5;
    public static final int NODE_ROUTING_ROW    = 6;
    public static final int NODE_TRANSPORT_ROW  = 7;
    public static final int NODE_APP_ROW        = 8;
    
    private String[] columnNames = {"Property", "Value" };
    private Object[][] data;
    
    /** Creates a new instance of ManetBuilderOptionTable */
    public ManetBuilderOptionTable() {        
        data = new Object[][] {
            { "Node Id", "0" },
            { "Location", "0,0" },
            { "Mobility", "None" },
            { "Phy Layer", "Ideal (200m)" },
            { "Power Model", "None" },
            { "Mac Layer", "802_11 MAC" },
            { "Routing Layer", "AODV" },
            { "Transport Layer", "TCP/IP-Sack" },
            { "App Layer", "None" },
        };
        
    }
    
    public ManetBuilderOptionTable( Node node ) {
        data = new Object[][] {
            { "Node Id", ""+node.nodeId },
            { "Location", node.x+","+node.y },
            { "Mobility", "None" },
            { "Phy Layer", "Ideal (200m)" },
            { "Power Model", "None" },
            { "Mac Layer", "Aloha" },
            { "Routing Layer", "AODV" },
            { "Transport Layer", "TCP/IP-Sack" },
            { "App Layer", "None" },
        };
        
    }
   
    public int getColumnCount() {
        return columnNames.length;
    }
    
    public int getRowCount() {
        if ( data == null )
            return 0;
        return data.length;
    }
    
    public String getColumnName(int col) {
        return columnNames[col];
    }

    
    public Object getValueAt(int row, int col) {
        if ( data == null )
            return null;
        return data[row][col];
    }

    /*
     * JTable uses this method to determine the default renderer/
     * editor for each cell.  If we didn't implement this method,
     * then the last column would contain text ("true"/"false"),
     * rather than a check box.
     */
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    /*
     * Don't need to implement this method unless your table's
     * data can change.
     */
    public void setValueAt(Object value, int row, int col) {
        if (DEBUG) {
            System.out.println("Setting value at " + row + "," + col
                               + " to " + value
                               + " (an instance of "
                               + value.getClass() + ")");
        }

        data[row][col] = value;
        fireTableCellUpdated(row, col);

        if (DEBUG) {
            System.out.println("New value of data:");
            printDebugData();
        }
    }

    private void printDebugData() {
        int numRows = getRowCount();
        int numCols = getColumnCount();

        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + data[i][j]);
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }

}
