package com.example.mongodb.model.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "blocked-list")
@Getter
@Setter
@Builder
public class BlockedPhoneList {
    @Id
    private String id;
    @Field("user_phone")
    private String userPhone;
    @Field("blocked_phone_list")
    private List<String> blockedPhoneList;

    // Constructors, getters, and setters (you can generate these using your IDE).
}