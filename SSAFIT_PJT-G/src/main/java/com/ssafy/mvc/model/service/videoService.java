package com.ssafy.mvc.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.ssafy.mvc.model.dao.*;
import com.ssafy.mvc.model.dto.Video;


public interface videoService {
	
	//create
	public boolean insertVideo(Video video);
	
	//read all
	public List<Video> readVideo();
	
	//read one
	public Video readOne(int id);
	
	//delete
	public boolean removeVideo(int id);
	
	//search
	public List<Video> findVideo(String part);
	
	//updateViewCnt
	public void upCnt(int videoId);
	

}
