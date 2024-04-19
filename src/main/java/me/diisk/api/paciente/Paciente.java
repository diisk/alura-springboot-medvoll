package me.diisk.api.paciente;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.diisk.api.endereco.Endereco;
import me.diisk.api.pessoa.DadosAtualizacaoPessoa;

@Table(name = "pacientes")
@Entity(name = "Paciente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Paciente {

    public Paciente(DadosCadastroPaciente dados) {
        this.inativo = false;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.endereco = new Endereco(dados.endereco());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private String cpf;

    @Embedded
    private Endereco endereco;

    private Boolean inativo;

    public void atualizarInformacoes(@Valid DadosAtualizacaoPessoa dados) {
        if (dados.nome() != null)
            this.nome = dados.nome();

        if (dados.telefone() != null)
            this.telefone = dados.telefone();

        if (dados.endereco() != null)
            this.endereco = new Endereco(dados.endereco());
    }

    public void deletar(){
        this.inativo = true;
    }

}
