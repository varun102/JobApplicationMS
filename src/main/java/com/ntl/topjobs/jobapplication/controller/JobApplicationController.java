/**
 * 
 */
package com.ntl.topjobs.jobapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ntl.topjobs.jobapplication.bean.JobApplicationBean;
import com.ntl.topjobs.jobapplication.bean.ShortlistApplicants;
import com.ntl.topjobs.jobapplication.service.ServiceForJobApplication;
import com.ntl.topjobs.jobapplication.service.ServiceProxy;

/**
 * @author Training
 *
 */
@CrossOrigin(origins="http://localhost:4200",maxAge=3600)
@RestController
public class JobApplicationController {

	@Autowired
	ServiceForJobApplication serviceForJobApplication;
	@Autowired
	ServiceProxy proxy;
	
	@PostMapping("/employer/postjobs/job")
	public JobApplicationBean postJobs(@RequestBody JobApplicationBean jobApplicationBean)	{
		return (serviceForJobApplication.addJob(jobApplicationBean));
	}
	
	@GetMapping("/employer/seejobs/{id}")
	public List seeJobs(@PathVariable("id") String id)	{
		return serviceForJobApplication.viewJobs(id);
	}
	
	@GetMapping("/employer/seejobs/getresume/{jobId}")
	public List getResumeList(@PathVariable("jobId") String jobId) {
		String list= serviceForJobApplication.getResumeList(jobId);
		System.out.println(list);
		return proxy.getResumes(list);
	}
	
	@GetMapping("/employer/addShortlist/{resumeId}/{jobId}/{empId}")
	public ShortlistApplicants addShortlist(@PathVariable("seekerId") String seekId,@PathVariable("jobId") String jobId,@PathVariable("empId") String empId) {
		return serviceForJobApplication.addApplicants(seekId,jobId,empId);
	}
	
	@GetMapping("/employer/getShortlistApplicants")
	public List<ShortlistApplicants> getApplicants(){
		return serviceForJobApplication.getApplicants();
	}
	@DeleteMapping("/employer/deleteShortlistApplicants/{resumeId}")
	public boolean deleteShortlistedApplicants(@PathVariable("resumeId") String resumeId) {
		return serviceForJobApplication.deleteApplicants(resumeId);
	}
	@DeleteMapping("/employer/deleteResumeFromJobApplication/{jobId}/{resumeId}")
	public boolean deleteResumeFromJob(@PathVariable("jobId") String jobId,@PathVariable("resumeId") String resumeId) {
		return serviceForJobApplication.deleteResumeFromJob(jobId,resumeId);
	}
	
	@DeleteMapping("/employer/deleteJobApplication/{jobId}")
	public boolean deleteJobApplication(@PathVariable("jobId")String jobId) {
		return serviceForJobApplication.deleteJobApplication(jobId);
	}
	
	@GetMapping("/getAllJobs")
	public List<JobApplicationBean> getAllJobs(){
		return serviceForJobApplication.getAllJobs();
	}
	
	@PutMapping("/applyForJob/{resumeId}/{jobId}")
	public boolean addResumeToJobApplication(@PathVariable("resumeId") String resumeId,@PathVariable("jobId")String jobId) {
		return serviceForJobApplication.applyJob(resumeId,jobId);
	}
	
}
