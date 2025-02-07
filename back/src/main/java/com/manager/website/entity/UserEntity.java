package com.manager.website.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "`user`")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @Column(nullable = false)
    public String name;

    @Column(unique = true, nullable = false)
    public String username;

    @Column(unique = true, nullable = false)
    public String password;

    @Column(length = 11)
    public String phone;

    @Column(length = 100)
    public String address;

    @Column
    public String role;

    @Column
    public boolean is_accept = false;

    @CreationTimestamp
    public Timestamp created_at;

    @PrePersist
    private void setBefore() {
        this.is_accept = false;
        this.role = "ROLE_USER";
    }

}
