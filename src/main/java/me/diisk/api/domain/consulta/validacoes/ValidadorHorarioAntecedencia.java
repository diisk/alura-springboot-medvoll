package me.diisk.api.domain.consulta.validacoes;

import java.time.Duration;
import java.time.LocalDateTime;

import me.diisk.api.domain.ValidacaoException;
import me.diisk.api.domain.consulta.DadosAgendamentoConsulta;

public class ValidadorHorarioAntecedencia {

    public void validar(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();
        var agora = LocalDateTime.now();

        var diferencaEmMinutos = Duration.between(agora, dataConsulta).toMinutes();

        if (diferencaEmMinutos < 30) {
            throw new ValidacaoException("A consulta deve ser agendada com no minimo 30 minutos de antecedencia.");
        }
    }

}
