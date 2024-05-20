package nextDevs.gestionePrenotazioni.bean;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
@Entity
@Data

@Component
public class Prenotazione {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "postazione_codice_univoco")
    private Postazione postazione;

    @ManyToOne
    @JoinColumn(name = "utente_username")
    private Utente utente;

    private LocalDate data;


}
