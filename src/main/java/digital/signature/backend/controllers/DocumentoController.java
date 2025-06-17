package digital.signature.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import digital.signature.backend.models.Documento;
import digital.signature.backend.services.DocumentoService;

@RestController
@CrossOrigin(origins = "*")
public class DocumentoController {

    @Autowired
    DocumentoService documentoService;

    @PostMapping("api/documento/firma")
    public Boolean firmaDocumento(
        @RequestParam("titolo") String titolo,
        @RequestPart("file") MultipartFile file,
        @RequestParam("firma") String firma,
        @RequestParam("idUtente") Long idUtente
    ) {
        return documentoService.firmaDocumento(titolo, file, firma, idUtente);
    }

    @GetMapping("api/elenco/documenti")
    public List<Documento> elencoDocumenti(@RequestParam("idUtente") Long idUtente) {
        return documentoService.elencoDocumenti(idUtente);
    }

}
