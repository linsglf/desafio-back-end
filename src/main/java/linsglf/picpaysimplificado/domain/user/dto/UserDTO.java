package linsglf.picpaysimplificado.domain.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import linsglf.picpaysimplificado.domain.user.UserType;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import java.math.BigDecimal;

public record UserDTO(

        @NotBlank(message = "Nome é obrigatório")
        @Pattern(regexp = "^[^0-9]+$", message = "Nome inválido")
        String name,
        @CPF
        String cpf,
        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Email inválido")
        String email,
        @NotBlank(message = "Senha é obrigatória")
        String password,
        UserType userType,
        BigDecimal balance,
        @CNPJ
        String cnpj

) {
}
