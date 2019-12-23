package com.biz.pets.persistence;

import java.util.List;

import com.biz.pets.domain.ReviewDTO;
import com.biz.pets.domain.ServiceDTO;

public interface ServiceDao {
	
	public List<ServiceDTO> selectAll();
	
	public ServiceDTO findById(long se_seq);

	public int insert(ServiceDTO seDTO);

	public int update(ServiceDTO seDTO);

	public int delete(long se_seq);
	
}
