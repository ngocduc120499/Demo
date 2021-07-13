package com.example.Week2Demo.Controller;

import com.example.Week2Demo.Service.UserDetailService;
import com.example.Week2Demo.Service.UserService;
import com.example.Week2Demo.Utils.JwtUtil;
import com.example.Week2Demo.model.AuthUser;
import com.example.Week2Demo.model.Token;
import com.example.Week2Demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;
    @Autowired
    private UserDetailService userDetailsService;


//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public ResponseEntity<?> createAuthenticationToken(@RequestBody User authenticationRequest) throws Exception {
//
//        try {
//            authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUserName(), authenticationRequest.getPassword())
//            );
//        }
//        catch (BadCredentialsException e) {
//            throw new Exception("Incorrect username or password", e);
//        }
//
//
//        final UserDetails userDetails = userDetailsService
//                .loadUserByUsername(authenticationRequest.getUserName());
//
//        final String jwt = jwtTokenUtil.generateToken(userDetails);
//
//        return ResponseEntity.ok(new Token(jwt));
//    }

    @PostMapping("/login")
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseEntity<?> generateToken(@RequestBody AuthUser authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (BadCredentialsException ex) {
            throw new BadCredentialsException("inavalid username/password");

        }
        final String jwt = jwtTokenUtil.generateToken(authRequest.getUserName());
        return ResponseEntity.ok(new Token(jwt));
    }


}
