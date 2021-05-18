package ar.edu.unnoba.pdyc.mymusic.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Table(name="users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true)
    private String email;

    private String password;

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // el username que espera el spring security, para nosotros es nuestro email
    @Override
    public String getUsername(){
        return this.email;
    }

    // roles que tienen los usuarios
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }

    //nunca van a expirar
    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    // nunca se van a bloquear
    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    // nunca van a expirar
    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }

    //siempre va a estar habilitado
    @Override
    public boolean isEnabled(){
        return true;
    }

}
