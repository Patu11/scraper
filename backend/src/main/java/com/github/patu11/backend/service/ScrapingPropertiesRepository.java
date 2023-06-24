package com.github.patu11.backend.service;

import com.github.patu11.backend.model.common.ScrapingProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScrapingPropertiesRepository extends JpaRepository<ScrapingProperty, Integer> {
    void deleteByName(String name);
}
