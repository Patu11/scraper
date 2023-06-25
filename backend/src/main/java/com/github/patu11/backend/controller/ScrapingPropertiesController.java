package com.github.patu11.backend.controller;

import com.github.patu11.backend.model.dto.ScrapingPropertyDto;
import com.github.patu11.backend.service.ScrapingPropertiesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class ScrapingPropertiesController {
    private final ScrapingPropertiesService scrapingPropertiesService;

    @PostMapping("/property/add")
    public void addProperty(@RequestBody ScrapingPropertyDto body) {
        this.scrapingPropertiesService.addProperty(body);
    }

    @GetMapping("/property/{type}")
    public List<ScrapingPropertyDto> getPropertiesByType(@PathVariable String type) {
        return this.scrapingPropertiesService.getAllPropertiesByType(type);
    }

    @DeleteMapping("/property/delete/{name}")
    public void deleteByName(@PathVariable String name) {
        this.scrapingPropertiesService.deleteByName(name);
    }

    @PutMapping("/property/update")
    public void update(@RequestBody ScrapingPropertyDto body) {
        this.scrapingPropertiesService.updateProperty(body);
    }
}
