package com.biz.pets.persistence;

import java.util.List;

import com.biz.pets.domain.ReviewDTO;

public interface ReviewDao {
	
	public List<ReviewDTO> selectAll();
	
	public ReviewDTO findById(long re_seq);

	public int insert(ReviewDTO reDTO);

	public int update(ReviewDTO reDTO);

	public int delete(long re_seq);
	
}
