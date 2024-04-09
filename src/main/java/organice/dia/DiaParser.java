package organice.dia;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DiaParser {

    // Converte DiaIn para Dia
    public static Dia toDia(DiaIn diaIn) {
        // Supondo que a entidade Dia tenha um método builder() similar ao Account
        return Dia.builder()
                .data(diaIn.dia())
                .descricao(diaIn.descricao())
                // Define outros campos necessários aqui, como ID do usuário se aplicável
                .data_criacao(new java.util.Date()) // Exemplo: data de criação definida como agora
                .dia_da_semana(calculaDiaDaSemana(diaIn.dia())) // Exemplo de cálculo do dia da semana
                .build();
    }

    // Converte Dia para DiaOut
    public static DiaOut toDiaOut(Dia dia) {
        // Supondo que a classe DiaOut tenha um método builder()
        return DiaOut.builder()
                .dia(dia.data())
                .data_criacao(dia.data_criacao())
                .dia_da_semana(dia.dia_da_semana())
                .descricao(dia.descricao())
                .build();
    }

    // Método auxiliar para calcular o dia da semana a partir de uma data
    public static String calculaDiaDaSemana(Date data) {
        Calendar c = Calendar.getInstance();
        c.setTime(data);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        // Substitua esta parte pela sua lógica de conversão preferida
        return switch (dayOfWeek) {
            case Calendar.SUNDAY -> "Domingo";
            case Calendar.MONDAY -> "Segunda-feira";
            case Calendar.TUESDAY -> "Terça-feira";
            case Calendar.WEDNESDAY -> "Quarta-feira";
            case Calendar.THURSDAY -> "Quinta-feira";
            case Calendar.FRIDAY -> "Sexta-feira";
            case Calendar.SATURDAY -> "Sábado";
            default -> "UNKNOWN";
        };
    }
}
