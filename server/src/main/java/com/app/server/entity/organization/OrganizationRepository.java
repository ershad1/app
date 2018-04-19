package com.app.server.entity.organization;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = OrganizationProjection.class)
public interface OrganizationRepository extends JpaRepository<Organization, Long> {
    Organization findById(@Param("id") Long id);
}
