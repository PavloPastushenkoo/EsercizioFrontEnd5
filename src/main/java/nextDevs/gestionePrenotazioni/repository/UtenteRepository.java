package nextDevs.gestionePrenotazioni.repository;

import nextDevs.gestionePrenotazioni.bean.Utente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<Utente, String> {
}
