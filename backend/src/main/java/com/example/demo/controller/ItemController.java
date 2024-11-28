package com.example.demo.controller;

import com.example.demo.model.Item;
import com.example.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
@CrossOrigin(origins = "https://sprinboot-backend.azurewebsites.net")  // Corrected here: URL is now a string in double quotes
public class ItemController {

    @Autowired
    private ItemService itemService;

    // Get all items
    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    // Get item by ID
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable String id) {
        Optional<Item> item = itemService.getItemById(id);
        return item.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new item
    @PostMapping
    public Item createItem(@RequestBody Item item) {
        return itemService.createItem(item);
    }

    // Update an existing item
    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable String id, @RequestBody Item item) {
        Item updatedItem = itemService.updateItem(id, item);
        return updatedItem != null ? ResponseEntity.ok(updatedItem) : ResponseEntity.notFound().build();
    }

    // Delete an item by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable String id) {
        itemService.deleteItem(id);
        return ResponseEntity.noContent().build();
    }
}
