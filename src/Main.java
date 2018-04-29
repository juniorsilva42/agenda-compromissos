import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.br.ivaniciojr.agenda.*;

public class Main {

    private static Scanner in = new Scanner(System.in);
    private static Util util = new Util();

    public static void main(String[] args) {

        AgendaAtributos agenda = new AgendaAtributos();
        DataAtributos data = new DataAtributos();
        HorarioAtributos horario = new HorarioAtributos();

        util.screen();

        data.setData("29/09/1998");
        agenda.setData(data);

        System.out.println(agenda.obtemData());

        /*
        *
        * Aqui eu exibo o menu inicial com as opções de: agendar, cancelar e verificar um compromisso;

        * Uma vez selecionado a opção agendamento, o sistema exibe as entradas de texto para inserir um nome, a descrição, a data e o horário de inicio e fim;

        * Em cancelar, ele exibe os compromissos já agendados com opções correspondentes para remover cada um;

        * Ver os compromissos do dia

        * Verificar choque entre horarios do compromisso. Como meu horário está definido na estrutura como um vetor, posso utilizar o mesmo recurso no algoritmo do balanceamento de chaves para verificar item por item. Pode não ser uma solução inovadora e eficiente por ser em escala linear de processamento, mas acredito que possa funcionar.

        * */
    }
}
