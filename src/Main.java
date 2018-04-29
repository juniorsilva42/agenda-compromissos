import java.util.*;

import com.br.ivaniciojr.agenda.*;

public class Main {

    private static Scanner in = new Scanner(System.in);
    private static Util util = new Util();

    private static AgendaAtributos agenda = new AgendaAtributos();
    private static DataAtributos data = new DataAtributos();
    private static HorarioAtributos horario = new HorarioAtributos();

    public static void main(String[] args) {

        util.screen();
        in.nextLine();

        /*
        *
        * Dados do compromisso para povoar suas respectivas estruturas
        *
        * titulo, descrição e dataCompromisso, recebem seus respectivos valores mediante o usuário para povoar toda a estrutura;
        * horarioCompromisso[]: vetor responsável por armazenar o horário de inicio e fim do compromisso;
        *
        * */
        String titulo, descricao, dataCompromisso;
        String[] horarioCompromisso = new String[2];

        List<AgendaAtributos> lista = new ArrayList<AgendaAtributos>();

        /*
         *
         * Povoando os dados do compromisso
         * */
        System.out.println("Passo 1/4\nTítulo do compromisso:");
        titulo = in.nextLine();
        agenda.setTitulo(titulo);

        System.out.println("\nPasso 2/4\nDescrição do compromisso:");
        descricao = in.nextLine();
        agenda.setDescricao(descricao);

        System.out.println("\nPasso 3/4\nData do compromisso:");
        dataCompromisso = in.nextLine();

        if (util.verificaData(dataCompromisso)){
            data.setData(dataCompromisso);
            agenda.setData(data);
        } else {
            data.setData(null);
            agenda.setData(data);
        }

        System.out.println("\nPasso 4/4\nHorário de ínicio e fim: (no formato 00h00)");

        for (int i = 0; i < horarioCompromisso.length; i++){
            horarioCompromisso[i] = in.nextLine();
            horario.setHorario(horarioCompromisso);
            agenda.setHorario(horario);
        }

        lista.add(agenda);
        exibeCompromissos(Collections.singletonList(agenda));
    }

    public static void exibeCompromissos (List<AgendaAtributos> items){
        int i, tamanhoLista = items.size();

        for (i = 0; i < tamanhoLista; i++) {
            AgendaAtributos agenda = items.get(i);
            System.out.println("\nTítulo: "+agenda.getTitulo());
            System.out.println("Descrição: "+agenda.getDescricao());
            System.out.println("Data: "+agenda.obtemData());
            System.out.println("Horário: "+agenda.getHorario().toString());
            System.out.println("-----------------------------------------------");
        }
    }
}
