package com.ntl.topjobs.jobapplication.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//import com.ntl.topjobs.jobseekermicroservice.model.Resume;

@FeignClient("zuul-app")
public interface ServiceProxy {

	@GetMapping("/seeker-service/resumes/getforjob/{list}")
	public List getResumes(@PathVariable("list") String arr);

}
