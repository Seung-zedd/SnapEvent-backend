package com.example.snapEvent.member.repository;

import com.example.snapEvent.member.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByUsername(String username);

    Optional<RefreshToken> findByRefreshToken(String refreshToken);
}
