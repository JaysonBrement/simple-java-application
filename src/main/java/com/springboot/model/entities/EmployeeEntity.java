package com.springboot.model.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_generator")
    @SequenceGenerator(name = "employee_generator", sequenceName = "employee_seq", allocationSize = 1)
    @Column(name = "employee_id")
    private Integer employeeId;
    @Column(name = "last_name", nullable = false, length = 20)
    private String lastName;
    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;
    @Column(name = "title", length = 30)
    private String title;
    @ManyToOne
    @JoinColumn(name = "reports_to", foreignKey = @ForeignKey(name = "employee_reports_to_fkey"))
    private EmployeeEntity reportsTo;

    @Column(name = "birth_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")  
    private Date birthDate;

    @Column(name = "hire_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd") 
    private Date hireDate;   
    @Column(name = "address", length = 70)
    private String address;
    @Column(name = "city", length = 40)
    private String city;
    @Column(name = "state", length = 40)
    private String state;
    @Column(name = "country", length = 40)
    private String country;

    @Column(name = "postal_code", length = 10)
    private String postalCode;
    @Column(name = "phone", length = 24)
    private String phone;

    @Column(name = "fax", length = 24)
    private String fax;
    @Column(name = "email", length = 60)
    private String email;

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public EmployeeEntity getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(EmployeeEntity reportsTo) {
        this.reportsTo = reportsTo;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    
}