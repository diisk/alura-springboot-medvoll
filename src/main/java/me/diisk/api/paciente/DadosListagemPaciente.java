package me.diisk.api.paciente;

import me.diisk.api.endereco.Endereco;

public record DadosListagemPaciente(Long id, String nome, String telefone, Endereco Endereco) {

    public DadosListagemPaciente(Paciente paciente) {
        this(paciente.getId(),paciente.getNome(),paciente.getTelefone(), paciente.getEndereco());
    }

}
