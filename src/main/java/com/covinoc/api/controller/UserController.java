package com.covinoc.api.controller;

import com.covinoc.api.dto.UserDTO;
import com.covinoc.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("newUser")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(service.register(userDTO), HttpStatus.OK);
    }

    @PutMapping("updateUser")
    public ResponseEntity<UserDTO> update(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(service.update(userDTO), HttpStatus.OK);
    }

    @GetMapping("getUsers")
    public ResponseEntity<List<UserDTO>> getAll(UserDTO userDTO) {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("getUserById/{id}")
    public ResponseEntity<Optional> getById(@PathVariable("id") Integer id) {
        return new ResponseEntity<>( service.getById(id) , HttpStatus.OK);
    }

    @DeleteMapping("deleteUser/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
