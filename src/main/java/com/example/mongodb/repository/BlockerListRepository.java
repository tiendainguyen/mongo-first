package com.example.mongodb.repository;

import com.example.mongodb.model.entity.BlockerPhoneList;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BlockerListRepository extends MongoRepository<BlockerPhoneList, String> {
    Optional<BlockerPhoneList> findByUserPhone(String userPhone);
}
