package organice.dia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import organice.lembrete.LembreteDateIn;
import organice.lembrete.LembreteOut;

import java.util.List;
import java.util.Map;

@RestController
@Tag(name = "Dia", description = "API de Dia")
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
    @Operation(summary = "Criar um novo dia", description = "Cria um novo dia e retorna o objeto criado com seu ID.")
    public ResponseEntity<DiaOut> create(String idUser, DiaIn diaIn) {
        // Implementação exemplo
        Dia dia = DiaParser.toDia(diaIn); // Assume que você tem uma classe DiaParser para converter DiaIn em Dia
        dia.id_usuario(idUser);
        dia = diaService.create(dia);
        return ResponseEntity.created(
            ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dia.id()) // Ajuste conforme o método getter de ID em sua classe Dia
                .toUri())
            .body(DiaParser.toDiaOut(dia)); // E uma conversão de volta para DiaOut
    }

    @Override
    @Operation(summary = "Retorna todos os lembretes de um usuário em certa data", description = "Retorna todos os lembretes de um usuário em certa data")
    public ResponseEntity<List<LembreteOut>> read_lembretes(String UserId, LembreteDateIn data) {
        // Implementação exemplo
        return diaService.getLembretes(UserId, data); 
    }

    @Override
    @Operation(summary = "Update Valores do Dia", description = "Update nos valores do Dia")
    public ResponseEntity<DiaOut> update(@PathVariable("id_dia") String id_dia, @RequestBody DiaIn diaIn) {
        // Implementação exemplo
        Dia dia = DiaParser.toDia(diaIn); // Supondo conversão de DiaIn para o modelo Dia
        dia = diaService.update(id_dia, dia); // Supondo que o serviço retorne o objeto atualizado
        return ResponseEntity.ok(DiaParser.toDiaOut(dia)); // Convertendo de volta para DiaOut
    }

    @Override
    @Operation(summary = "Deleta o Dia", description = "Deleta o Dia no banco de dados")
    public ResponseEntity<Void> delete(@PathVariable("id_dia") String id_dia) {
        diaService.delete(id_dia);
        return ResponseEntity.noContent().build();
    }

    @Override
    @Operation(summary = "Retorna os Valores do Dia", description = "Retorna os Valores do Dia ")
    public ResponseEntity<DiaOut> read(String id_dia) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

}
