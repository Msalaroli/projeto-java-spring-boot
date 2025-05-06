package com.projetojavaspring.microservice.adpter.dataprovider.repository;

import com.projetojavaspring.microservice.adpter.dataprovider.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
