package com.springpoc.dao;

import com.springpoc.entity.JfaxDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JfaxDao extends JpaRepository<JfaxDetails,Integer> {


}

