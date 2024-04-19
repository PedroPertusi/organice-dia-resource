package organice.dia;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Builder @Getter @Setter @Accessors(chain = true, fluent = true)
@NoArgsConstructor @AllArgsConstructor
public class Dia {
    private String id;
    private String data;
    private String data_criacao;
    private String dia_da_semana;
    private String descricao;
    private String id_usuario;
}
