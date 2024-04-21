package linsglf.picpaysimplificado.domain.user;

import jakarta.persistence.*;
import linsglf.picpaysimplificado.domain.key.PaymentKey;
import linsglf.picpaysimplificado.domain.user.dto.UserDTO;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true)
    private String cpf;
    @Column(unique = true)
    private String email;
    private String password;
    private UserType type;
    private BigDecimal balance;
    private boolean isActive;

    @OneToMany(mappedBy = "user")
    private List<PaymentKey> PaymentKeys;

    public User(UserDTO userDTO) {
        this.name = userDTO.name();
        this.cpf = userDTO.cpf();
        this.email = userDTO.email();
        this.password = userDTO.password();
        this.type = userDTO.userType();
        this.balance = userDTO.balance();
    }
}
