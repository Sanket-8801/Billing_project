// BillItemController.java
package com.example.Project.controller;

import com.example.Project.model.BillItem;
import com.example.Project.repository.BillItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bill-items")
public class BillItemController {

    @Autowired
    private BillItemRepository billItemRepository;

    @GetMapping
    public List<BillItem> getAllBillItems() {
        return billItemRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BillItem> getBillItemById(@PathVariable Long id) {
        return billItemRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public BillItem createBillItem(@RequestBody BillItem billItem) {
        return billItemRepository.save(billItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BillItem> updateBillItem(@PathVariable Long id, @RequestBody BillItem billItem) {
        if (!billItemRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        billItem.setId(id);
        return ResponseEntity.ok(billItemRepository.save(billItem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBillItem(@PathVariable Long id) {
        if (!billItemRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        billItemRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
