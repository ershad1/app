package com.app.server.entity.address;

import com.app.server.entity.BaseEntity;
import com.app.server.entity.country.Country;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = false)
@Data
@Entity
@Table(indexes = {@Index(columnList = "id", name = "PK_Address_id")})
public class Address extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String addressOne;

    private String addressTwo;

    private String division;

    private String district;

    private String subDistrict;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_Address_country"))
    private Country country;
}
