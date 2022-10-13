package bxl.model.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class  Utilisateur implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private boolean enabled = true;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = List.of("PROF");

    public Utilisateur(String username, String password, boolean enabled, List<String> roles) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.roles = roles;
    }

    public Utilisateur(String username, String encode) {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map((role) -> new SimpleGrantedAuthority("ROLE_"+role))
                .toList();
    }


    @Override
    public boolean isAccountNonExpired() {
        return  isEnabled() ;
    }

    @Override
    public boolean isAccountNonLocked() {
        return  isEnabled();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return enabled;
    }

}
