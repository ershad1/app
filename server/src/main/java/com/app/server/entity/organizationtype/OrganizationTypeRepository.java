package com.app.server.entity.organizationtype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrganizationTypeRepository extends JpaRepository<OrganizationType, Long> {

    @Query("SELECT c FROM OrganizationType c")
    List<OrganizationType> findAllOrganizationType();
}