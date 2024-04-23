package me.diisk.api.domain.consulta.validacoes;

import org.springframework.beans.factory.annotation.Autowired;

import me.diisk.api.domain.ValidacaoException;
import me.diisk.api.domain.consulta.DadosAgendamentoConsulta;
import me.diisk.api.domain.paciente.PacienteRepository;

public class ValidadorPacienteAtivo {

    @Autowired
    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {

        if (dados.medicoId() == null)
            return;

        var pacienteEstaInativo = repository.findInativoById(dados.pacienteId());

        if (!pacienteEstaInativo) {
            throw new ValidacaoException("Esse paciente não é válido.");
        }
    }

}
