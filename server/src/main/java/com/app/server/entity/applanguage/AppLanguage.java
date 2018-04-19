package com.app.server.entity.applanguage;

import com.app.server.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"fullName"}, name = "UK_AppLanguage_fullName"),
                @UniqueConstraint(columnNames = {"code"}, name = "UK_AppLanguage_code")
        },
        indexes = {
                @Index(columnList = "id", name = "PK_AppLanguage_id")
        })
public class AppLanguage extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private static final long serialVersionUID = -1951939501997143351L;

    @Column(nullable = false, length = 150)
    private String fullName;

    @Column(nullable = false, length = 150)
    private String code;
}
