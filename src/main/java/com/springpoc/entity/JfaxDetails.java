package com.springpoc.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "jfax_details")
public class JfaxDetails {

    @Id
    @Column(name = "SERVICEKEY")
    @JsonProperty(value="service_key")
    private Integer serviceKey;

    @Column(name = "CUSTOMERKEY")
    @JsonProperty(value="customer_key")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private  Integer customerKey;

    @Column(name = "PHONENUMBER")
    @JsonProperty(value="phone_number")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private  String phoneNumber;

    @Column(name = "SERVER_ID")
    @JsonProperty(value="server_id")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String serverId;

    @Column(name = "SERVER_IP")
    @JsonProperty(value="server_ip")
    @Pattern(regexp = "^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$",message = "enter propper server ip")
    private String serverIP;

    @Column(name = "SERVER_CHANNEL")
    @JsonIgnore
    private int serverChannel;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty(value="error_message")
    private String message;


    @Column(name = "OFFER_CODE")
    @JsonProperty(value="offer_code")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String offerCode;


    @Column(name = "AMOUNT")
    @JsonIgnore
    private double amount;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public Integer getServiceKey() {
        return serviceKey;
    }

    public void setServiceKey(Integer serviceKey) {
        this.serviceKey = serviceKey;
    }

    public Integer getCustomerKey() {
        return customerKey;
    }

    public void setCustomerKey(Integer customerKey) {
        this.customerKey = customerKey;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public String getServerIP() {
        return serverIP;
    }

    public void setServerIP(String serverIP) {
        this.serverIP = serverIP;
    }

    public int getServerChannel() {
        return serverChannel;
    }

    public void setServerChannel(int serverChannel) {
        this.serverChannel = serverChannel;
    }

    public String getOfferCode() {
        return offerCode;
    }

    public void setOfferCode(String offerCode) {
        this.offerCode = offerCode;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "JfaxDetails{" +
                "serviceKey=" + serviceKey +
                ", customerKey=" + customerKey +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", serverId='" + serverId + '\'' +
                ", serverIP='" + serverIP + '\'' +
                ", serverChannel=" + serverChannel +
                ", offerCode='" + offerCode + '\'' +
                ", amount=" + amount +
                '}';
    }
}
