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
public class Book extends LibraryItem{
    private String author;
    private String publisher;
    private int totalPages;
    
    public Book(String title, int publicationDate, int ISBN, String sector, String author, String publisher, int totalPages){
        super(title, publicationDate, ISBN, sector);
        this.author=author;
        this.publisher=publisher;
        this.totalPages=totalPages;
    }
    
    public void setAuthor(String author){
        this.author=author;
    }
    
    public void setPublisher(String publisher){
        this.publisher=publisher;
    }
    
    public void setTotalPages(int totalPages){
        this.totalPages=totalPages;
    }
    
    public String getAuthor(){
        return author;
    }
    
    public String getPublisher(){
        return publisher;
    }
    
    public int getTotalPages(){
        return totalPages;
    }
    
    public String getItemType(){
        return "Book";
    }
    
    public int getMaxBorrow(){
        return 3;
    }
}
