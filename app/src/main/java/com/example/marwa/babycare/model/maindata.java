package com.example.marwa.babycare.model;

public class maindata {

    private String name;
    private String url;
    private String describtion;
    private String cure;
    private String prevention;


    public maindata() {

    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescribtion() {
        return describtion;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }

    public String getCure() {
        return cure;
    }

    public void setCure(String cure) {
        this.cure = cure;
    }

    public String getPrevention() {
        return prevention;
    }

    public void setPrevention(String prevention) {
        this.prevention = prevention;
    }
}
