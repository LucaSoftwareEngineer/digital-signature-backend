package digital.signature.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import digital.signature.backend.models.Documento;
import digital.signature.backend.models.Utente;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {

    public List<Documento> findByUtenti(List<Utente> utenti);

}
