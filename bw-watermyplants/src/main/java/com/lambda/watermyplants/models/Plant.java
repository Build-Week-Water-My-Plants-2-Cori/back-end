package com.lambda.watermyplants.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "plants")
public class Plant extends Auditable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long plantid;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String species;

    @Column
    private String photo;

    @Column
    private String frequency;

    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnore
    private User user = new User();

    public Plant() {
    }

    public Plant(String nickname, String species, String photo, String frequency, User user) {
        this.nickname = nickname;
        this.species = species;
        this.photo = photo;
        this.frequency = frequency;
        this.user = user;
    }

    public long getPlantid() {
        return plantid;
    }

    public void setPlantid(long plantid) {
        this.plantid = plantid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
