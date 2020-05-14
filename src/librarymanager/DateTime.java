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
public class DateTime {
    protected int year;
    protected int month;
    protected int day;
    protected int hour;
    protected int minute;
    
    public DateTime(int day, int month, int year, int hour, int minute){
        
        if((year > 2017) && (year<2020) && (month>00) && (month <13) && (day>00) && (day<32) && (hour>00) && (hour <25) && (minute>=00) && (minute <61)){
            this.day=day;
            this.month=month;
            this.year=year;
            this.hour=hour;
            this.minute=minute;
        } else {
            System.out.println("Date has been entered incorrectly");
        }
    }
    
    public DateTime(int day, int month, int year){
        
        if((year > 2017) && (year<2020) && (month>00) && (month <13) && (day>00) && (day<32)){
            this.day=day;
            this.month=month;
            this.year=year;
        } else {
            System.out.println("Date has been entered incorrectly");
        }
    }
    
    public void setDay(int day){
        if((day>0) && (day<32)){
            this.day=day;
        }else{
            System.out.println("Incorrect day entered");
        }
    }
    
    public void setMonth(int month){
        if((month>0) && (month<13)){
            this.month=month;
        }else{
            System.out.println("Incorrect month entered");
        }
    }
    
    public void setYear(int year){
        if((year>2017) && (year<2020)){
            this.year=year;
        }else{
            System.out.println("Incorrect year entered");
        }
    }
    
    public void setHour(int hour){
        if((hour>0) && (hour<25)){
            this.hour=hour;
        }else{
            System.out.println("Incorrect hour entered");
        }
    }
    
    public void setMinute(int minute){
        if((minute>=0) && (minute<61)){
            this.minute=minute;
        }else{
            System.out.println("Incorrect minutes entered");
        }
    }
    
    public int getDay(){
        return day;
    }
    
    public int getMonth(){
        return month;
    }
    
    public int getYear(){
        return year;
    }
    
    public int getHour(){
        return hour;
    }
    
    public int getMinute(){
        return minute;
    }
    
    public int getDate(){
        return day + month + year + hour + minute;
    }
    
    public String toString(){
        return day + "/" + month + "/" + year + " " + hour + ":" + minute;
    }

    
}
