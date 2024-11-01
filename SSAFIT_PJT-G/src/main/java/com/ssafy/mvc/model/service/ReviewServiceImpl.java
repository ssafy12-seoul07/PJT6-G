package com.ssafy.mvc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.mvc.model.dao.ReviewDao;
import com.ssafy.mvc.model.dto.Review;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	private final ReviewDao reviewDao;
	@Autowired
	public ReviewServiceImpl(ReviewDao reviewDao) {
		this.reviewDao=reviewDao;
	}

	@Override
	public List<Review> getReviewList() {
		return reviewDao.selectAll();
	}

	@Override
	public void writeReview(Review review) {
		reviewDao.insert(review);
	}

	@Override
	public void modifyReview(Review review) {
		reviewDao.update(review);
	}

	@Override
	public boolean removeReview(int id) {
		return reviewDao.delete(id)==1;
	}
	

}
