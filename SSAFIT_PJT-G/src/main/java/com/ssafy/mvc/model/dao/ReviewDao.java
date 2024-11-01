package com.ssafy.mvc.model.dao;

import java.util.List;

import com.ssafy.mvc.model.dto.Review;

public interface ReviewDao {
	// 리뷰 전체 조회
	public List<Review> selectAll();
	// 리뷰 등록
	public int insert(Review review);
	// 리뷰 삭제
	public int delete(int id);
	// 리뷰 수정
	public void update(Review review);
}
