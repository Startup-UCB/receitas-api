package br.com.ucb.startup.receitas_api.infraestrutura.repositorio;

import br.com.ucb.startup.receitas_api.infraestrutura.entidades.UsuarioEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepositorio extends JpaRepository<UsuarioEntidade, Long> {

    @Query("SELECT u FROM UsuarioEntidade u INNER JOIN u.endereco e WHERE u.id =:id")
    Optional<UsuarioEntidade> consultaUsuarioPorId(@Param("id") Long id);

    @Query("SELECT u FROM UsuarioEntidade u WHERE u.documento =:documento")
    Optional<UsuarioEntidade> consultaUsuarioPorDocumento(@Param("documento") String documento);

    @Query("SELECT u FROM UsuarioEntidade u WHERE u.email =:email")
    Optional<UsuarioEntidade> consultaUsuarioPorEmail(@Param("email") String email);

}
