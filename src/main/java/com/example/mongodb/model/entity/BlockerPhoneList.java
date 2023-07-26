package com.example.mongodb.model.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document("blocker-list")
@Getter
@Setter
@Builder
public class BlockerPhoneList {
    @Id
    private String id;
    @Field("user_phone")
    private String userPhone;
    @Field("blocker_phone_list")
    private List<String> blockerPhoneList;
}
