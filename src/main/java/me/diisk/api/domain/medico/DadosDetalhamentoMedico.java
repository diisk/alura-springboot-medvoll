package me.diisk.api.domain.medico;

import me.diisk.api.domain.endereco.Endereco;
import me.diisk.api.domain.medico.Especialidade;
import me.diisk.api.domain.medico.Medico;

public record DadosDetalhamentoMedico(Long id, String nome, String email, String crm, Especialidade especialidade, Endereco endereco) {
    public DadosDetalhamentoMedico(Medico medico){
        this(medico.getId(),medico.getNome(),medico.getEmail(),medico.getCrm(),medico.getEspecialidade(),medico.getEndereco());
    }
}
