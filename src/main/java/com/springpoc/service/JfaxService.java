package com.springpoc.service;

import com.springpoc.dao.JfaxDao;
import com.springpoc.entity.JfaxDetails;
import com.springpoc.util.JfaxUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JfaxService {

    @Autowired
    JfaxDao jfaxDao;

    public List<JfaxDetails> jfaxDetails(){
      return this.jfaxDao.findAll();
    }

    public Optional<JfaxDetails> jfaxDetailsByServiceKey(Integer serviceKey){
        if(this.jfaxDao.existsById(serviceKey)){
            return this.jfaxDao.findById(serviceKey) ;
        }else{
            return Optional.of(new JfaxUtils().getErrorMessage("No Jfaxes are available at that time."));
        }
    }

    public void deleteJfaxDetails(Integer serviceKey){
        this.jfaxDao.deleteById(serviceKey);
    }

    public JfaxDetails updateJfaxDetails(JfaxDetails jfaxDetails){
        return this.jfaxDao.save(jfaxDetails);
    }

}
