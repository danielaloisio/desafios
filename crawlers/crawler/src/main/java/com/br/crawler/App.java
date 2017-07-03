package com.br.crawler;

import java.util.List;
import com.br.crawler.model.RedditData;

public class App {
	
	public static void main(String[] args) throws InterruptedException {
		String input = "askreddit;worldnews;cats";

		String[] subReddits = input.split(";");

		Crawler crawler = new Crawler();
		List<RedditData>redditDatas = crawler.getRedditData(subReddits);
		
		for (RedditData item : redditDatas) {
			System.out.println("SubReddid: " + item.getSubReddit());
			System.out.println("Link: " + item.getLinkThread());
			System.out.println("Title: " + item.getTitleThread());
			System.out.println("Up votes: " + item.getUpVotes());
			System.out.println("\n");
		}
		
	}

}
