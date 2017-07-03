package com.br.crawler.model;

public class RedditData {
	
	private String subReddit;
	
	private String titleThread;
	
	private String upVotes;
	
	private String linkThread;
	
	public RedditData(){
		
	}

	public RedditData(String subReddit, String titleThread, String upVotes, String linkThread) {
		this.subReddit = subReddit;
		this.titleThread = titleThread;
		this.upVotes = upVotes;
		this.linkThread = linkThread;
	}

	public String getSubReddit() {
		return subReddit;
	}

	public void setSubReddit(String subReddit) {
		this.subReddit = subReddit;
	}

	public String getTitleThread() {
		return titleThread;
	}

	public void setTitleThread(String titleThread) {
		this.titleThread = titleThread;
	}

	public String getUpVotes() {
		return upVotes;
	}

	public void setUpVotes(String upVotes) {
		this.upVotes = upVotes;
	}

	public String getLinkThread() {
		return linkThread;
	}

	public void setLinkThread(String linkThread) {
		this.linkThread = linkThread;
	}
	
}
