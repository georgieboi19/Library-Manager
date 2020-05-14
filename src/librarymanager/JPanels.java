/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author George
 */
public class JPanels extends JFrame{
    
    protected ArrayList<LibraryItem> libraryList;
    JButton b;
    JButton addItem;
    JTextField title;
    
    public JPanels(ArrayList<LibraryItem> libraryList){
        
        this.libraryList=libraryList;
        
        JFrameWindow test = new JFrameWindow(libraryList);
        JTable table = new JTable(test);
        
        JScrollPane scrollPane = new JScrollPane(table);
        table.setGridColor(Color.white);
        table.setBackground(Color.black);
        table.setForeground(Color.white);
        
        JPanel p1 = new JPanel(new BorderLayout());
        add(p1);
        p1.add(scrollPane, BorderLayout.CENTER);
        p1.setBackground(Color.WHITE);
        p1.add(new JLabel("Westminster Library Manager Portal"), BorderLayout.NORTH);
        
        
        JPanel p2 = new JPanel(new GridLayout(1,2));
        p2.add (title = new JTextField("Enter Title"));
        p2.add(b = new JButton("Search"));
        p1.add(p2, BorderLayout.SOUTH);
        Listener searchEvent = new Listener();
        b.addActionListener(searchEvent);
        
    }
    //listener to provide action when the button is pressed
    private class Listener implements ActionListener {
            
            public void actionPerformed(ActionEvent e){
                if(e.getSource() == b){
                    String titleText = title.getText();
                    for(int i = 0; i < libraryList.size(); i++){
                        if(libraryList.get(i).getTitle().equals(titleText)){
                            String itemType = libraryList.get(i).getItemType();
                            String string = "Item Found! \n" + libraryList.get(i).searchResult() + itemType;
                            JOptionPane.showMessageDialog(null, string);
                        } else {
                            String string = "No item was found matching that title";
                            JOptionPane.showMessageDialog(null, string);
                        }
                    }
                } 
                
            }
        }
}
