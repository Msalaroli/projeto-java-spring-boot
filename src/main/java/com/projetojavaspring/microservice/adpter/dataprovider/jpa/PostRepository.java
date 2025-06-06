package com.projetojavaspring.microservice.adpter.dataprovider.jpa;

import com.projetojavaspring.microservice.adpter.dataprovider.jpa.entity.PostEntity;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
  Set<PostEntity> findAllByUserId(Long userId);
}
