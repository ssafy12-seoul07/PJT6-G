package com.ssafy.mvc.model.dto;

import java.sql.Timestamp;

public class Review {
	private int reviewId;
	private String userId;
	private int videoId;
	private String content;
	private Timestamp regDate;
	
	public Review() {}
	public Review(String userId, int videoId, String content) {
		this.userId=userId;
		this.videoId=videoId;
		this.content=content;
	}
	
	public int getReviewId() {
		return reviewId;
	}
	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getVideoId() {
		return videoId;
	}
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

}
