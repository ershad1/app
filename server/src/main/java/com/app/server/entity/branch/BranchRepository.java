package com.app.server.entity.branch;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = BranchProjection.class)
public interface BranchRepository extends JpaRepository<Branch, Long> {
    Page<Branch> findByOrganizationId(@Param("id") Long id, Pageable pageable);

    List<Branch> findAllByOrganizationId(@Param("id") Long id);
}
