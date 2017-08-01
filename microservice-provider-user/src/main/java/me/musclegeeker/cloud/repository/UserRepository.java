package me.musclegeeker.cloud.repository;

import me.musclegeeker.cloud.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
