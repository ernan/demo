package com.example.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "INDIVIDUAL")
public class Individual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SSN")
    private String ssn;
    @Column(name = "DATE_OF_BIRTH")
    private Date dateOfBirth;
    @Column(name = "MOBILE_PHONE")
    private String mobilePhone;

    public Individual() {
    }

    public Individual(String name, String ssn, Date dateOfBirth, String mobilePhone) {
        super();
        this.name = name;
        this.ssn = ssn;
        this.dateOfBirth = dateOfBirth;
        this.mobilePhone = mobilePhone;
    }

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

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
}
