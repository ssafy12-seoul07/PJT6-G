package com.ssafy.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.mvc.model.dto.Review;
import com.ssafy.mvc.model.service.ReviewService;

@RestController
@RequestMapping("/api")
public class reviewController {
	//서비스 의존성 주입
	private final ReviewService reviewService;
	
	@Autowired
	public reviewController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	
	@PostMapping("/review")
	public ResponseEntity<Review> write(@ModelAttribute Review review){
		reviewService.writeReview(review);
		return new ResponseEntity<Review>(review, HttpStatus.CREATED);
	}
	@DeleteMapping("/review/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") int id){
		if(reviewService.removeReview(id)) {
			return ResponseEntity.status(HttpStatus.OK).body("댓글이 삭제되었습니다.");
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("댓글을 삭제하지 못했습니다.");
	}
//	@PutMapping("/review/{id}")
//	public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody Review review){
//		
//	}
	@PutMapping("/review")
	public ResponseEntity<String> update(@ModelAttribute Review review){
		reviewService.modifyReview(review);
		return ResponseEntity.status(HttpStatus.OK).body("댓글이 수정되었습니다.");
	}
	

}
