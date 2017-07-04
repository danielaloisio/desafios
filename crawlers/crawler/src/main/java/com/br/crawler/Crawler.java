package com.br.crawler;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.br.crawler.constants.CrawlerConst;
import com.br.crawler.model.RedditData;

public class Crawler {

	public List<RedditData> getRedditData(String[] subReddits) {

		List<RedditData> redditDatas = new ArrayList<RedditData>();

		if (subReddits.length > 0) {

			WebDriver driver = new HtmlUnitDriver();

			for (String subReddit : subReddits) {

				driver.get(CrawlerConst.LINK_REDDIT + subReddit);

				List<WebElement> celulas = driver.findElements(By.className("thing"));

				for (WebElement c : celulas) {

					try {
						int upVotesInteger = Integer.parseInt(c.findElement(By.className("score unvoted")).getText());

						if (upVotesInteger >= 5000) {
							RedditData redditData = new RedditData();
							redditData.setSubReddit(subReddit);
							redditData
									.setLinkThread(c.findElement(By.className("title may-blank")).getAttribute("href"));
							redditData.setTitleThread(c.findElement(By.className("title may-blank")).getText());
							redditData.setUpVotes(c.findElement(By.className("score unvoted")).getText());
							redditDatas.add(redditData);
						}

					} catch (Exception e) {
						// TODO: handle exception
					}

				}
			}

			driver.quit();
		}

		return redditDatas;

	}

}
