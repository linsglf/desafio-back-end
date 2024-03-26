package linsglf.picpaysimplificado.domain.user;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import linsglf.picpaysimplificado.domain.user.dto.UserDTO;
import lombok.*;

@Entity
@Table(name = "merchants")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserMerchant extends User {

    private String cnpj;

    public UserMerchant(UserDTO userDTO) {
        super(userDTO);
        this.cnpj = userDTO.cnpj();
    }
}
