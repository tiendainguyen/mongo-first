package com.example.mongodb.repository;

import com.example.mongodb.model.entity.BlockedPhoneList;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlockedListRepository extends MongoRepository<BlockedPhoneList, String> {
    BlockedPhoneList findByUserPhone(String userPhone);
}
