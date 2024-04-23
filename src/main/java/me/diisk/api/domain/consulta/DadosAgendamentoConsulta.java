package me.diisk.api.domain.consulta;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import me.diisk.api.domain.medico.Especialidade;

public record DadosAgendamentoConsulta(
        Long medicoId,

        @NotNull Long pacienteId,

        @NotNull @Future LocalDateTime data,

        Especialidade especialidade

) {

}
