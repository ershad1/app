package com.app.server.entity.applanguage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AppLanguageRepository extends JpaRepository<AppLanguage, Long> {
    @Query("SELECT l FROM AppLanguage l")
    List<AppLanguage> findAllAppLanguage();
}