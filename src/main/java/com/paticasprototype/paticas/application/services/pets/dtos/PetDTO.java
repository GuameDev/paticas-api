package com.paticasprototype.paticas.application.services.pets.dtos;

import com.paticasprototype.paticas.application.services.shelters.dtos.ShelterDTO;

import java.util.Date;

public class PetDTO {
    private Long id;
    private String name;
    private String gendre;
    private String species;
    private String race;
    private double size;
    private Date birthDate;
    private String description;
    private String phoneNumber;
    private ShelterDTO shelter;
    private String pathImagesCarousel;
    private String pathCardImage;

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

    public String getGendre() {
        return gendre;
    }

    public void setGendre(String gendre) {
        this.gendre = gendre;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ShelterDTO getShelter() {
        return shelter;
    }

    public void setShelter(ShelterDTO shelter) {
        this.shelter = shelter;
    }

    public String getPathImagesCarousel() {
        return pathImagesCarousel;
    }

    public void setPathImagesCarousel(String pathImagesCarousel) {
        this.pathImagesCarousel = pathImagesCarousel;
    }

    public String getPathCardImage() {
        return pathCardImage;
    }

    public void setPathCardImage(String pathCardImage) {
        this.pathCardImage = pathCardImage;
    }
}
