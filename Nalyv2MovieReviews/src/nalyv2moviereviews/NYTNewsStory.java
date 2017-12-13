/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nalyv2moviereviews;

/**
 *
 * @author Nicolle
 */
public class NYTNewsStory {
    public String displayTitle;
    public String mpaa;
    public String byline;
    public String headline;
    public String summaryShort;
    //public String webUrl;
    public String src;
    public String openingDate;

    
    
    public NYTNewsStory(String displayTitle, String mpaa, String byline, String headline, String summaryShort, String openingDate, String src) {
        this.displayTitle = displayTitle;
        this.mpaa = mpaa;
        this.byline = byline;
        this.headline = headline;
        this.summaryShort = summaryShort;
        this.openingDate = openingDate;
        //this.webUrl = webUrl;
        this.src = src;
    }
    
    
}
