package me.diisk.api.domain.consulta.validacoes;

import me.diisk.api.domain.ValidacaoException;
import me.diisk.api.domain.consulta.ConsultaRepository;
import me.diisk.api.domain.consulta.DadosAgendamentoConsulta;

public class ValidadorPacienteSemOutraConsultaDia {

    
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);
        var pacientePossuiOutraConsulta = repository.existsByPacienteIdAndDataBetween(dados.pacienteId(),primeiroHorario,ultimoHorario);
        if (pacientePossuiOutraConsulta) {
            throw new ValidacaoException("Paciente já possui outra consulta agendada no dia.");
        }
    }

}
