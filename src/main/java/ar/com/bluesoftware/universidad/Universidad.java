package ar.com.bluesoftware.universidad;

import ar.com.bluesoftware.universidad.vista.Login;
import java.awt.EventQueue;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Universidad {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public Universidad(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public static void main(String[] args) {
        
        // Configuramos el contexto Spring para App de escritorio
        ConfigurableApplicationContext contextoSpring
                = new SpringApplicationBuilder(Universidad.class)
                        .headless(false)
                        .web(WebApplicationType.NONE).run(args);

        // Ejecutamos el Formulario
        EventQueue.invokeLater(() -> {
            // Obtenemos el objeto form a través de Spring
            Login loginForm = contextoSpring.getBean(Login.class);

            // Hacer visible el formulario
            loginForm.setVisible(true);
        });
    }
}
