package com.br.crawler;

import java.util.List;

import com.br.crawler.model.RedditData;

public class App {

	public static void main(String[] args) {

		String input = "askreddit;worldnews;cats";

		String[] subReddits = input.split(";");

		Crawler crawler = new Crawler();
		List<RedditData> redditDatas = crawler.getRedditData(subReddits);

		if (redditDatas.size() > 0) {
			for (RedditData redditData : redditDatas) {
				System.out.println("SubReddid: " + redditData.getSubReddit());
				System.out.println("Link: " + redditData.getLinkThread());
				System.out.println("Title: " + redditData.getTitleThread());
				System.out.println("Up votes: " + redditData.getUpVotes());
				System.out.println("\n");
			}
		} else {
			System.out.println("Nenhum resultado encontrado");
		}

	}

}
