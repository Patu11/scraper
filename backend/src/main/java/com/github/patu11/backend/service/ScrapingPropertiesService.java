package com.github.patu11.backend.service;

import com.github.patu11.backend.model.common.ScrapingProperty;
import com.github.patu11.backend.model.dto.ScrapingPropertyDto;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ScrapingPropertiesService {
    private final ScrapingPropertiesRepository scrapingPropertiesRepository;

    @Transactional
    public void addProperty(ScrapingPropertyDto body) {
        ScrapingProperty property = new ScrapingProperty();
        property.setName(body.name());
        property.setType(body.type());
        this.scrapingPropertiesRepository.save(property);
    }

    public List<ScrapingPropertyDto> getAllPropertiesByType(String type) {
        List<ScrapingProperty> scrapingProperties = this.scrapingPropertiesRepository.findAllByType(type);
        return scrapingProperties.stream()
                .map(this::mapScrapingProperty)
                .toList();
    }

    @Transactional
    public void deleteByName(String name) {
        this.scrapingPropertiesRepository.deleteByName(name);
    }

    private ScrapingPropertyDto mapScrapingProperty(ScrapingProperty scrapingProperty) {
        return new ScrapingPropertyDto(scrapingProperty.getName(), scrapingProperty.getType());
    }
}
