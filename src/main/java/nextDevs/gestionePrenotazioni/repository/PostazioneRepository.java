package nextDevs.gestionePrenotazioni.repository;

import nextDevs.gestionePrenotazioni.TipoPostazione;
import nextDevs.gestionePrenotazioni.bean.Postazione;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostazioneRepository extends JpaRepository<Postazione, Integer> {
    List<Postazione> findByTipoPostazioneAndEdificio_Citta(TipoPostazione tipoPostazione, String citta);
}
