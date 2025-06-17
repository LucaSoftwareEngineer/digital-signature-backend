package digital.signature.backend.services;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import digital.signature.backend.models.Documento;
import digital.signature.backend.models.Utente;
import digital.signature.backend.repositories.DocumentoRepository;
import digital.signature.backend.repositories.UtenteRepository;

@Service
public class DocumentoService {

    @Autowired
    DocumentoRepository documentoRepository;

    @Autowired
    UtenteRepository utenteRepository;

    final String PUBLIC_DIRECTORY = "/home/luca/Scrivania/WWW/digital-signature-backend/src/main/resources/public/";

    public Boolean firmaDocumento(String titolo, MultipartFile file, String firma, Long idUtente) {

        String percorso = PUBLIC_DIRECTORY.concat(titolo).concat(file.getName()).concat(".pdf");

        try {
            file.transferTo(new File(percorso));
        } catch (Exception e) {
           return false;
        }

        Utente utente = utenteRepository.findById(idUtente).get();
        List<Utente> utenti = new ArrayList<Utente>();
        utenti.add(utente);
        Documento documento = new Documento(null, titolo, percorso, firma, utenti);

        try {
            documentoRepository.save(documento);
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    public List<Documento> elencoDocumenti(Long idUtente) {
        Utente utente = utenteRepository.findById(idUtente).get();
        List<Utente> utenti = new ArrayList<Utente>();
        utenti.add(utente);
        return documentoRepository.findByUtenti(utenti);
    }

}
