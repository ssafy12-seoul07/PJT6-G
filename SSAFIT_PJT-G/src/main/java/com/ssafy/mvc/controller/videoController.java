package com.ssafy.mvc.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.mvc.model.dto.Review;
import com.ssafy.mvc.model.dto.Video;
import com.ssafy.mvc.model.service.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class videoController {

	private final videoService videoService;
	private final ReviewService reviewService;
	
	@Autowired
	public videoController(videoService videoService, ReviewService reviewService) {
//	public videoController(videoService videoService) {
		this.videoService=videoService;
		this.reviewService=reviewService;
	}
	
	// insert video
	@PostMapping("/video")
	public ResponseEntity<String> write(@ModelAttribute Video video){
		boolean result = videoService.insertVideo(video);
		if(result) {
			return new ResponseEntity<String>("영상이 성공적으로 추가되었습니다", HttpStatus.CREATED);	
		}
		return new ResponseEntity<String>("영상이 추가되지 않았습니다", HttpStatus.NOT_IMPLEMENTED);	
	}
	
	//readall
	@GetMapping("/video")
	public ResponseEntity <List<Video>> list(){
		List<Video> list =videoService.readVideo();
		return new ResponseEntity<>(list, HttpStatus.OK);
		}
	
	//readone
	@GetMapping("/video/{videoId}")
	public ResponseEntity<?> detail(@PathVariable("videoId")int videoId){
		System.out.println(videoId);
		Video detail = videoService.readOne(videoId);
		videoService.upCnt(videoId);
		List<Review> reviewList = reviewService.getReviewList();
		System.out.println(detail.toString());
		HashMap<Video, List<Review>> map= new HashMap();
		map.put(detail, reviewList);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
//	//readone
//	@GetMapping("/video/{videoId}")
//	public ResponseEntity<Video> detail(@PathVariable("videoId")int videoId){
//		Video detail = videoService.readOne(videoId);
//		videoService.upCnt(videoId);
//		return new ResponseEntity<Video>(detail,HttpStatus.OK);
//	}
	//delete
	@DeleteMapping("/video/{videoId}")
	public ResponseEntity<String> remove(@PathVariable ("videoId") int id){
		boolean result = videoService.removeVideo(id);
		if(result) {
			return new ResponseEntity<String>("영상 삭제가 완료되었습니다", HttpStatus.OK);			
		}
		{return new ResponseEntity<String>("영상이 삭제되지 않었습니다", HttpStatus.NOT_IMPLEMENTED);			
	}
	}	
//	//search
	@GetMapping("/video/part/{part}")
	public ResponseEntity<List<Video>> search(@PathVariable("part") String part){
		List<Video> detailList =videoService.findVideo(part);
		return new ResponseEntity<>(detailList, HttpStatus.OK);
		}
		
		
}

