/**
 * 
 */
package com.ntl.topjobs.jobapplication.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ntl.topjobs.jobapplication.bean.JobApplicationBean;

/**
 * @author Training
 *
 */
@Repository
public interface JobApplicationDao extends JpaRepository<JobApplicationBean, String> {
	
	public List<JobApplicationBean> findByEmpId(String empid);

	
}
