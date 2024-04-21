package linsglf.picpaysimplificado.domain.key;

import jakarta.persistence.*;
import linsglf.picpaysimplificado.domain.user.User;
import lombok.*;

@Entity(name = "PaymentKeys")
@Table(name = "PaymentKeys")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PaymentKey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long id;

    private String userKey;
    private KeyType type;
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public PaymentKey(String userKey, KeyType type, User user) {
        this.userKey = userKey;
        this.type = type;
        this.isActive = true;
        this.user = user;
    }
}
