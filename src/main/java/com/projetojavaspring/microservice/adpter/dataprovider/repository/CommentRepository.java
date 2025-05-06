package com.projetojavaspring.microservice.adpter.dataprovider.repository;

import com.projetojavaspring.microservice.adpter.dataprovider.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
}
