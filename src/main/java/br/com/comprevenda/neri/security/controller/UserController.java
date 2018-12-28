package br.com.comprevenda.neri.security.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.comprevenda.neri.security.entity.User;
import br.com.comprevenda.neri.security.service.UserService;

/**
 * Created by NeriDev on 05/06/2018.
 */


@RestController
@CrossOrigin(origins = "*")
public class UserController {

   @Autowired
   private UserService service;

   @Autowired
   private PasswordEncoder passwordEncoder;

   @PostMapping(value="/createUser")
   public ResponseEntity<?> createUser(HttpServletRequest request, @RequestBody User user){
       user.setPassword(passwordEncoder.encode(user.getPassword()));
       User u = service.createUser(user);
       if(u != null){
           return ResponseEntity.ok(u);
       }else{
           return  ResponseEntity.badRequest().body(null);
       }

   }

}