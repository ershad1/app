package com.app.server.entity.branch;

import com.app.server.entity.BaseEntity;
import com.app.server.entity.address.Address;
import com.app.server.entity.organization.Organization;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"fullName", "organization_id"}, name = "UK_Branch_fullName_and_organization_id")
        },
        indexes = {
                @Index(columnList = "id", name = "PK_Branch_id")
        })
public class Branch extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "FK_Branch_Organization"))
    Organization organization;

    @Column(nullable = false, length = 150)
    private String fullName;

    @OneToOne
    @JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "FK_Branch_Address"))
    private Address address;
}
