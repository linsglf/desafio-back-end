package linsglf.picpaysimplificado.domain.transaction;

import jakarta.persistence.*;
import linsglf.picpaysimplificado.domain.key.PaymentKey;
import linsglf.picpaysimplificado.domain.user.User;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "transactions")
@Table(name = "transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "payer_id")
    private PaymentKey payerId;

    @ManyToOne
    @JoinColumn(name = "payee_id")
    private User payeeId;

    private LocalDateTime transactionDateTime;
}
