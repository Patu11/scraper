package com.github.patu11.backend.service;

import com.github.patu11.backend.model.common.ScrapingProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScrapingPropertiesRepository extends JpaRepository<ScrapingProperty, Integer> {
    List<ScrapingProperty> findAllByType(String type);

    void deleteByName(String name);
}
