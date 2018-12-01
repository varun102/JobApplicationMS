package com.ntl.topjobs.jobapplication.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ntl.topjobs.jobapplication.bean.ShortlistApplicants;

public interface ShortlistApplicantsDao extends JpaRepository<ShortlistApplicants, String> {

}
