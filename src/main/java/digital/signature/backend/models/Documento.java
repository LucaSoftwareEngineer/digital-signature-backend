package digital.signature.backend.models;

import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="digital_signature_documenti")
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDocumento;

    private String titolo;
    private String file;
    private String firma;

    @ManyToMany
    private List<Utente> utenti;

    public Documento() {}

    public Documento(Long idDocumento, String titolo, String file, String firma, List<Utente> utenti) {
        this.idDocumento = idDocumento;
        this.titolo = titolo;
        this.file = file;
        this.firma = firma;
        this.utenti = utenti;
    }

    public Long getIdDocumento() {
        return this.idDocumento;
    }

    public String getTitolo() {
        return this.titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getFile() {
        return this.file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getFirma() {
        return this.firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public List<Utente> getUtenti() {
        return this.utenti;
    }

    public void setUtente(Utente utente) {
        this.utenti.add(utente);
    }

}
