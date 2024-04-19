package organice.dia;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DiaParser {

    public static Dia toDia(DiaIn diaIn) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            return Dia.builder()
                    .data(diaIn.dia())
                    .descricao(diaIn.descricao())
                    .data_criacao(formatter.format(new Date()))
                    .dia_da_semana(calculaDiaDaSemana(formatter.parse(diaIn.dia()))) 
                    .build();
        } catch (Exception e) {
            System.out.println("Deu Pau no Dia In");
            return null;
        }
    }

    public static DiaOut toDiaOut(Dia dia) {
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
