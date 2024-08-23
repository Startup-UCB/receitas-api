package br.com.ucb.startup.receitas_api.infraestrutura.repositorio;

import br.com.ucb.startup.receitas_api.infraestrutura.entidades.UsuarioEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends JpaRepository<UsuarioEntidade, Long> {
}
