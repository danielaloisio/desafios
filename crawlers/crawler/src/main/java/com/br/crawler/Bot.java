package com.br.crawler;

import java.util.List;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.br.crawler.constants.CrawlerConst;
import com.br.crawler.model.RedditData;

public class Bot extends TelegramLongPollingBot {

	private static List<RedditData> redditDatas;

	@Override
	public String getBotToken() {
		return CrawlerConst.BOT_TOKEN;
	}

	public String getBotUsername() {
		return CrawlerConst.BOT_USERNAME;
	}

	public void onUpdateReceived(Update update) {
		if (update.hasMessage() && update.getMessage().hasText()) {

			String[] messageSplit = update.getMessage().getText().split(" ");

			String messageList = "";

			if (messageSplit[0].equals("/NadaPraFazer")) {

				if (messageSplit.length > 1) {

					String input = messageSplit[1];

					String[] subReddits = input.split(";");

					Crawler crawler = new Crawler();
					redditDatas = crawler.getRedditData(subReddits);

					if (redditDatas.size() > 0) {

						for (RedditData redditData : redditDatas) {

							messageList += "SubReddit: " + redditData.getSubReddit() + "\n" + "Link: "
									+ redditData.getLinkThread() + "\n" + "Title: " + redditData.getTitleThread() + "\n"
									+ "Up Votes: " + redditData.getUpVotes() + "\n\n";
						}
					} else {

						messageList = "Nenhum resultado encontrado";
					}
				} else {

					messageList = "Comando errado, digite por exemplo: /NadaPraFazer askreddit;worldnews;cats";
				}

			} else {
				messageList = "Comando errado, digite por exemplo: /NadaPraFazer askreddit;worldnews;cats";
			}

			SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId()).setText(messageList);
			try {
				sendMessage(message);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {

		ApiContextInitializer.init();

		TelegramBotsApi botsApi = new TelegramBotsApi();

		try {
			botsApi.registerBot(new Bot());
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}
}
