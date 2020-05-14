/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanager;

/**
 *
 * @author George
 */
public abstract class LibraryItem implements Comparable<LibraryItem>{
    
    protected String title;
    protected int publicationDate;
    protected int ISBN;
    protected String sector;
    protected Reader reader;
    protected DateTime dateTime;
    protected boolean borrowed;
    protected int borrowedHours;
    protected double currentFine;
    
    public LibraryItem(String title, int publicationDate, int ISBN, String Sector){
        this.title= title;
        this.publicationDate=publicationDate;
        this.ISBN=ISBN;
        this.sector=Sector;
        this.borrowed = false;
        this.dateTime = null;
        //this.borrowedHours=0;
        this.currentFine=0;
        
        
    }
    
    public LibraryItem(Reader r){
        this.reader=r;
    }
    
    public void setTitle(String title){
        this.title=title;
    }
    
    public String getTitle(){
        return title;
    }
    
    public void setPublicationDate(int publicationDate){
        this.publicationDate=publicationDate;
    }
    
    public int getPublicatioDate(){
        return publicationDate;
    }
    
    public void setISBN(int ISBN){
        this.ISBN=ISBN;
    }
    public int getISBN(){
        return ISBN;
    }
    
    public void setSector(String sector){
        this.sector=sector;
    }
    public String getSector(){
        return sector;
    }
    
    public void setReader(Reader r){
        this.reader=r;
    }
    
    public Reader getReader(){
        return reader;
    }
    
    public void setDateTime(DateTime d){
        this.dateTime=d;
    }
    
    public DateTime getDateTime(){
        return dateTime;
    }
    
    public void setBorrow(boolean borrowed){
        this.borrowed=borrowed;
    }
    
    public boolean getBorrow(){
        return borrowed;
    }
    
    public void setBorrowedHours(int borrowedHours){
        this.borrowedHours=borrowedHours;
    }
    
    public int getBorrowedHours(){
        return borrowedHours;
    }
    
    public void setCurrentFine(double currentFine){
        this.currentFine=currentFine;
    }
    
    public double getCurrentFine(){
        return currentFine;
    }
    
    public String toString(){
        return "Hours overdue: " + borrowedHours + " ISBN: " + ISBN + " Title: " + title + " Fine: " + currentFine;
    }
    
    public String searchResult(){
        return "\nTitle: " + title + "\nISBN: " + ISBN + "\nPublication Date: " + publicationDate + "\nSector: " + sector + 
                "\nBorrowed: " + borrowed + "\nItem type: ";
    }
    
    public int compareTo(LibraryItem i){
        int value = 0;
        if(this.borrowedHours > i.getBorrowedHours()){
            value = 1;
        } else {
            value=-1;
        }
        return value;
            
    }
    
    public abstract String getItemType();
    
    public abstract int getMaxBorrow();
}
