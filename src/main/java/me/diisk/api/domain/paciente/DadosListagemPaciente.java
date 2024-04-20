package me.diisk.api.domain.paciente;

import me.diisk.api.domain.endereco.Endereco;

public record DadosListagemPaciente(Long id, String nome, String telefone, Endereco Endereco) {

    public DadosListagemPaciente(Paciente paciente) {
        this(paciente.getId(),paciente.getNome(),paciente.getTelefone(), paciente.getEndereco());
    }

}
