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
public class Reader {
    private int iDNumber;
    private String readerName;
    private int mobileNumber;
    private String email;
    
    public Reader(int iDNumber, String readerName, int mobileNumber, String email){
        this.iDNumber=iDNumber;
        this.readerName=readerName;
        this.mobileNumber=mobileNumber;
        this.email=email;
    }
    
    public void setIDNumber(int iDNumber){
        this.iDNumber=iDNumber;
    }
    public void setReaderName(String readerName){
        this.readerName=readerName;
    }
    
    public void setMobileNumber(int mobileNumber){
        this.mobileNumber=mobileNumber;
    }
    
    public void setEmail(String email){
        this.email=email;
    }
    
    public int getIDNumber(){
        return iDNumber;
    }
    public String getReaderName(){
        return readerName;
    }
    
    public int getMobileNumber(){
        return mobileNumber;
    }
    public String getEmail(){
        return email;
    }
    
}
