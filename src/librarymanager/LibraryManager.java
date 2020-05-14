/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanager;

import java.util.ArrayList;

/**
 *
 * @author George
 */
public interface LibraryManager {
    //provides interface for all menu options
    public abstract void addBook(LibraryItem book);
    public abstract void addDVD(LibraryItem dvd);
    public abstract void deleteItem(int ISBN);
    public abstract void printLibraryList();
    public abstract void borrowItem(int ISBN, Reader r, DateTime t);
    public abstract void returnItem(int ISBN, DateTime t1);
    public abstract void generateReport(DateTime t2);
    public abstract void startGUI(ArrayList<LibraryItem> libraryList);
    public abstract boolean runMenu();
}
