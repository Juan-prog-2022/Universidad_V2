package ar.com.bluesoftware.universidad;

import ar.com.bluesoftware.universidad.entidades.Usuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Juan
 */
@Service
public class Security implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public Security(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        // Imprime los roles para verificar
        System.out.println("Roles del usuario: " + usuario.getRoles());

        // Devolver un UserDetails basado en tu entidad Usuario
        return usuario;
    }

}
