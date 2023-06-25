package com.github.patu11.backend.service;

import com.github.patu11.backend.model.common.ScrapingProperty;
import com.github.patu11.backend.model.dto.ScrapingPropertyDto;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ScrapingPropertiesService {
    private final ScrapingPropertiesRepository scrapingPropertiesRepository;

    @Transactional
    public void addProperty(ScrapingPropertyDto body) {
        ScrapingProperty property = ScrapingProperty.builder()
                .name(body.name())
                .type(body.type())
                .notification(true)
                .build();

        this.scrapingPropertiesRepository.save(property);
    }

    @Transactional
    public void updateProperty(ScrapingPropertyDto body) {
        Optional<ScrapingProperty> propertyOptional = this.scrapingPropertiesRepository.findByName(body.name());

        ScrapingProperty property = propertyOptional.orElseThrow(() -> new NoSuchElementException("Property not found."));

        property.setNotification(body.notification());

        this.scrapingPropertiesRepository.save(property);
    }

    public List<ScrapingPropertyDto> getAllPropertiesByType(String type) {
        return this.getAllProperties().stream()
                .filter(property -> property.type().equalsIgnoreCase(type))
                .toList();
    }

    @Transactional
    public void deleteByName(String name) {
        this.scrapingPropertiesRepository.deleteByName(name);
    }

    private ScrapingPropertyDto mapScrapingProperty(ScrapingProperty scrapingProperty) {
        return new ScrapingPropertyDto(scrapingProperty.getName(), scrapingProperty.getType(), scrapingProperty.isNotification());
    }

    private List<ScrapingPropertyDto> getAllProperties() {
        return this.scrapingPropertiesRepository.findAll().stream()
                .map(this::mapScrapingProperty)
                .toList();
    }
}
