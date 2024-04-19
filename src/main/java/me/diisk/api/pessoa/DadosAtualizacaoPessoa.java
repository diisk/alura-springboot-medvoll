package me.diisk.api.pessoa;

import jakarta.validation.constraints.NotNull;
import me.diisk.api.endereco.DadosEndereco;

public record DadosAtualizacaoPessoa(
        @NotNull Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {

}
