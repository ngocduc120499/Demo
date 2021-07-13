package com.example.Week2Demo.Controller;

import com.example.Week2Demo.Service.UserService;
import com.example.Week2Demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List> findAll(){
        return ResponseEntity.ok(userService.getInfo());
    }

    @PostMapping
    public void save(@RequestBody User user){
        userService.save(user);
    }
}
