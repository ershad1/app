package com.app.auth.entity;

import com.app.server.entity.address.Address;
import com.app.server.entity.applanguage.AppLanguage;
import com.app.server.entity.organization.Organization;
import com.app.server.entity.branch.Branch;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"username"}, name = "UK_User_username"),
                @UniqueConstraint(columnNames = {"email"}, name = "UK_User_email")
        },
        indexes = {@Index(columnList = "id", name = "PK_User_id")})
@ToString(of={"id", "username", "email"})
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(nullable = false, length = 150)
    private String username;

    @Email
    @Column(nullable = false, length = 150)
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String fullName;

    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_User_address"))
    private Address address;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_User_role"))
    private Role role;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_User_organization"))
    private Organization organization;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_User_region"))
    private Branch region;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_User_appLanguage"))
    AppLanguage appLanguage;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "FK_User_parentUser"))
    public User parentUser;

    @JsonIgnore
    @OneToMany(mappedBy = "parentUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public List<User> childUsers = new ArrayList<User>();


    public User(String username, String email, String password, Role role) {
        this.setUsername(username);
        this.setEmail(email);
        this.setPassword(password);
        this.setRole(role);
    }

    public User(Long id, String username, String email, String password, Role role) {
        this(username, email, password, role);
        this.setId(id);
    }

    @JsonIgnore
    public String getPassword() {
        return this.password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }
}
