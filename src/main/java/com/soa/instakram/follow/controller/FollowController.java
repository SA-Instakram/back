package com.soa.instakram.follow.controller;


import com.soa.instakram.follow.dto.FollowDto;
import com.soa.instakram.follow.entity.Follow;
import com.soa.instakram.follow.service.FollowService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@RequestMapping("/follow")
public class FollowController {

    private  final FollowService followService;

    @PostMapping("/follow")
    public ResponseEntity<?> createFollow(@RequestBody final FollowDto followDto){
        followService.createFollow(followDto);
        return ResponseEntity.ok().body("팔로우완");
    }

    @DeleteMapping("/unfollow")
    public void delete(@RequestBody FollowDto followDto){
        followService.delete(followDto);
    }

}
