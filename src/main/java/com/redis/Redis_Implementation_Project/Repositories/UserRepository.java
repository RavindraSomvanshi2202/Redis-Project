package com.redis.Redis_Implementation_Project.Repositories;

import com.redis.Redis_Implementation_Project.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
