package com.ntl.topjobs.jobapplication.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ShortlistApplicants {

	@GeneratedValue(strategy=GenerationType.AUTO)
	private long serialno;
	private String jobId;
	@Id
	private String resumeId;
	private String empId;
	public ShortlistApplicants() {
		// TODO Auto-generated constructor stub
	}
	public ShortlistApplicants(String resume,String job,String empId) {
		// TODO Auto-generated constructor stub
		this.jobId=job;
		this.resumeId=resume;
		this.empId=empId;
	}
	public long getSerialno() {
		return serialno;
	}
	public void setSerialno(long serialno) {
		this.serialno = serialno;
	}
	public String getJobId() {
		return jobId;
	}
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}
	public String getResumeId() {
		return resumeId;
	}
	public void setResumeId(String resumeId) {
		this.resumeId = resumeId;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}

}
