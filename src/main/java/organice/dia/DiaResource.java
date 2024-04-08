package organice.dia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Date;
import java.util.Map;

@RestController
public class DiaResource implements DiaController {

    @Autowired
    private DiaService diaService; // Ajustado para DiaService

    @GetMapping("/dias/info")
    public ResponseEntity<Map<String, String>> info() {
        return new ResponseEntity<>(
            Map.ofEntries(
                // As informações do sistema permanecem inalteradas
                Map.entry("microservice.name", DiaApplication.class.getSimpleName()) // Ajuste para o nome da sua aplicação, se necessário
                // os.arch, os.name, etc.
            ), HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<DiaOut> create(@RequestBody DiaIn diaIn) {
        // Implementação exemplo
        Dia dia = DiaParser.to(diaIn); // Assume que você tem uma classe DiaParser para converter DiaIn em Dia
        dia = diaService.create(dia);
        return ResponseEntity.created(
            ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dia.getId()) // Ajuste conforme o método getter de ID em sua classe Dia
                .toUri())
            .body(DiaParser.to(dia)); // E uma conversão de volta para DiaOut
    }

    @Override
    public ResponseEntity<DiaOut> update(@PathVariable("id_dia") String id_dia, @RequestBody DiaIn diaIn) {
        // Implementação exemplo
        Dia dia = DiaParser.to(diaIn); // Supondo conversão de DiaIn para o modelo Dia
        dia = diaService.update(id_dia, dia); // Supondo que o serviço retorne o objeto atualizado
        return ResponseEntity.ok(DiaParser.to(dia)); // Convertendo de volta para DiaOut
    }

    @Override
    public ResponseEntity<Void> delete(@PathVariable("id_dia") String id_dia) {
        diaService.delete(id_dia);
        return ResponseEntity.noContent().build();
    }

}
