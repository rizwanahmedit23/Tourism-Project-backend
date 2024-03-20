package com.tourism.Travel_Buddy.repository;

import com.tourism.Travel_Buddy.model.Packages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PackageRepo extends JpaRepository<Packages,Integer> {

    @Override
    Optional<Packages> findById(Integer integer);

}
