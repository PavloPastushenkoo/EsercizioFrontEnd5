package nextDevs.gestionePrenotazioni.service;

import nextDevs.gestionePrenotazioni.TipoPostazione;
import nextDevs.gestionePrenotazioni.bean.Postazione;
import nextDevs.gestionePrenotazioni.bean.Prenotazione;
import nextDevs.gestionePrenotazioni.bean.Utente;
import nextDevs.gestionePrenotazioni.repository.PostazioneRepository;
import nextDevs.gestionePrenotazioni.repository.PrenotazioneRepository;
import nextDevs.gestionePrenotazioni.repository.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private PostazioneRepository postazioneRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    @Transactional

    public Prenotazione prenotaPostazione(String username, Integer postazioneId, LocalDate data) throws Exception {
        Utente utente = utenteRepository.findById(username).orElseThrow(() -> new Exception("Utente non trovato"));
        Postazione postazione = postazioneRepository.findById(postazioneId).orElseThrow(() -> new Exception("Postazione non trovata"));

        if (!prenotazioneRepository.findByPostazioneAndData(postazione, data).isEmpty()) {
            throw new Exception("Postazione già prenotata per questa data");
        }

        if (!prenotazioneRepository.findByUtenteAndData(utente, data).isEmpty()) {
            throw new Exception("Utente ha già una prenotazione per questa data");
        }

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setUtente(utente);
        prenotazione.setPostazione(postazione);
        prenotazione.setData(data);

        return prenotazioneRepository.save(prenotazione);

    }

}
