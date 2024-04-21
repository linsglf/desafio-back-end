package linsglf.picpaysimplificado.repository;

import linsglf.picpaysimplificado.domain.user.User;
import org.hibernate.annotations.processing.SQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByCpf(String cpf);
    User findByEmail(String email);

    @Modifying
    @Query(value = "UPDATE users SET is_active = false WHERE id = ?1", nativeQuery = true)
    void logicalDeleteById(Long id);

    @Modifying
    @Query(value = "UPDATE users SET is_active = true WHERE id = ?1", nativeQuery = true)
    void logicalActivateById(Long id);
}
