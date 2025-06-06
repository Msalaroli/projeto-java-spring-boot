package com.projetojavaspring.microservice.adpter.dataprovider.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "username")
  private String username;

  @Column(name = "email")
  private String email;

  @Column(name = "password_hash")
  private String passwordHash;

  @Column(name = "full_name")
  private String fullName;

  @Column(name = "bio")
  private String bio;

  @Column(name = "avatar_url")
  private String avatarUrl;

  @CreationTimestamp
  @Column(name = "created_at", updatable = false, nullable = false)
  private LocalDateTime createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at", nullable = false)
  private LocalDateTime updatedAt;

  @OneToMany(
      mappedBy = "user",
      cascade = CascadeType.ALL,
      orphanRemoval = true,
      fetch = FetchType.EAGER)
  private Set<PostEntity> posts;
}
