package com.example.End_project.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User userToCreate = userService.createUser(user);
        if (userToCreate == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userToCreate, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User userToUpdate =  userService.updateUser(user);
        if (userToUpdate == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userToUpdate, HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id){
        User userToGet = userService.getUser(id);
        if (userToGet == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userToGet, HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUser(@PathVariable String email){
        User userToGet = userService.getUser(email);
        if (userToGet == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userToGet, HttpStatus.OK);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id){
        String userToDelete = userService.deleteUser(id);
        if (!userToDelete.contains("deleted successfully")){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userToDelete, HttpStatus.OK);
    }

    @DeleteMapping("/email/{email}")
    public ResponseEntity<String> deleteUser(@PathVariable String email){
        String userToDelete = userService.deleteUser(email);
        if (!userToDelete.contains("deleted successfully")){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userToDelete, HttpStatus.OK);
    }
}
