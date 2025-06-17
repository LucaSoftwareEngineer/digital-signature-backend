package digital.signature.backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @OneToOne
    private Utente utente;

    public Documento() {}

    public Documento(Long idDocumento, String titolo, String file, String firma, Utente utente) {
        this.idDocumento = idDocumento;
        this.titolo = titolo;
        this.file = file;
        this.firma = firma;
        this.utente = utente;
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

    public Utente getUtente() {
        return this.utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

}
