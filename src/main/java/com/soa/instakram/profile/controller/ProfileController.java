package com.soa.instakram.profile.controller;

import com.soa.instakram.profile.dto.ModifyDetails;
import com.soa.instakram.profile.dto.ProfileDto;
import com.soa.instakram.profile.service.ProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/profile")
@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping("/{instaId}")
    public ResponseEntity<ProfileDto> getProfile(@PathVariable String instaId) {
        ProfileDto profile = profileService.getProfile(instaId);
        return ResponseEntity.ok().body(profile);
    }

    @PostMapping("/edit")
    public ResponseEntity<String> modifyProfile(@RequestBody ModifyDetails modifyDetails) {
        profileService.modifyProfile(modifyDetails);
        return ResponseEntity.ok().body("프로필 수정 완료");
    }
}
