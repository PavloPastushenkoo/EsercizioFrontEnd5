package nextDevs.gestionePrenotazioni.repository;

import nextDevs.gestionePrenotazioni.bean.Postazione;
import nextDevs.gestionePrenotazioni.bean.Prenotazione;
import nextDevs.gestionePrenotazioni.bean.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Integer> {
    List<Prenotazione> findByPostazioneAndData(Postazione postazione, LocalDate data);
    List<Prenotazione> findByUtenteAndData(Utente utente, LocalDate data);
}
