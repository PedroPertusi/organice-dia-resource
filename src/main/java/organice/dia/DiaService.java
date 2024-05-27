package organice.dia;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import organice.lembrete.LembreteController;
import organice.lembrete.LembreteDateIn;
import organice.lembrete.LembreteOut;

@Service
public class DiaService {
    
    @Autowired
    private LembreteController lembreteController;

    @Autowired
    private DiaRepository diaRepository;

    public Dia create(Dia in) {
        return diaRepository.save(new DiaModel(in)).to();
    }

    @CircuitBreaker(name="LembreteByData-CB", fallbackMethod = "getByDataFallback")
    public ResponseEntity<List<LembreteOut>> getLembretes(String userId, LembreteDateIn data) {
        System.out.println(data.data());
        return lembreteController.getByDate(userId, data);
    }

    public void delete(String id_dia) {
        // TODO Auto-generated method stub
        diaRepository.deleteById(id_dia);
    }

    public Dia update(String id_dia, Dia dia) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    public ResponseEntity<List<LembreteOut>> getByDataFallback(String userId, LembreteDateIn data, Throwable e){

        return ResponseEntity.ok(new ArrayList<>());
    }
}
