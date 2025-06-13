package com.redis.Redis_Implementation_Project.Services;

import com.redis.Redis_Implementation_Project.Model.User;
import com.redis.Redis_Implementation_Project.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    @CachePut(key = "#user.id",value = "users")
    public User saveUser(User user){
        return userRepository.save(user);
    }

    @Cacheable(value = "users", key = "#id")
    public User getUserById(long id){
        return userRepository.findById(id).orElse(null);
    }

    @CachePut(value = "users", key = "#id")
    public User updateUser(User user,long id){
        User user1 = userRepository.findById(id).orElse(null);
        user1.setName(user.getName());
        user1.setEmail(user.getEmail());
        user1.setAddress(user.getAddress());
        return userRepository.save(user1);
    }

    @CacheEvict(value = "users",key = "#id")
    public void deleteUserById(long id){
        userRepository.findById(id).orElse(null);
    }


}
