package com.biz.pets.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.pets.domain.PageDTO;
import com.biz.pets.domain.ReviewDTO;
import com.biz.pets.persistence.ReviewDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ReviewService {

	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	PageService pService;
		
	ReviewDao rDao;

	@Autowired
	public void getMapper() {
		rDao = sqlSession.getMapper(ReviewDao.class);
	}
	
	public long totalCount() {
		return rDao.proTotalCount();
	}
	
	public List<ReviewDTO> selectPagination(PageDTO pageDTO) {
		List<ReviewDTO> reList = rDao.selectPagination(pageDTO);
		return reList;
	}
	

	public List<ReviewDTO> selectAll() {
		List<ReviewDTO> reList = rDao.selectAll();
		
		return rDao.selectAll();
	}

	public int insert(ReviewDTO reDTO) {
		return rDao.insert(reDTO);
	}

	public ReviewDTO getReview(long re_seq) {
		ReviewDTO reDTO = rDao.findById(re_seq);
		return reDTO;
	}

	public int update(ReviewDTO reDTO) {
		return rDao.update(reDTO);
	}

	public int delete(long re_seq) {
		return rDao.delete(re_seq);
	}
	
}
