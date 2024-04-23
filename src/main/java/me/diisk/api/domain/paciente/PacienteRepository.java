package me.diisk.api.domain.paciente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jakarta.validation.constraints.NotNull;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    Page<Paciente> findAllByInativoFalse(Pageable paginacao);

    @Query("""
            select p.inativo
            from Paciente p
            where
            p.id = :pacienteId
            """)
    Boolean findInativoById(@NotNull Long pacienteId);

}
