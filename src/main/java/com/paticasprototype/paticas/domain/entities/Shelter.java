package com.paticasprototype.paticas.domain.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;



import java.util.List;

@Entity
public class Shelter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String pathHeaderImage;
    private String pathCardImage;
    @OneToMany(mappedBy = "shelter", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Pet> pets;

    //Getters & Setters
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

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
