package digital.signature.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import digital.signature.backend.models.Documento;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {

}
