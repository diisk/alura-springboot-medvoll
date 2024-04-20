package me.diisk.api.domain.pessoa;

import jakarta.validation.constraints.NotNull;
import me.diisk.api.domain.endereco.DadosEndereco;

public record DadosAtualizacaoPessoa(
        @NotNull Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {

}
