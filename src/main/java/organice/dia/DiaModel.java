package organice.dia;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

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

    @Column(name = "dt_data")
    @Temporal(TemporalType.DATE)
    private Date data;

    @Column(name = "dt_data_criacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data_criacao;

    @Column(name = "tx_dia_da_semana")
    private String dia_da_semana;

    @Column(name = "tx_descricao")
    private String descricao;

    @Column(name = "id_usuario")
    private String id_usuario;

    @OneToMany(mappedBy = "dia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<LembreteModel> lembretes;

    public DiaModel(DiaIn diaIn) {
        // Neste ponto, você precisaria converter de DiaIn para DiaModel
        // Exemplo simples, supondo DiaIn tenha métodos adequados
        this.data = diaIn.dia();
        this.descricao = diaIn.descricao();
        // Configurar campos como data_criacao e dia_da_semana conforme necessário
    } 

    // Método para converter de DiaModel para DiaOut não é diretamente necessário aqui,
    // pois você normalmente faz essa conversão no nível do serviço ou do controller.
}
