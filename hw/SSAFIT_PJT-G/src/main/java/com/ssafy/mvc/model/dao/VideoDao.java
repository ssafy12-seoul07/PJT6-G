package com.ssafy.mvc.model.dao;

import java.util.List;

import com.ssafy.mvc.model.dto.Video;

public interface VideoDao {
	
	// create
	public boolean addVideo(Video video);
	// read all
	public List<Video> selectAll();
	//read one
	public Video selectOne(int videoId);
	// delete
	public boolean deleteVideo(int videoId);
	//search
	public List<Video> searchVideo(String part);
	//viewcnt
	public void updateCnt(int videoId);
	
}
