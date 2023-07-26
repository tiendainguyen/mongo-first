package com.example.mongodb.controller;

import com.example.mongodb.model.entity.BlockedPhoneList;
import com.example.mongodb.model.request.BlackListRequest;
import com.example.mongodb.service.BlacklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blacklist")
public class BlacklistController {

    private final BlacklistService blacklistService;

    @Autowired
    public BlacklistController(BlacklistService blacklistService) {
        this.blacklistService = blacklistService;
    }

    @GetMapping("/{userPhone}")
    public BlockedPhoneList getBlacklistByUser(@PathVariable String userPhone) {
        return blacklistService.getBlacklistByUser(userPhone);
    }
    @GetMapping
    public List<BlockedPhoneList> getBlacklist() {
        return blacklistService.finAll();
    }
    @PostMapping
    public ResponseEntity<String> addBlackList(@RequestBody BlackListRequest blackListRequest){
        blacklistService.saveBlackList(blackListRequest.getUserPhone(),blackListRequest.getBlockedPhone());
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
