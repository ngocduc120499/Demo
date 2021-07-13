package com.example.Week2Demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Component
@Entity
@Table(name="address")
public class Address implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "province")
    private String province;
    @Column(name = "city")
    private String city;
    @Column(name="stress")
    private String stress;

    public Address(String province, String city, String stress) {
        this.province = province;
        this.city = city;
        this.stress = stress;
    }
}
