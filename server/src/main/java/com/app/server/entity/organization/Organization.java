package com.app.server.entity.organization;

import com.app.server.entity.BaseEntity;
import com.app.server.entity.address.Address;
import com.app.server.entity.applanguage.AppLanguage;
import com.app.server.entity.organizationtype.OrganizationType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(indexes = {@Index(columnList = "id", name = "PK_Organization_id")})
public class Organization extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @OneToOne
    @JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "FK_Organization_Address"))
    private Address address;

    @OneToOne
    @JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "FK_Organization_OrganizationType"))
    private OrganizationType organizationProfile;

    @ManyToOne
    @JoinColumn(nullable = false, foreignKey = @ForeignKey(name = "FK_Organization_AppLanguage"))
    AppLanguage appLanguage;
}
