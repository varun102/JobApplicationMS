/**
 * 
 */
package com.ntl.topjobs.jobapplication.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntl.topjobs.jobapplication.JobApplication;
import com.ntl.topjobs.jobapplication.bean.JobApplicationBean;
import com.ntl.topjobs.jobapplication.bean.ShortlistApplicants;
import com.ntl.topjobs.jobapplication.dao.JobApplicationDao;
import com.ntl.topjobs.jobapplication.dao.ShortlistApplicantsDao;

/**
 * @author Training
 *
 */
@Service
public class ServiceForJobApplication {

	@Autowired
	JobApplicationDao jobApplicationDao;
	@Autowired 
	ShortlistApplicantsDao shortlistDao;

	public JobApplicationBean addJob(JobApplicationBean jobApplicationBean) {
		jobApplicationBean.setJobId();
		return (jobApplicationDao.save(jobApplicationBean));
	}

	public List<JobApplicationBean> viewJobs(String empid) {
		return jobApplicationDao.findByEmpId(empid);

	}
	
	public String getResumeList( String jobId) {
		return jobApplicationDao.findById(jobId).get().getApplicants();
		
	}
	
	public ShortlistApplicants addApplicants(String resumeId, String jobId,String empId) {
		
/*		JobApplicationBean job=jobApplicationDao.findBy(seekId).get();
		try {
		String applicants=job.getApplicants();
		applicants+=","+seekId;
		job.setApplicants(applicants);
		}catch(Exception err) {
			job.setApplicants(seekId);
		}
		return jobApplicationDao.saveAndFlush(job);*/
		ShortlistApplicants app=new ShortlistApplicants(resumeId,jobId,empId);
		return shortlistDao.save(app);
	}
	public List<ShortlistApplicants> getApplicants(){
		return shortlistDao.findAll();
	}
	
	public boolean deleteApplicants(String resume) {
		shortlistDao.deleteById(resume);
		if(!shortlistDao.existsById(resume))
			return true;
		return false;
	}
	
	public boolean deleteJobApplication(String jobId) {
		jobApplicationDao.deleteById(jobId);
		return true;
	}
	
	public boolean deleteResumeFromJob(String jobId,String resumeId) {
		JobApplicationBean job = jobApplicationDao.findById(jobId).get();
		List<String> applicants=new ArrayList<String>(Arrays.asList(job.getApplicants().split(",")));
		applicants.remove(resumeId);
		String result="";//applicants.get(0);
		for(String a:applicants) {
			result+=","+a;
		}
		job.setApplicants(result);
		return true;
	}
	
	public List<JobApplicationBean> getAllJobs(){
		return jobApplicationDao.findAll();
	}
	public boolean applyJob(String resumeId,String jobId) {
		JobApplicationBean job=jobApplicationDao.findById(jobId).get();
		String result=""+job.getApplicants()+","+resumeId;
		job.setApplicants(result);
		if(job.getApplicants()!=null) {
			return true;
			
		}
		return false;
		
	}
	public String generateJobId() {
		int x = (int) (Math.random() * ((9999 - 1000) + 1)) + 1000;
		String str = Integer.toString(x);
		char a[] = { str.charAt(0), str.charAt(1), str.charAt(2), str.charAt(3) };
		return (new String(a));
	}

}
