package com.example.weathermonitoring.repository;

import com.example.weathermonitoring.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long>, JpaSpecificationExecutor<City> {

    @Query(value = "select * from city where id = :id ",nativeQuery = true)
    City getById(Long id);
}
