package com.example.mongodb.model.request;

import lombok.Getter;

@Getter
public class BlackListRequest {
    private String userPhone;
    private  String blockedPhone;
}
