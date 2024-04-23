package me.diisk.api.domain.consulta.validacoes;

import org.springframework.beans.factory.annotation.Autowired;

import me.diisk.api.domain.ValidacaoException;
import me.diisk.api.domain.consulta.ConsultaRepository;
import me.diisk.api.domain.consulta.DadosAgendamentoConsulta;

public class ValidadorMedicoComOutraConsultaMesmoHorario {

    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {

        var medicoPossuiOutraConsulta = repository.existsByMedicoIdAndData(dados.medicoId(),dados.data());
        if (medicoPossuiOutraConsulta) {
            throw new ValidacaoException("Médico já possuia outra consulta no horário solicitado.");
        }
    }

}
