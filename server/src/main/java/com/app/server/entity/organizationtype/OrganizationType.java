package com.app.server.entity.organizationtype;

import com.app.server.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(indexes = {@Index(columnList = "id", name = "PK_OrganizationType_id")})
public class OrganizationType extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String fullName;
}
