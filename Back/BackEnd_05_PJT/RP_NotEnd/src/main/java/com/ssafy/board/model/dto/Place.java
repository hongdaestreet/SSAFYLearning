package com.ssafy.board.model.dto;

public class Place {
    private String id;
    private String name;
    private String address;
    private String course;
    private String length;
    private String duration;
    private String image;
    private String mapLink;
    
    public Place() {
    }
    
    public Place(String id, String name, String address, String course, String length, String duration, String image, String mapLink) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.course = course;
        this.length = length;
        this.duration = duration;
        this.image = image;
        this.mapLink = mapLink;
    }
    
    // Getters and Setters
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getCourse() {
        return course;
    }
    
    public void setCourse(String course) {
        this.course = course;
    }
    
    public String getLength() {
        return length;
    }
    
    public void setLength(String length) {
        this.length = length;
    }
    
    public String getDuration() {
        return duration;
    }
    
    public void setDuration(String duration) {
        this.duration = duration;
    }
    
    public String getImage() {
        return image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }
    
    public String getMapLink() {
        return mapLink;
    }
    
    public void setMapLink(String mapLink) {
        this.mapLink = mapLink;
    }
}