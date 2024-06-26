package me.diisk.api.domain.consulta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.diisk.api.domain.ValidacaoException;
import me.diisk.api.domain.consulta.validacoes.ValidadorAgendamentoDeConsulta;
import me.diisk.api.domain.medico.Medico;
import me.diisk.api.domain.medico.MedicoRepository;
import me.diisk.api.domain.paciente.PacienteRepository;

@Service
public class AgendaDeConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private List<ValidadorAgendamentoDeConsulta> validadores;

    public DadosDetalhamentoConsulta agendar(DadosAgendamentoConsulta dados) {
        var paciente = pacienteRepository.findById(dados.pacienteId());
        if (paciente.isEmpty())
            throw new ValidacaoException("Id do paciente informado não existe!");

        validadores.forEach(validador -> validador.validar(dados));

        var medico = escolherMedico(dados);

        if (medico == null)
            throw new ValidacaoException("Não existe médico disponível nessa data.");

        var consulta = new Consulta(null, medico, paciente.get(), dados.data());

        consultaRepository.save(consulta);

        return new DadosDetalhamentoConsulta(consulta);
    }

    private Medico escolherMedico(DadosAgendamentoConsulta dados) {
        if (dados.medicoId() != null) {
            var medico = medicoRepository.findById(dados.medicoId());
            if (medico.isEmpty())
                throw new ValidacaoException("Id do medico informado não existe!");

            return medico.get();
        }

        if (dados.especialidade() == null)
            throw new ValidacaoException("Especialidade é obrigatória quando o médico não for escolhido!");

        return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(), dados.data());

    }

}
