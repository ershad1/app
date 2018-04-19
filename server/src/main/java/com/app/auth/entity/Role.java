package com.app.auth.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data
@Table(indexes = {@Index(columnList = "id", name = "PK_Role_id")})
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String label;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "role_privilege",
            joinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_role_privilege_role_id")),
            inverseJoinColumns = @JoinColumn(
                    name = "privilege_id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_role_privilege_privilege_id")))
    private Collection<Privilege> privileges;

    public Role() {
    }

    public Role(Long id, String label) {
        this.id = id;
        this.label = label;
    }

}
