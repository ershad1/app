package com.app.auth.repository;

import com.app.auth.entity.User;
import com.app.server.entity.user.UserProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author saka7
 * Provides basic CURD operations with User entity
 */
@Repository
@RepositoryRestResource(excerptProjection = UserProjection.class)
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Finds user by email
     *
     * @param email to look for
     * @return user by given email
     */
    User findByEmail(String email);

    /**
     * Finds user by name
     *
     * @param name to look for
     * @return user by given name
     */
    User findByUsername(String name);

    List<User> findByOrganizationIdAndRoleLabel(@Param("id") Long id, @Param("name") String name);

    Page<User> findByOrganizationId(@Param("id") Long id, Pageable pageable);
}
