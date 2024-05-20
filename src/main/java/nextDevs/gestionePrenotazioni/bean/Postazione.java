package nextDevs.gestionePrenotazioni.bean;

import jakarta.persistence.*;
import lombok.Data;
import nextDevs.gestionePrenotazioni.TipoPostazione;
import org.springframework.stereotype.Component;

@Data
@Entity

@Component
public class Postazione {
    @Id
    private Integer codiceUnivoco;
    private String descrizione;

    @Enumerated(EnumType.STRING)
    private TipoPostazione tipoPostazione;
    private Integer numeroMaxPartecipanti;
    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;


}
