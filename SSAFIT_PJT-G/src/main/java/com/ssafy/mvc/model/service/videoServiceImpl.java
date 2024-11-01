package com.ssafy.mvc.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.mvc.model.dao.VideoDao;
import com.ssafy.mvc.model.dto.Video;

@Service
public class videoServiceImpl implements videoService{

	private final VideoDao videoDao;
	
	public videoServiceImpl(VideoDao videoDao) {
		this.videoDao=videoDao;
	}

	@Override
	public boolean insertVideo(Video video) {
		boolean result = videoDao.addVideo(video);
		return result;
	}

	@Override
	public List<Video> readVideo() {
		return videoDao.selectAll();
	}

	@Override
	public Video readOne(int id) {
		return videoDao.selectOne(id);
	}

	@Override
	public boolean removeVideo(int id) {
		boolean result = videoDao.deleteVideo(id);
		return result;
	}

	@Override
	public List<Video> findVideo(String part) {
		return videoDao.searchVideo(part);
	}
	
	@Override
	public void upCnt(int videoId) {
		videoDao.updateCnt(videoId);
	}
		
	
	
	
}
