package com.example.blogtest.repo;

import com.example.blogtest.entity.Users;
import org.springframework.data.repository.CrudRepository;

public interface MainRepo extends CrudRepository<Users, Long> {
}
