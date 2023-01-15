package com.mycompany.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder
@Entity
@ToString
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String address;
    private String region;
    private String country;

    @Column(name = "aleatory_text")
    private String aleatoryText;

    @Column(name = "aleatory_number")
    private Integer aleatoryNumber;

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAleatoryText(String aleatoryText) {
        this.aleatoryText = aleatoryText;
    }

    public void setAleatoryNumber(Integer aleatoryNumber) {
        this.aleatoryNumber = aleatoryNumber;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getRegion() {
        return region;
    }

    public String getCountry() {
        return country;
    }

    public String getAleatoryText() {
        return aleatoryText;
    }

    public Integer getAleatoryNumber() {
        return aleatoryNumber;
    }

    public Client(Long id, String name, String email, String address, String region, String country, String aleatoryText, Integer aleatoryNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.region = region;
        this.country = country;
        this.aleatoryText = aleatoryText;
        this.aleatoryNumber = aleatoryNumber;
    }

    public Client() {
    }
}
