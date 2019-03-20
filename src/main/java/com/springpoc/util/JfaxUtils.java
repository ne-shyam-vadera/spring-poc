package com.springpoc.util;

import com.springpoc.entity.JfaxDetails;

public class JfaxUtils {

    public JfaxDetails getErrorMessage(String message){
        JfaxDetails jfaxDetails=new JfaxDetails();
        jfaxDetails.setMessage(message);
        return jfaxDetails;
    }

}
