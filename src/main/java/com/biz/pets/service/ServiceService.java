package com.biz.pets.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biz.pets.domain.ReviewDTO;
import com.biz.pets.domain.ServiceDTO;
import com.biz.pets.persistence.ServiceDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ServiceService {

	@Autowired
	SqlSession sqlSession;

	ServiceDao sDao;

	@Autowired
	public void getMapper() {
		sDao = sqlSession.getMapper(ServiceDao.class);
	}

	public List<ServiceDTO> getAllList() {
		List<ServiceDTO> reList = sDao.selectAll();
		
		return sDao.selectAll();
	}

	public int insert(ServiceDTO seDTO) {
		return sDao.insert(seDTO);
	}

	public ServiceDTO getService(long se_seq) {
		ServiceDTO seDTO = sDao.findById(se_seq);
		return seDTO;
	}

	public int update(ServiceDTO seDTO) {
		return sDao.update(seDTO);
	}

	public int delete(long se_seq) {
		return sDao.delete(se_seq);
	}
	
	
	
	
	
	/*
	 * 	
	long maxListSize = 0;
	
	@Autowired
	PageService pService;
	
	 * 
	 * 	public List<ReviewDTO> getAllList() {
		List<ReviewDTO> reList = rDao.selectAll();
		// maxListSize = reList.size();
		
		return rDao.selectAll();
	}
	
	
	
	public PageDTO getPage(long currentPageNo) {
		

		long maxSize = maxListSize;
		if(maxSize > maxListSize) maxSize = maxListSize;
		PageDTO pageDTO = pService.makePagination(maxSize, currentPageNo);
		
		
		return pageDTO;
	}
	
	
	
	

	
	public ReviewDTO getReview(long re_seq) {

		
	
	}

	public int update(ReviewDTO reviewDTO) {
		// TODO Auto-generated method stub
		return rDao.update(reviewDTO);
	}

	public int delete(long re_seq) {
		// TODO Auto-generated method stub
		
	}
*/
}
