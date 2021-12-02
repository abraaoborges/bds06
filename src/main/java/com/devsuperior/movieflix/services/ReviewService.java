package com.devsuperior.movieflix.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.entities.Review;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.MovieRepository;
import com.devsuperior.movieflix.repositories.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository repository;
	
	@Autowired
	private AuthService authService;
	

	@Autowired
	private MovieRepository movieRepository;
	
//	@Transactional(readOnly = true)
//	public ReviewDTO findByMovise(Long movieId) {
//		List<Review> list = repository.findByMovie(movieId);
//		Review entity = obj.orElseThrow(()->new ResourceNotFoundException("Entity not found"));
//		return new MovieDetailsDTO(entity);
//	}
	
	@Transactional(readOnly = true)
	public List<ReviewDTO> findByMovie(Long movieId) {
		List<Review> list = repository.findByMovieId(movieId);		
		return list.stream().map(x -> new ReviewDTO(x)).collect(Collectors.toList());
	};	
	
	@Transactional
	public ReviewDTO insert(ReviewDTO dto) {
		
		User user = authService.authenticated();
		
		Review entity = new Review();
		entity.setMovie(movieRepository.getOne(dto.getMovieId()));
		entity.setUser(user);
		entity.setText(dto.getText());
		
		repository.save(entity);
		
		return new ReviewDTO(entity);		
	}
	
	
}
