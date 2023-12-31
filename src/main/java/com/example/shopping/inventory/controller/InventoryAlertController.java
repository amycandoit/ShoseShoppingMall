package com.example.shopping.inventory.controller;

import com.example.shopping.inventory.domain.entity.InventoryAlert;
import com.example.shopping.inventory.domain.request.InventoryAlertRequest;
import com.example.shopping.inventory.service.InventoryAlterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/alerts")
public class InventoryAlertController {
    private final InventoryAlterService inventoryAlterService;

    @GetMapping
    public List<InventoryAlert> findAllAlert() {
        return inventoryAlterService.findAllAlert();
    }

    @PostMapping
    public void saveAlert(@RequestBody InventoryAlertRequest inventoryAlertRequest) {
        inventoryAlterService.saveAlert(inventoryAlertRequest);
    }

    @DeleteMapping("{alertSeq}")
    public void deleteAlert(@PathVariable("alertSeq") Long alertSeq) {
        inventoryAlterService.deleteAlert(alertSeq);
    }
}
