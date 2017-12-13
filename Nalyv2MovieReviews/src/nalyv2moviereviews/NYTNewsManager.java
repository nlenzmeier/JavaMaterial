/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nalyv2moviereviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import org.json.simple.*;


/**
 *
 * @author Nicolle
 */
public class NYTNewsManager {
    private String urlString = "";
    
    // sample url:
    //private String urlString = "http://api.nytimes.com/svc/search/v2/articlesearch.json?q=Microsoft&api-key=2bf424fd20964fc0bfad8011786cdcad";
   
    // NOTE!!  The api key below is Dale Musser's api key.  If you build an app that uses the New York Times API
    // get your own api key!!!!!  Get it from: http://developer.nytimes.com
    // I also cannot guarantee that the api key provided will be valid in the future.
    private final String baseUrlString = "http://api.nytimes.com/svc/movies/v2/reviews/search.json";
    private final String apiKey = "fc91981f5ae84db8a68896a15a240ed2";
    private String searchString = "";
    
    private URL url;
    private ArrayList<NYTNewsStory> newsStories;
    
    
    public NYTNewsManager() {
        newsStories = new ArrayList<>();
    }
    
    public void load(String searchString) throws Exception {
        if (searchString == null || searchString.equals("")) {
            throw new Exception("The search string was empty.");
        }
        
        this.searchString = searchString;
        
        // create the urlString
        String encodedSearchString;
        try {
            // searchString must be URL encoded to put in URL
            encodedSearchString = URLEncoder.encode(searchString, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            throw ex;
        }
        
        //urlString = baseUrlString + "?q=" + encodedSearchString + "&api-key=" + apiKey;
        urlString = baseUrlString + "?query=" + encodedSearchString + "&api-key=" + apiKey;
        System.out.println(urlString);
        
        try {
            url = new URL(urlString);
        } catch(MalformedURLException muex) {
           throw muex;
        }
        System.out.println(url);
        
        String jsonString = "";
        //System.out.println(jsonString);
        try {
            BufferedReader in = new BufferedReader(
            new InputStreamReader(url.openStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null)
                jsonString += inputLine;
            in.close();
        } catch (IOException ioex) {
            throw ioex;
        }
        
        System.out.println(jsonString);
        
        try {
            parseJsonNewsFeed(jsonString);
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    private void parseJsonNewsFeed(String jsonString) throws Exception {
        
        // start with clean list
        newsStories.clear();
        
        if (jsonString == null || jsonString.equals("")) return;
        
        JSONObject jsonObj;
        try {
            jsonObj = (JSONObject)JSONValue.parse(jsonString);
        } catch (Exception ex) {
            throw ex;
        }
        
        if (jsonObj == null) return;
        
        String status = "";
        try {
            status = (String)jsonObj.get("status");
        } catch (Exception ex) {
            throw ex;
        }
        
        if (status == null || !status.equals("OK")) {
            throw new Exception("Status returned from API was not OK.");
        }
        
        JSONArray result;
        try {
            //System.out.println("Hey there!");
            result = (JSONArray)jsonObj.get("results");
        } catch (Exception ex) {
            throw ex;
        }
        //prints here
        //System.out.println("Hi there!!!");
        
        for (Object doc : result) {
            try {
                JSONObject movie = (JSONObject)doc;
                String displayTitle = (String)movie.getOrDefault("display_title", "");
                String mpaa = (String)movie.getOrDefault("mpaa_rating", "");
                String byline = (String)movie.getOrDefault("byline", "");
                String headline = (String)movie.getOrDefault("headline", "");
                String summaryShort = (String)movie.getOrDefault("summary_short", "");
                String openingDate = (String)movie.getOrDefault("opening_date", "");
                JSONObject linkObj = (JSONObject)movie.getOrDefault("link", "");
                String type = "";
                String webUrl = "";
                String suggestedLinkText ="";

                
                if (linkObj != null) {
                    type = (String)linkObj.getOrDefault("type", "");
                    webUrl = (String)linkObj.getOrDefault("url", "");
                    suggestedLinkText = (String)linkObj.getOrDefault("suggested_link_text", "");
                }
                
                JSONObject mediaObj = (JSONObject)movie.getOrDefault("multimedia", "");
                String src = "";
                if (mediaObj != null) {
                    src = (String)mediaObj.getOrDefault("src", "");                   
                }
                
                if(src.length() == 0){
                        src = "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ac/No_image_available.svg/2000px-No_image_available.svg.png";
                    }
                
                System.out.println("Title: " + displayTitle + "\n");
                System.out.println("MPAA: " + mpaa + "\n");
                System.out.println("Byline: " + byline + "\n");
                System.out.println("Headline: " + headline + "\n");
                System.out.println("Summary Short: " + summaryShort + "\n");
                System.out.println("Url: " + webUrl + "\n");
                System.out.println("Source: " + src + "\n");
                System.out.println("------------------------------------------------------\n");
                
                NYTNewsStory newsStory = new NYTNewsStory(displayTitle, mpaa, byline, headline, summaryShort, openingDate, src);
                newsStories.add(newsStory);
                
            } catch (Exception ex) {
                throw ex;
            }
            
        }
        
    }
    
    public ArrayList<NYTNewsStory> getNewsStories() {
        return newsStories;
    }
    
    public int getNumNewsStories() {        
        return newsStories.size();
    }
    
}
