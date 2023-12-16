package com.soa.instakram.profile.controller;

import com.soa.instakram.profile.dto.response.ProfileDto;
import com.soa.instakram.profile.service.ProfileService;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/profile")
@RestController
public class ProfileController {

    private ProfileService profileService;

    @GetMapping("/{instaId}")
    public ResponseEntity<ProfileDto> getProfile(@RequestParam String instaId) {
        ProfileDto profile = profileService.getProfile(instaId);
        return ResponseEntity.ok().body(profile);
    }
}
