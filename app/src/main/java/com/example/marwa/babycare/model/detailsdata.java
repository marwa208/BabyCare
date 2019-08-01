package com.example.marwa.babycare.model;

public class detailsdata {
    private String name;
    private String url;
    private String describtion;
    private String cure;
    private String prevention;

    public detailsdata(String name, String url, String describtion, String cure, String prevention) {
        this.name = name;
        this.url = url;
        this.describtion = describtion;
        this.cure = cure;
        this.prevention = prevention;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
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
