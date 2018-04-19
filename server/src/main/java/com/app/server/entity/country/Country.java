package com.app.server.entity.country;

import com.app.server.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(of = {"fullName", "currencyCode"}, callSuper = false)
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"fullName"}, name = "UK_Country_fullName")
},
        indexes = {@Index(columnList = "id", name = "PK_Country_id")}
)
public class Country extends BaseEntity {

    private static final long serialVersionUID = -6016614873154187223L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, length = 150)
    private String fullName;

    @Column(nullable = false)
    private String currencyCode;

    @Column(nullable = false)
    private String currencyName;

    private String currencySymbol;

    private String iso;

    private String iso3;

    private String fips;

    private String phonePrefix;

    private String postalCode;

    private String continent;

    private String languages;

    private Long geoNameId;

    private Boolean selected;
}

