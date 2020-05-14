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
public class DVD extends LibraryItem{
    
    private String languages;
    private String subtitles;
    private String producer;
    private String actors;
    
    public DVD(String title, int publicationDate, int ISBN, String sector, String languages, String subtitles, String producer, String actors ){
    super(title, publicationDate, ISBN, sector);
    this.languages=languages;
    this.subtitles=subtitles;
    this.producer=producer;
    this.actors=actors;
    }
    
    public void setLanguage(String languages){
        this.languages=languages;
    }
    
    public void setSubtitles(String subtitles){
        this.subtitles=subtitles;
    }
    
    public void setProducer(String producer){
        this.producer=producer;
    }
    
    public void setActors(String actors){
        this.actors=actors;
    }
    
    public String getLanguage(){
        return languages;
    }
    public String getSubtitles(){
        return subtitles;
    }
    public String getProducer(){
        return producer;
    }
    public String getActors(){
        return actors;
    }
    
    public String getItemType(){
        return "DVD";
    }
    
    public int getMaxBorrow(){
        return 3;
    }
}
