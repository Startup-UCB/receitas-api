package br.com.ucb.startup.receitas_api.infraestrutura.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "enderecos")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EnderecoEntidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco")
    private Long id;

    @NotBlank
    private String cep;

    @NotBlank
    private String logradouro;

    @NotBlank
    private String numero;

    @NotBlank
    private String bairro;

    @NotBlank
    private String complemento;

    @NotBlank
    private String pais;

    @NotBlank
    private String cidade;

    private String estado;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_usuario")
    private UsuarioEntidade usuario;

}
