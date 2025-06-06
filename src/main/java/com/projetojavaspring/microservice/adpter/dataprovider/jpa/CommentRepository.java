package com.projetojavaspring.microservice.adpter.dataprovider.jpa;

import com.projetojavaspring.microservice.adpter.dataprovider.jpa.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {}
