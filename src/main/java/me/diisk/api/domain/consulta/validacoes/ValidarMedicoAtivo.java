package me.diisk.api.domain.consulta.validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import me.diisk.api.domain.ValidacaoException;
import me.diisk.api.domain.consulta.DadosAgendamentoConsulta;
import me.diisk.api.domain.medico.MedicoRepository;

@Component
public class ValidarMedicoAtivo implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {

        if (dados.medicoId() == null)
            return;

        var medicoEstaInativo = repository.findInativoById(dados.medicoId());

        if (medicoEstaInativo) {
            throw new ValidacaoException("Esse médico não está disponível.");
        }
    }

}
