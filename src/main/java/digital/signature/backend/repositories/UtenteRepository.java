package digital.signature.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import digital.signature.backend.models.Utente;

public interface UtenteRepository extends JpaRepository<Utente, Long> {

    @Query(
        " SELECT u.idUtente FROM Utente u " +
        " WHERE u.username = :username AND u.password = :password "
    )
    public Long findByUsernameAndPassword(String username, String password);

}
