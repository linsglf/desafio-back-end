package linsglf.picpaysimplificado.repository;

import linsglf.picpaysimplificado.domain.user.UserMerchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMerchantRepository extends JpaRepository<UserMerchant, Long> {
}
