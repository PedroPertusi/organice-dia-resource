package organice.dia;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import organice.lembrete.LembreteController;
import organice.lembrete.LembreteDateIn;
import organice.lembrete.LembreteOut;

@Service
public class DiaService {
    
    @Autowired
    private LembreteController lembreteController;

    @Autowired
    private DiaRepository diaRepository;

    public Dia create(Dia in, String idUser) {
        in.data_criacao(new Date());
        in.dia_da_semana(DiaParser.calculaDiaDaSemana(in.data()));

        return diaRepository.save(new DiaModel(in)).to();
    }

    public ResponseEntity<List<LembreteOut>> getLembretes(String userId, Date data) {
        LembreteDateIn date = new LembreteDateIn(data);
        return lembreteController.getByDate(userId, date);
    }

    public void delete(String id_dia) {
        // TODO Auto-generated method stub
        diaRepository.deleteById(id_dia);
    }

    public Dia update(String id_dia, Dia dia) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }


}
