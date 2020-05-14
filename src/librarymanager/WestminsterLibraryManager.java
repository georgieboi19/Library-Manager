/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarymanager;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author George
 */
public class WestminsterLibraryManager implements LibraryManager{

    private ArrayList<LibraryItem> libraryList;
    private final int maxDVD = 50;
    private final int maxBook = 100;
    private int totalBook;
    private int totalDVD;
    
    public WestminsterLibraryManager(int listLenght){
        libraryList = new ArrayList<>();
        this.totalBook=0;
        this.totalDVD=0;
        
    }
    //method of adding book to the list - kept seperate as to increment correctly
    public void addBook(LibraryItem book){
        if (totalBook < maxBook) {
            libraryList.add(book);
            totalBook++;
            
            //error handling
        } else{
            System.out.println("The book section is full");
        }
    }
    
    public void addDVD(LibraryItem dvd){
        if (totalDVD < maxDVD) {
            libraryList.add(dvd);
            totalDVD++;
            
        } else{
            System.out.println("The DVD section is full");
        }
    }
    //simply prints every item in the list
    public void printLibraryList(){
        for(int i = 0; i < libraryList.size(); i++){
            System.out.println("ISBN: " + libraryList.get(i).getISBN()
                    + " Item type: " + libraryList.get(i).getItemType()
                    + " Title: " + libraryList.get(i).getTitle());
            
        }
        System.out.println("Print complete");
    }
    //removes item from array and decreases the count
    public void deleteItem(int ISBN){
        for(int i = 0; i < libraryList.size(); i++){
            if(libraryList.get(i).getISBN() == (ISBN)){
                libraryList.remove(i);
                if (libraryList.get(i).getItemType().equals("DVD")){
                    totalDVD--;
                }else {
                    totalBook--;
                }
                System.out.println("Item deleted");
            }else{
                System.out.println("Sorry, no item was found");
            }
        }
        
    }
    
    public void borrowItem(int ISBN, Reader r, DateTime t){
        for (int i=0; i< libraryList.size(); i++){
            if (libraryList.get(i).getISBN() == (ISBN)) {
                if(libraryList.get(i).getBorrow() == false){
                    libraryList.get(i).setReader(r);
                    libraryList.get(i).setDateTime(t);
                    libraryList.get(i).setBorrow(true);
                    System.out.println("The " + libraryList.get(i).getItemType() + " titled: " + libraryList.get(i).getTitle() + " is availible and has been updated to borrowed.");
                    System.out.println("You are able to borrow this item for " + libraryList.get(i).getMaxBorrow() + " days.");
                    System.out.println("Item borrowed at: " + libraryList.get(i).getDateTime().toString());
                    
                } else {
                    System.out.println("Sorry the item is not availible.");
                    String date1= libraryList.get(i).getDateTime().toString();
                    String date2 = t.toString();
                    //using the current date to update the date in the correct format
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    
                    try{
                        Date d1 = dateFormat.parse(date1);
                        Date d2 = dateFormat.parse(date2);
                        
                        long dif = d2.getTime() - d1.getTime();
                        //working out the time difference between the two dates
                        long difMinute = dif /(60 * 1000) % 60;
                        long difHour = dif / (60 * 60 * 1000) %24;
                        long difDay = dif / (24*60*60*1000);
                        
                        System.out.println("The item will be available in: " + (libraryList.get(i).getMaxBorrow()-difDay) + " days, " + (difHour) + " hours and " + (60-difMinute) + " minutes.");
                    }catch (Exception e){
                        
                    }
                   
                    
                }
                
            }else {
                System.out.println("Sorry, no item was found");
                
                
            }
        }
    }
    
    public void returnItem(int ISBN, DateTime t1){
        for(int i = 0; i < libraryList.size(); i++){
            if(libraryList.get(i).getISBN() == (ISBN)){
                libraryList.get(i).setBorrow(false);
                libraryList.get(i).setReader(null);
                
                    String date1= libraryList.get(i).getDateTime().toString();
                    String date2 = t1.toString();
//calculate date difference
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

                try {
                    Date d1 = dateFormat.parse(date1);
                    Date d2 = dateFormat.parse(date2);

                    long dif = d2.getTime() - d1.getTime();

                    long difMinute = dif / (60 * 1000) % 60;
                    long difHour = dif / (60 * 60 * 1000) % 24;
                    long difDay = dif / (24 * 60 * 60 * 1000);

                    int hours = (int) ((int) (difDay * 24) + difHour);
                    double fine = 0;
                    //works out if the item has been borrowed for longer than the max borrow for each item
                    int maxDay = libraryList.get(i).getMaxBorrow();
                    int hoursOverdue = hours - (libraryList.get(i).getMaxBorrow() * 24);
                    //provides fine calculation
                    if (difDay <= maxDay) {
                        System.out.println("Your item has been returned with no fine");
                    } else if (difDay < (maxDay + 3) && difDay > 0) {
                        fine = hoursOverdue * 0.2;
                        System.out.println("The item is overdue by: " + (difDay) + " days, " + (difHour) + " hours and " + (difMinute) + " minutes.");
                    } else {
                        int fine1Hours = 24 * 3;
                        System.out.println("The item is overdue by: " + (difDay) + " days, " + (difHour) + " hours and " + (difMinute) + " minutes.");
                        fine = (fine1Hours * 0.2) + (hoursOverdue - fine1Hours) * 0.5;
                    }

                    System.out.println("The fine to pay is: £" + fine + " as the item is " + hours + " overdue.");
                    libraryList.get(i).setDateTime(null);
                } catch (Exception e) {

                }
                
            }else{
                System.out.println("Sorry, no item was found");
            }
        }
    }
    
    public void generateReport(DateTime t2) {
        for (int i = 0; i < libraryList.size(); i++) {
            if (libraryList.get(i).borrowed == true) {

                String date1 = libraryList.get(i).getDateTime().toString();
                String date2 = t2.toString();

                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

                try {

                    Date d1 = dateFormat.parse(date1);
                    Date d2 = dateFormat.parse(date2);

                    long dif = d2.getTime() - d1.getTime();

                    long difMinute = dif / (60 * 1000) % 60;
                    long difHour = dif / (60 * 60 * 1000) % 24;
                    long difDay = dif / (24 * 60 * 60 * 1000);

                    int maxDay = libraryList.get(i).getMaxBorrow();
                    int hours = (int) ((int) (difDay * 24) + difHour);
                    int hoursOverdue = hours - (libraryList.get(i).getMaxBorrow() * 24);
                    double fine = 0;

                    System.out.println(hours + " " + hoursOverdue);
                    System.out.println(difDay + " " + maxDay);
                    if (hoursOverdue > 0) {
                        System.out.println("hoursOverdue: " + hoursOverdue);
                        libraryList.get(i).setBorrowedHours(hoursOverdue);
                        System.out.println("Hours over Due: " + libraryList.get(i).getBorrowedHours() + " i is " + i);
                    if (difDay < (maxDay + 3) && difDay > 0) {
                        fine = hoursOverdue * 0.2;
                       
                    } else {
                        int fine1Hours = 24 * 3;
                        
                        fine = (fine1Hours * 0.2) + (hoursOverdue - fine1Hours) * 0.5;
                    }
                        libraryList.get(i).setCurrentFine(fine);
                        
                    }
                    //error handling 
                } catch (Exception e) {

                }
            }
        }
        Collections.sort(libraryList);
        for (int j = 0; j < libraryList.size(); j++){
            System.out.println(libraryList.get(j).toString());
        }
    }
    
    public void startGUI(ArrayList<LibraryItem> libraryList){
        
        //creates new fram from class jpanel and sets the frame
        JPanels frame = new JPanels(libraryList);
        frame.setTitle("Westminster");
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    
    public boolean runMenu(){
        
        boolean exit= false;
        
        System.out.println("Please select a menu item:");
        System.out.println("To add a new item press 1");
        System.out.println("To delete an item press 2");
        System.out.println("To print a list of all the items press 3");
        System.out.println("To borrow an item press 4");
        System.out.println("To return an item press 5");
        System.out.println("To generate a report press 6");
        System.out.println("To start the GUI press 7");
        System.out.println("To exit the programme press 8");
        
        Scanner in = new Scanner(System.in);
        int menu1 = in.nextInt();
        
        switch (menu1) {
            case 1:
                System.out.println("There is " + (maxBook-totalBook) + " empty book storage availible and " + (maxDVD-totalDVD) + " DVD empty spaces");
                System.out.println("To add a book press 1");
                System.out.println("To add a DVD press 2");
                int menu2 = in.nextInt();
                in.nextLine();
                System.out.println("Please enter the ISBN");
                int ISBN = in.nextInt();
                System.out.println("Please enter the Title");
                in.nextLine();
                String title = in.nextLine();
                System.out.println("Please enter the publication date (ddmmyyyy)");
                int pubDate = in.nextInt();
                System.out.println("Please enter the sector(genre)");
                in.nextLine();
                String sector = in.nextLine();
                
                switch (menu2) {
                    case 1:
                        System.out.println("Please enter the author name");
                        String author = in.nextLine();
                        System.out.println("Please enter the Publisher");
                        String publisher = in.nextLine();
                        System.out.println("Please enter the total number of pages");
                        int pages = in.nextInt();
                        System.out.println(ISBN + " " +title);
                        
                        Book b = new Book(title, pubDate, ISBN, sector, author, publisher, pages);
                        this.addBook(b);
                        break;
                    case 2:
                        System.out.println("Please enter the languages the DVD is availible in:");
                        String languages = in.nextLine();
                        System.out.println("Please enter the subtitle languages:");
                        String subtitles = in.nextLine();
                        System.out.println("Please enter the producer:");
                        String producer = in.nextLine();
                        System.out.println("Please enter the actors:");
                        String actors = in.nextLine();
                        DVD d = new DVD(title, pubDate, ISBN, sector, languages, subtitles, producer, actors);
                        this.addDVD(d);
                        break;
                }
                
                break;
            
            case 2:
                System.out.println("To delete an item please enter the ISBN:");
                int ISBN1 = in.nextInt();
                this.deleteItem(ISBN1);
                break;
            
            case 3:
                System.out.println("Library contents: ");
                this.printLibraryList();
                break;
                
            case 4:
                System.out.println("Please enter the items ISBN that is being borrowed:");
                int ISBN2 = in.nextInt();
                in.nextLine();
                System.out.println("Please enter the readers name:");
                String readerName= in.nextLine();
                System.out.println("Please enter the readers email:");
                String email = in.nextLine();
                System.out.println("Please enter the readers mobile number:");
                int mobileNumber = in.nextInt();
                System.out.println("Please enter the readers ID number:");
                int iDNumber = in.nextInt();
                Reader r = new Reader(iDNumber, readerName, mobileNumber, email);
                
                Calendar cal = Calendar.getInstance();
                int day = cal.get(Calendar.DATE);
                int month = cal.get(Calendar.MONTH) + 1;
                int year = cal.get(Calendar.YEAR);
                int hour = LocalDateTime.now().getHour();
                int minute = LocalDateTime.now().getMinute();
               
                
                DateTime t = new DateTime(day, month, year, hour, minute);
                this.borrowItem(ISBN2, r, t);
                //System.out.println(iDNumber + " "+ readerName + " "+ mobileNumber + " " + email);
                break;
                
            case 5:
                System.out.println("Enter the ISBN of the item to be returned:");
                int ISBN3 = in.nextInt();
                
                Calendar cal2 = Calendar.getInstance();
                int day1 = cal2.get(Calendar.DATE);
                int month1 = cal2.get(Calendar.MONTH) + 1;
                int year1 = cal2.get(Calendar.YEAR);
                int hour1 = LocalDateTime.now().getHour();
                int minute1 = LocalDateTime.now().getMinute();
                
                DateTime t1 = new DateTime(day1, month1, year1, hour1, minute1);
                this.returnItem(ISBN3, t1);
                break;
                
            case 6:
                
                Calendar cal3 = Calendar.getInstance();
                int day2 = cal3.get(Calendar.DATE);
                int month2 = cal3.get(Calendar.MONTH) + 1;
                int year2 = cal3.get(Calendar.YEAR);
                int hour2 = LocalDateTime.now().getHour();
                int minute2 = LocalDateTime.now().getMinute();
                
                DateTime t2 = new DateTime(day2, month2, year2, hour2, minute2);
                this.generateReport(t2);
                
                break;
                
            case 7:
               this.startGUI(libraryList);
               TableModel model = new DefaultTableModel();
                break;
            case 8:
                exit=true;
               break;
        }
        return exit;
    }
}
