package com.example.demo.repository;

import com.example.demo.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, String> {
    // No need to implement CRUD methods - MongoRepository provides them
    // You can add custom query methods here if needed
}
