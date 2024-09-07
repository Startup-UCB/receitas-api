package br.com.ucb.startup.receitas_api.infraestrutura.config;

import br.com.ucb.startup.receitas_api.infraestrutura.entidades.UsuarioEntidade;
import br.com.ucb.startup.receitas_api.infraestrutura.repositorio.UsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class AuthConfig {

    private final UsuarioRepositorio usuarioRepositorio;

    @Bean
    UserDetailsService userDetailsService(){
        return username -> {
            Optional<UsuarioEntidade> usuario;
            if(username.contains("@")){
                usuario = usuarioRepositorio.consultaUsuarioPorEmail(username);
            } else{
                usuario = usuarioRepositorio.consultaUsuarioPorDocumento(username);
            }
            return usuario.orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
        };
    }

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

}
