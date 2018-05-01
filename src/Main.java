import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

import com.br.ivaniciojr.agenda.*;

public class Main {

    private static Scanner in = new Scanner(System.in);
    private static Util util = new Util();

    private static List<AgendaAtributos> lista = new ArrayList<>();

    public static void main(String[] args) {

        int opcao;

        util.screen();

        do {

            System.out.println("\nDigite uma opção correspondente acima: ");
            opcao = in.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("\n------------------------------------------");
                    System.out.println("\nADICIONAR UM COMPROMISSO");
                    System.out.println("------------------------------------------");

                    // Limpa o buffer do teclado
                    util.limpaBuffer(in);
                    addCompromisso();
                    break;

                case 2:
                    System.out.println("Cancelar");
                    break;

                case 3:
                    exibeCompromissos();
                    break;

                case 4:
                    System.out.println("Saindo...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 4);

    }

    public static void addCompromisso () {

        AgendaAtributos agenda = new AgendaAtributos();
        DataAtributos data = new DataAtributos();
        HorarioAtributos horario = new HorarioAtributos();

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

        Date date = new Date();

        /*
         *
         * Povoando os dados do compromisso
         *
         * */
        System.out.println("Passo 1/4\nTítulo do compromisso:");
        titulo = in.nextLine();

        if (util.validaString(titulo))
            agenda.setTitulo(titulo);

        System.out.println("\nPasso 2/4\nDescrição do compromisso:");
        descricao = in.nextLine();

        if (util.validaString(descricao))
            agenda.setDescricao(descricao);

        /*
         *
         * Lê a data no formato dd/mm/yyyy
         *
         * */
        System.out.println("\nPasso 3/4\nData do compromisso: (deixar vazio para caso queira utilizar a data atual)");
        dataCompromisso = in.nextLine();

        /*
         *
         * Caso a data seja vazia, integra, por default, a data atual à estrutura, caso contrário, cai no bloco do else e apenas verifica se a data passada pelo usuário lida em dataCompromisso, entra nos parâmetros de validação, caso seja verdadeiro, integra à estrutura, caso não, integra o valor null;
         *
         *
         * */
        if (!(util.validaString(dataCompromisso))) {
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            data.setData(df.format(date));
            agenda.setData(data);
        } else {
            if (util.validaData(dataCompromisso)) {
                data.setData(dataCompromisso);
                agenda.setData(data);
            } else {
                data.setData(null);
                agenda.setData(data);
            }
        }

        /*
         *
         * Lê um vetor de horário, onde a a primeira opção é o tempo inicial do compromisso e a segunda opção, o tempo final
         *
         * */
        System.out.println("\nPasso 4/4\nHorário de ínicio e fim: (no formato 00:00)");

        // Percorre o vetor do horário
        for (int i = 0; i < horarioCompromisso.length; i++) {
            // faz a leitura a partir da entrada do usuário
            horarioCompromisso[i] = in.nextLine();


            /*
             *
             * Valida o horário utilizando nossa função helper de validação, caso true, adiciona o horário à estrutra, caso false, adiciona null à estrutura.
             *
             * */
            if (util.validaHorario(horarioCompromisso[i])) {
                horario.setHorario(horarioCompromisso);
                agenda.setHorario(horario);
            } else {
                horario.setHorario(null);
                agenda.setHorario(horario);
            }
        }

        /*
         *
         * Persiste o compromisso à lista
         *
         * */
        if (lista.add(agenda))
            System.out.println("\nCompromisso adicionado com sucesso!");
        else
            System.out.println("Erro ao adicionar um novo compromisso!");

        exibeUltimoCompromisso();
    }

    public static void exibeCompromissos (){

        int tamanhoLista = lista.size();

        /*
        *
        * Verifica a existência de um compromisso na lista, caso não exista, oferece a opção de criar um.
        *
        **/
        if (tamanhoLista == 0){
            System.out.println("\nAinda não há compromissos.");
            System.out.println("Deseja adicionar um novo compromisso? (s/n)");
            String opt;

            util.limpaBuffer(in);
            opt = in.nextLine();

            System.out.print("\n");

            if (opt.equalsIgnoreCase("s"))
                addCompromisso();
            else
                System.out.println("Saindo...");
                System.exit(0);

        } else {
            for (int i = 0; i < lista.size(); i++) {
                AgendaAtributos agenda = lista.get(i);
                System.out.println("\nTítulo: "+agenda.getTitulo());
                System.out.println("Descrição: "+agenda.getDescricao());
                System.out.println("Data: "+agenda.obtemData());
                System.out.println("Horário: "+agenda.getHorario().toString());
                System.out.println("-----------------------------------------------");
            }
        }
    }

    public static void exibeUltimoCompromisso (){
        int tamanhoLista = lista.size()-1;
        AgendaAtributos agenda = lista.get(tamanhoLista);

        System.out.print("\n|----------------------------------------------------------|");
        System.out.println("\n|SEU COMPROMISSO PARA O DIA "+agenda.obtemData());
        System.out.print("\n|                                                          |");
        System.out.println("------------------------------------------");
        System.out.println("Titulo do último compromisso: "+lista.get(lista.size()-1).getTitulo());
    }

    public static void removeCompromisso (int indice){
        //int i, tamanhoLista = itens.size();

        //System.out.println(itens.get(indice).getTitulo());
    }
}
