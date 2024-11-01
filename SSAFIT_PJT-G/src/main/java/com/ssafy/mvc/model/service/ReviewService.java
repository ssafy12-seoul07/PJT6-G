package com.ssafy.mvc.model.service;

import java.util.List;

import com.ssafy.mvc.model.dto.Review;

public interface ReviewService {
	// 리뷰 전체 조회
	public List<Review> getReviewList();
	// 리뷰 작성
	public void writeReview(Review review);
	// 리뷰 수정
	public void modifyReview(Review review);
	// 리뷰 삭제
	public boolean removeReview(int id);
}
