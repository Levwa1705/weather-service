package com.example.weathermonitoring.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "city")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class City {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "country")
    String country;

    @Column(name = "state")
    String state;
    @Column(name =  "city_id")
    Long cityId;
}
