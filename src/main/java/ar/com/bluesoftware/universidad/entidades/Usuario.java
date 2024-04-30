package ar.com.bluesoftware.universidad.entidades;


import jakarta.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Juan
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "usuarios")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_User;

    private String username;
    private String password;

    @ElementCollection
    @CollectionTable(name = "roles", joinColumns = @JoinColumn(name = "id_User"))
    @Column(name = "role", columnDefinition = "VARCHAR(255) DEFAULT 'ROLE_USER'")
    private List<String> roles;

    // Implementar métodos de UserDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        // Convertir roles a GrantedAuthority (puedes usar SimpleGrantedAuthority)
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .collect(Collectors.toList());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // La cuenta nunca expira
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // La cuenta nunca está bloqueada
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Las credenciales nunca caducan
    }

    @Override
    public boolean isEnabled() {
        return true; // El usuario siempre está habilitado
    }

    @Override
    public String getUsername() {
        return username;
    }
}
