package com.riwi.querertourapi.api.controllers;

import com.riwi.querertourapi.api.dto.request.SiteRequest;
import com.riwi.querertourapi.api.dto.response.SiteResponse;
import com.riwi.querertourapi.infrastructure.abstract_services.ISiteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/site")
@AllArgsConstructor
public class SiteController {
    @Autowired
    private ISiteService siteService;

    @GetMapping
    public ResponseEntity<Page<SiteResponse>> getAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "2") int size) {
       return ResponseEntity.ok(this.siteService.getAll(page -1, size));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<SiteResponse> get(@PathVariable String id) {
        return ResponseEntity.ok(this.siteService.getById(id));
    }

    @PostMapping
    public ResponseEntity<SiteResponse> insert(@Validated @RequestBody SiteRequest siteRequest) {
        return ResponseEntity.ok(this.siteService.create(siteRequest));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<SiteResponse> update(@PathVariable String id, @Validated @RequestBody SiteRequest siteRequest) {
        return ResponseEntity.ok(this.siteService.update(id,siteRequest));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable String id) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Site was deleted successfully");

        this.siteService.delete(id);
        return ResponseEntity.ok(response);
    }
}
