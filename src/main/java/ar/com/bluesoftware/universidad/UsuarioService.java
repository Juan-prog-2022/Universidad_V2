package ar.com.bluesoftware.universidad;

import ar.com.bluesoftware.universidad.entidades.Usuario;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicio para operaciones relacionadas con usuarios.
 *
 * @author Juan
 */
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    /**
     * Guarda un usuario en la base de datos. Antes de guardar, verifica y
     * ajusta la lista de roles si es necesario.
     *
     * @param usuario El usuario a guardar.
     */
    public void guardarUsuario(Usuario usuario) {
        // Antes de guardar el usuario, verifica y ajusta la lista de roles
        if (usuario.getRoles() == null) {
            usuario.setRoles(new ArrayList<>());
        }

        // Puedes agregar más lógica aquí antes de guardar el usuario, si es necesario.
        // Guarda el usuario
        usuarioRepository.save(usuario);

        // Puedes agregar más lógica aquí después de guardar el usuario, si es necesario.
    }

    /**
     * Valida las credenciales de un usuario.
     *
     * @param username El nombre de usuario.
     * @param password La contraseña del usuario.
     * @return True si las credenciales son válidas, false en caso contrario.
     */
    public boolean validarUsuario(String username, String password) {
        Optional<Usuario> optionalUsuario = usuarioRepository.findByUsername(username);

        // Verifica si el usuario existe y si la contraseña es correcta
        return optionalUsuario.isPresent() && optionalUsuario.get().getPassword().equals(password);
    }
}
