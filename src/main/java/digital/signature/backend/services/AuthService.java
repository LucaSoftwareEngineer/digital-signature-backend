package digital.signature.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import digital.signature.backend.models.Utente;
import digital.signature.backend.repositories.UtenteRepository;

@Service
public class AuthService {

    @Autowired
    UtenteRepository utenteRepository;

    public Long login(String username, String password) {
        return utenteRepository.findByUsernameAndPassword(username, password);
    }

    public Boolean register(String username, String password) {
        Utente utente = new Utente(null, username, password);
        try {
            utenteRepository.save(utente);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
