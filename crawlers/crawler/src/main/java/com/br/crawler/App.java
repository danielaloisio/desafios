package com.br.crawler;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.br.crawler.model.RedditData;

public class App 
{
	private static List<RedditData> redditDatas = new ArrayList<RedditData>();
	
	private static WebDriver driver = new HtmlUnitDriver();
	
	private static String linkReddit = "https://www.reddit.com/r/";

    public static void main( String[] args ) throws InterruptedException
    {
        //String input = "askreddit;worldnews;cats";
    	String input = "cats";
    	
    	String[] subReddits = input.split(";");

    	getDataReddit(subReddits);
    }
    
    
    private static void getDataReddit(String[] subReddits){
    	
          for(String subReddit : subReddits){
               
        	  driver.get(linkReddit + subReddit);
        	
          	  List<WebElement> celulas = driver.findElements(By.className("thing"));
          	  
          	for(WebElement c : celulas){
          		
          		RedditData redditData = new RedditData();
          		redditData.setSubReddit(subReddit);
          		redditData.setLinkThread(c.findElement(By.className("title may-blank")).getAttribute("href"));
          		redditData.setTitleThread(c.findElement(By.className("title may-blank")).getText());
          		redditData.setUpVotes(c.findElement(By.className("score unvoted")).getText());
          		
          		int upVotesInteger = Integer.parseInt(c.findElement(By.className("score unvoted")).getText());

          		if(upVotesInteger >= 5000){
          			
          		  redditDatas.add(redditData);
          		  
          		}
        	}
       }
          
          
          driver.quit();
          
          for(RedditData item : redditDatas){
        	  System.out.println("SubRedd: "+item.getSubReddit());
        	  System.out.println("Link: "+item.getLinkThread());
        	  System.out.println("Title: "+item.getTitleThread());
        	  System.out.println("Up votes: "+item.getUpVotes());
        	  System.out.println("\n");
          }
    	  
    }

}
