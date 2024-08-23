package br.com.ucb.startup.receitas_api.infraestrutura.entidades;

import br.com.ucb.startup.receitas_api.dominio.model.Perfil;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UsuarioEntidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    private String sobrenome;

    @NotBlank
    @Column(unique = true)
    private String documento;

    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    private String senha;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Perfil perfil;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private EnderecoEntidade endereco;
}
