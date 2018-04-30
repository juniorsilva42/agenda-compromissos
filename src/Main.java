import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
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

        addCompromisso();
    }

    public static void addCompromisso (){

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
        Date date = new Date();

        /*
         *
         * Povoando os dados do compromisso
         * */
        System.out.println("Passo 1/4\nTítulo do compromisso:");
        titulo = in.nextLine();

        if (util.validaString(titulo))
            agenda.setTitulo(titulo);

        System.out.println("\nPasso 2/4\nDescrição do compromisso:");
        descricao = in.nextLine();

        if (util.validaString(descricao))
            agenda.setDescricao(descricao);


        System.out.println("\nPasso 3/4\nData do compromisso: (deixar vazio para caso queira utilizar a data atual)");
        dataCompromisso = in.nextLine();

        /*
         *
         * Caso a data seja vazia, integra, por default, a data atual à estrutura, caso contrário, cai no bloco do else e apenas verifica se a data passada pelo usuário lida em dataCompromisso, entra nos parâmetros de validação, caso seja verdadeiro, integra à estrutura, caso não, integra o valor null;
         *
         *
         * */
        if (!(util.validaString(dataCompromisso))){
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            data.setData(df.format(date));
            agenda.setData(data);
        } else {
            if (util.validaData(dataCompromisso)){
                data.setData(dataCompromisso);
                agenda.setData(data);
            } else {
                data.setData(null);
                agenda.setData(data);
            }
        }

        System.out.println("\nPasso 4/4\nHorário de ínicio e fim: (no formato 00:00)");

        for (int i = 0; i < horarioCompromisso.length; i++){
            horarioCompromisso[i] = in.nextLine();

            if (util.validaHorario(horarioCompromisso[i])){
                horario.setHorario(horarioCompromisso);
                agenda.setHorario(horario);
            } else {
                horario.setHorario(null);
                agenda.setHorario(horario);
            }
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
