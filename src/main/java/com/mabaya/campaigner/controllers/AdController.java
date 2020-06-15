package com.mabaya.campaigner.controllers;

import com.mabaya.campaigner.model.Product;
import com.mabaya.campaigner.services.ad.AdService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ad")
public class AdController {

    private final AdService adService;

    public AdController(AdService adService) {
        this.adService = adService;
    }

    @GetMapping("/product/{category}")
    public ResponseEntity<Product> getHighestBidProductByCategory(@PathVariable String category) {
        return new ResponseEntity<>(adService.findHighestBidProductByCategory(category), HttpStatus.OK);
    }
}
