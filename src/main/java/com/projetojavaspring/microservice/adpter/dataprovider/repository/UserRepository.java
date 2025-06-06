package com.projetojavaspring.microservice.adpter.dataprovider.repository;

import com.projetojavaspring.microservice.adpter.dataprovider.entity.UserEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
  Optional<UserEntity> findById(Long id);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);
}
