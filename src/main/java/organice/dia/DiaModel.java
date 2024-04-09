package organice.dia;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import organice.dia.Dia.DiaBuilder;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "dia")
@EqualsAndHashCode(of = "id")
@Builder @Getter @Setter @Accessors(chain = true, fluent = true)
@NoArgsConstructor @AllArgsConstructor
public class DiaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Alterado para demonstração
    @Column(name = "id_dia")
    private String id;

    @Column(name = "dia_data")
    @Temporal(TemporalType.DATE)
    private Date data;

    @Column(name = "dia_data_criacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data_criacao;

    @Column(name = "dia_dia_da_semana")
    private String dia_da_semana;

    @Column(name = "dia_descricao")
    private String descricao;

    @Column(name = "dia_id_usuario")
    private String id_usuario;

    public DiaModel(Dia dia) {
        // Neste ponto, você precisaria converter de DiaIn para DiaModel
        // Exemplo simples, supondo DiaIn tenha métodos adequados
        this.data = dia.data();
        this.descricao = dia.descricao();
        // Configurar campos como data_criacao e dia_da_semana conforme necessário
    } 

    public  Dia to(){
        return Dia.builder()
            .id(id)
            .data(data)
            .data_criacao(data_criacao)
            .dia_da_semana(dia_da_semana)
            .descricao(descricao)
            .id_usuario(id_usuario)
            .build();
    }

    // Método para converter de DiaModel para DiaOut não é diretamente necessário aqui,
    // pois você normalmente faz essa conversão no nível do serviço ou do controller.
}
