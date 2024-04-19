package me.diisk.api.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import me.diisk.api.endereco.DadosEndereco;

public record DadosCadastroPaciente(
        @NotBlank String nome,
        @Email @NotBlank String email,
        @NotBlank String telefone,
        @NotBlank @Pattern(regexp = "\\d{11}") String cpf,
        @NotNull @Valid DadosEndereco endereco) {

}
