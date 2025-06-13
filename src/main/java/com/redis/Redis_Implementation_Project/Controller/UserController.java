package com.redis.Redis_Implementation_Project.Controller;

import com.redis.Redis_Implementation_Project.Model.User;
import com.redis.Redis_Implementation_Project.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/saveUser")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User updatedUser) {
        User existing = userService.getUserById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        existing.setName(updatedUser.getName());
        existing.setEmail(updatedUser.getEmail());
        existing.setAddress(updatedUser.getAddress());

        User saved = userService.saveUser(existing);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable long id){
        User userById = userService.getUserById(id);
        return ResponseEntity.ok(userById);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable long id){
        userService.deleteUserById(id);
        return "User has been deleted";

    }

}
