package nextDevs.gestionePrenotazioni.service;

import nextDevs.gestionePrenotazioni.bean.Edificio;
import nextDevs.gestionePrenotazioni.repository.EdificioRepository;
import nextDevs.gestionePrenotazioni.repository.EdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdificioService {
    @Autowired
    private EdificioRepository edificioRepository;

    public void inserisciEdificio(Edificio edificio) {
        edificioRepository.save(edificio);
    }

    public Edificio getEdificio(int id){
        return edificioRepository.findById(id).get();
    }

    public List<Edificio> getEdificio(){
        return edificioRepository.findAll();
    }


    public void cancellaEdificio(int id){
        edificioRepository.deleteById(id);

    }
}
