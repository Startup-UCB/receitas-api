package br.com.ucb.startup.receitas_api.dominio.model;

import org.springframework.security.core.GrantedAuthority;

public enum Perfil implements GrantedAuthority {
    ADM,
    USUARIO;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
