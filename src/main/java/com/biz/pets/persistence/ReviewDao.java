package com.biz.pets.persistence;

import java.util.List;

import com.biz.pets.domain.PageDTO;
import com.biz.pets.domain.ReviewDTO;

public interface ReviewDao {
	
	public List<ReviewDTO> selectAll();
	
	public long proTotalCount() ;
	
	// offset부터 limit까지의 데이터만 추출
	public List<ReviewDTO> selectPagination(PageDTO pageDTO);
	
	public ReviewDTO findById(long re_seq);

	public int insert(ReviewDTO reDTO);

	public int update(ReviewDTO reDTO);

	public int delete(long re_seq);
	
}
