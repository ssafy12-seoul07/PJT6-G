package com.ssafy.mvc.model.dto;

public class Video {

	private String title;
	private String part;
	private String channelName;
	private int viewCnt;
	private int videoId;
	
	public Video() {}
	
	public Video(String title, String part, String channelName, int viewCnt, int videoId) {
		this.title = title;
		this.part = part;
		this.channelName = channelName;
		this.viewCnt = viewCnt;
		this.videoId=videoId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	
	

	public int getVideoId() {
		return videoId;
	}

	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}

	@Override
	public String toString() {
		return "Video [title=" + title + ", part=" + part + ", channelName=" + channelName + ", viewCnt=" + viewCnt
				+ ", videoId=" + videoId + "]";
	}


	

	
	


}
