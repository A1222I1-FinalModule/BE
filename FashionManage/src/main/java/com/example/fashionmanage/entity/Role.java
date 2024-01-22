package com.example.fashionmanage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
@Getter
@Setter
@Entity
@Table(name = "role", schema = "fashionShop")
public class Role implements GrantedAuthority {
    private static final long serialVersionUID = 4065375140379002510L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JsonIgnore
    private User user;
    private String role;

    public Role() {
    }
    public Role(String authority) {
        this.role = authority;
    }
    @Override
    public String getAuthority() {
        return role;
    }

    public void setAuthority(String authority) {
        this.role = authority;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((role == null) ? 0 : role.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Role other = (Role) obj;
        if (role == null) {
            if (other.role != null)
                return false;
        } else if (!role.equals(other.role))
            return false;
        return true;
    }

}