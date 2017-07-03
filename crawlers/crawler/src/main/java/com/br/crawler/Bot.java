package com.br.crawler;

import java.util.List;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.br.crawler.constants.CrawlerConst;

public class Bot extends TelegramLongPollingBot {
	
	
	 @Override
	    public String getBotToken() {
	        return CrawlerConst.BOT_TOKEN;
	    }
	 
	    public String getBotUsername() {
	        return CrawlerConst.BOT_USERNAME;
	    }
	 
	    public void onUpdateReceived(Update update) {
	        if (update.hasMessage() && update.getMessage().hasText()) {
	        	
	        	String messageList = "";
	        	if(update.getMessage().getText().equals("/NadaPraFazer_askreddit;worldnews;cats")){
	        		
	        		messageList = "Comando certo";

	        	}else{
	        		messageList = "Comando errado, digite /NadaPraFazer_askreddit;worldnews;cats";
	        	}
	           
	            SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId())
	                    .setText(messageList);
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
