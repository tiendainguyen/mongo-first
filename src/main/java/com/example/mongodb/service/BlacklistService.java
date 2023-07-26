package com.example.mongodb.service;

import com.example.mongodb.model.entity.BlockedPhoneList;
import com.example.mongodb.model.entity.BlockerPhoneList;
import com.example.mongodb.repository.BlockedListRepository;
import com.example.mongodb.repository.BlockerListRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class BlacklistService {

    private final BlockedListRepository blockedListRepository;
    private final BlockerListRepository blockerListRepository;


    public BlockedPhoneList getBlacklistByUser(String userPhone) {
        log.info("blacklist is: {}", blockedListRepository.findByUserPhone(userPhone));
        return blockedListRepository.findByUserPhone(userPhone);
    }

    public List<BlockedPhoneList> finAll() {
        log.info("blacklist is: {}", blockedListRepository.findAll());
        return blockedListRepository.findAll();
    }

    public void saveBlackList(String userphone, String blockedPhone) {
        log.info("userphone is: {}, blockedphone is: {}", userphone, blockedPhone);

        // Get the blocked phone list by user phone.
        BlockedPhoneList blockedPhoneList = blockedListRepository.findByUserPhone(userphone);

        // If the blocked phone list does not exist, create a new one.
        if (blockedPhoneList == null) {
            blockedPhoneList = BlockedPhoneList.builder()
                    .userPhone(userphone)
                    .blockedPhoneList(Arrays.asList(blockedPhone)).build();
        } else {
            if (blockedPhoneList.getBlockedPhoneList().contains(blockedPhone)){
                throw new RuntimeException("blocked is exist");
            }
            // Add the blocked phone to the list.
            blockedPhoneList.getBlockedPhoneList().add(blockedPhone);
        }

        BlockerPhoneList blockerPhoneList = blockerListRepository.findByUserPhone(blockedPhone).orElse(null);
        if(blockerPhoneList == null){

             blockerPhoneList = BlockerPhoneList.builder()
                    .userPhone(blockedPhone)
                    .blockerPhoneList(Arrays.asList(userphone)).build();
        } else {
            if(blockerPhoneList.getBlockerPhoneList().contains(userphone)){
                throw new RuntimeException("blocker is exist");
            }
             blockerPhoneList.getBlockerPhoneList().add(blockedPhone);
        }
        blockedListRepository.save(blockedPhoneList);
        blockerListRepository.save(blockerPhoneList);
    }
}