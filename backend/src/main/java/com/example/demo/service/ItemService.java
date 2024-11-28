package com.example.demo.service;

import com.example.demo.model.Item;
import com.example.demo.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    // Get all items
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    // Get item by ID
    public Optional<Item> getItemById(String id) {
        return itemRepository.findById(id);
    }

    // Create new item
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    // Update an existing item
    public Item updateItem(String id, Item item) {
        if (itemRepository.existsById(id)) {
            item.setId(id);  // Ensure the existing ID is set
            return itemRepository.save(item);
        }
        return null;  // If item doesn't exist, return null
    }

    // Delete an item by ID
    public void deleteItem(String id) {
        itemRepository.deleteById(id);
    }
}
