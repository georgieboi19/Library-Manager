/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanager;

import static com.sun.management.jmx.Trace.isSelected;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import static javax.management.Query.value;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

/**
 *
 * @author George
 */
public class JFrameWindow extends AbstractTableModel{
    //sets up table using abstract table model
    protected String[] columnName = {"Title", "ISBN", "Publication Date", "Sector", "Item Type", "Borrowed Status" };
    protected ArrayList<LibraryItem> libraryList;
    
    
    
    public JFrameWindow(ArrayList<LibraryItem> libraryList){
        this.libraryList = libraryList;
    }

    
    
   public int getRowCount(){
       return libraryList.size();
   }

    
    public int getColumnCount() {
        return columnName.length;
    }

    
    public Object getValueAt(int row, int column) {
        
        Object t = null;
        if (column == 0){
            t = libraryList.get(row).getTitle();
        } else if (column == 1) {
            t = libraryList.get(row).getISBN();
        } else if (column == 2){
            t = libraryList.get(row).getPublicatioDate();
        } else if (column == 3){
            t = libraryList.get(row).getSector();
        } else if (column == 4){
            t = libraryList.get(row).getItemType();
        } else if (column == 5){
            if (libraryList.get(row).getBorrow()== true){
                t = "Borrowed";
            } else {
              t = "Availible";
            }
        }
        return t;
        
    }
    public String getColumnName(int column){
        return columnName[column];
    }
    public Class getColumnClass(int column){
        if (column ==1 || column == 2){
            return int.class;
        } else {
            return String.class;
        }
    }
}

