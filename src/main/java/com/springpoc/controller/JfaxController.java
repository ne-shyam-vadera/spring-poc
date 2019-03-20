package com.springpoc.controller;

import com.springpoc.entity.JfaxDetails;
import com.springpoc.service.JfaxService;
import com.springpoc.util.JfaxUtils;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class JfaxController {

    @Autowired
    JfaxService jfaxService;

    Log log;

    @GetMapping("/jfaxes")
    public List<JfaxDetails> retrieveAllJfaxes() {
        List<JfaxDetails> jfaxDetailsList=jfaxService.jfaxDetails();

        if(jfaxDetailsList!=null ){
            return jfaxDetailsList;
        }else{
            jfaxDetailsList.add(new JfaxUtils().getErrorMessage("Something went wrong."));
            return jfaxDetailsList;
        }

    }

    @GetMapping("/jfax/{serviceKey}")
    public JfaxDetails retrieveJfax(@PathVariable Integer serviceKey) {
        Optional<JfaxDetails> jfaxDetailsOptional = jfaxService.jfaxDetailsByServiceKey(serviceKey);
        if(jfaxDetailsOptional.get()!=null){
            return jfaxService.jfaxDetailsByServiceKey(serviceKey).get();
        }else{
            return new JfaxUtils().getErrorMessage("No Jfaxes are available at that time.");
        }

    }

    @DeleteMapping("/jfax/{serviceKey}")
    public ResponseEntity<Object>deleteJfax(@PathVariable Integer serviceKey) {

        Optional<JfaxDetails> jfaxDetailsOptional = jfaxService.jfaxDetailsByServiceKey(serviceKey);

        if (!jfaxDetailsOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }else{
            jfaxService.deleteJfaxDetails(serviceKey);
            return ResponseEntity.ok().body("Record deleted of Service Key :"+serviceKey);
        }

    }

    @RequestMapping(value = "/jfax",method = RequestMethod.PUT)
    public ResponseEntity<Object> updateJfax(@RequestBody JfaxDetails jfaxDetails) {

        Optional<JfaxDetails> jfaxDetailsOptional = jfaxService.jfaxDetailsByServiceKey(jfaxDetails.getServiceKey());

        if (!jfaxDetailsOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }else{
            jfaxService.updateJfaxDetails(jfaxDetails);
            return ResponseEntity.ok().body("Record updated of Service Key :"+jfaxDetails.getServiceKey());
        }
    }
}
