package com.projetojavaspring.microservice.adpter.dataprovider.repository;

import com.projetojavaspring.microservice.adpter.dataprovider.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
