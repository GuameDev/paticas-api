package com.paticasprototype.paticas.application.services.shelters.dtos;

public class ShelterDTO {
    private Long id;
    private String name;
    private String address;
    private String pathHeaderImage;
    private String pathCardImage;

    // Getters and Setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getPathHeaderImage() {
        return pathHeaderImage;
    }

    public void setPathHeaderImage(String pathHeaderImage) {
        this.pathHeaderImage = pathHeaderImage;
    }

    public String getPathCardImage() {
        return pathCardImage;
    }

    public void setPathCardImage(String pathCardImage) {
        this.pathCardImage = pathCardImage;
    }
}
