import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

import com.br.ivaniciojr.agenda.*;

public class Main {

    private static Scanner in = new Scanner(System.in);
    private static Date date = new Date();

    private static List<AgendaAtributos> lista = new ArrayList<>();
    private static int tamanhoLista;

    public static void main(String[] args) {

        Util.screen();

        int opcao;

        /*
         *
         * Executa este laço enquanto a ooção for diferente de 4: sair do sistema.
         *
         * */
        do {
        	
            System.out.println("\nDigite uma opção correspondente acima: ");
            opcao = in.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("\n------------------------------------------");
                    System.out.println("\nADICIONAR UM COMPROMISSO");
                    System.out.println("------------------------------------------");

                    // Limpa o buffer do teclado
                    Util.limpaBuffer(in);
                    addCompromisso();
                    break;

                case 2:
                
                    Util.limpaBuffer(in);

                    /*
                    *
                    * Verifica se há compromissos
                    * */
                	if (!verificaCompromissos()) {
                		System.out.println("\nAinda não há compromissos na sua agenda.\nAdicione um digitando a opção correspondente no menu (1).\n");
                	} else {
                        /*
                         *
                         * Exibe apenas o titulo de cada compromisso seguido de sua opção numérica.
                         * */
                    	exibeCompromissosLite();

                    	/*
                    	*
                    	* Note que, visualmente, é exibido uma lista númerica crescente com opções para o usuário escolher qual compromisso quer deletar, mas, por trás dos panos, é decrementado uma unidade da opção a qual ele passa na opção, para assim poder trabalhar com coerência na manipulação dos índices do array e, posteriomente, passar para o argumento da função de remover um compromisso.
                    	*
                    	* */
                        System.out.println("Qual compromisso deseja cancelar?");
                        opcao = in.nextInt();
                        opcao = opcao - 1;

                        removeCompromisso(opcao);	
                	}
                	
                    break;

                case 3:
                    exibeCompromissos();
                    break;

                case 4:
                    System.out.println("\nSaindo...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("\nOpção inválida!");
            }

        } while (opcao != 4);
    }

    public static void addCompromisso () {
        /*
         *
         * Cria uma instância dos 3 objetos da estrutura para cada compromisso adicionado
         *
         * */
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

        // Variáveis de controle de erros
        boolean validadeDeHorario = true;
        boolean validadeDeData = true;

        /*
         *
         * Povoando os dados do compromisso
         *
         * */
        System.out.println("Passo 1/4\nTítulo do compromisso:");
        titulo = in.nextLine();

        if (Util.validaString(titulo))
            agenda.setTitulo(titulo);

        System.out.println("\nPasso 2/4\nDescrição do compromisso:");
        descricao = in.nextLine();

        if (Util.validaString(descricao))
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
         * */
        if (!(Util.validaString(dataCompromisso))) {
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            data.setData(df.format(date));
            agenda.setData(data);
        } else {
            if (Util.validaData(dataCompromisso)) {
                data.setData(dataCompromisso);
                agenda.setData(data);
            } else
                validadeDeData = false;
        }

        /*
         *
         * Lê um vetor de horário, onde a a primeira opção é o tempo inicial do compromisso e a segunda opção, o tempo final
         *
         * */
        System.out.println("\nPasso 4/4\nHorário de ínicio e fim: (no formato 00:00)");

        // Percorre o vetor dos horários
        for (int i = 0; i < 2; i++) {
            // faz a leitura a partir da entrada do usuário
            horarioCompromisso[i] = in.nextLine();

            /*
             *
             * Valida o horário utilizando nossa função helper de validação, caso true, adiciona o horário à estrutra, caso false, adiciona null.
             *
             * */
            if (Util.validaHorario(horarioCompromisso[i])) {
                horario.setHorario(horarioCompromisso);
                agenda.setHorario(horario);
            } else
                 validadeDeHorario = false;
        }

        // Valida de forma uniciada, o formato de entrada da data e do horário
        if (!validadeDeData){
            System.out.println("\nNão foi possível adicionar seu compromisso.\nHora inválida!");
        } else if (!validadeDeHorario) {
            System.out.println("\nNão foi possível adicionar seu compromisso.\nHorário inválido!");
        } else {
            /*
             *
             * Persiste o compromisso à lista
             *
             * */
            if (lista.add(agenda)) {
                System.out.print("\n-----------------------------------------------------------------------");
                System.out.println("\nOK! \""+agenda.getTitulo()+"\" foi agendado para "+agenda.obtemData()+""+agenda.getHorario().toString()+"");
                System.out.println("-----------------------------------------------------------------------");
            } else {
                System.out.println("Erro ao adicionar um novo compromisso!");
            }
        }
    }

    public static void exibeCompromissos (){

        /*
        *
        * Verifica a existência de um compromisso na lista, caso não exista, oferece a opção de criar um.
        *
        **/
        if (!verificaCompromissos()){
            System.out.println("\nAinda não há compromissos na sua agenda.\nAdicione um digitando a opção correspondente no menu (1).\n");

        } else {
            System.out.println("\nSEUS COMPROMISSOS");
            System.out.print("-------------------------------------------------------------------------------\n");
            for (int i = 0; i < lista.size(); i++) {
                AgendaAtributos agenda = lista.get(i);
                System.out.println("Título: "+agenda.getTitulo());
                System.out.println("Descrição: "+agenda.getDescricao());
                System.out.println("Data: "+agenda.obtemData());
                System.out.println("Horário:"+agenda.getHorario().toString());
                System.out.println("_______________________________________________________________________________\n");
            }
        }
    }

    /*
     *
     * Remove um compromisso da lista
     *
     * @return: void
     * @params: int indice
     * @annotations: remove o item da lista pelo índice informado pelo usuário;
     *
     * */
    public static void removeCompromisso (int indice){
        // recalculando o tamanho da lista
        tamanhoLista = lista.size();

        System.out.println("\nRemovendo o compromisso: "+lista.get(indice).getTitulo());

        // verifica a existênca da posição
        if (indice > tamanhoLista-1)
            throw new IllegalArgumentException("\nPosição inválida!");
        else {
        	lista.remove(indice);
        	System.out.println("Compromisso removido com sucesso!");
        }
    }
    
    public static void exibeCompromissosLite() {
    	System.out.println("\nSEUS COMPROMISSOS");
    	System.out.print("-------------------------------------------------------------------------------\n");
        for (int i = 0; i < lista.size(); i++) {
            AgendaAtributos agenda = lista.get(i);
            System.out.println((i+1)+". "+agenda.getTitulo()+" - "+agenda.obtemData()+agenda.getHorario().toString());
            System.out.println("_______________________________________________________________________________\n");
        }
    }

    /*
    *
    * Verifica se há compromissos na lista
    *
    * @return: boolean
    * @annotations: retorna false caso não exista nada na lista, e true caso a condição não seja satisfeita e haja prosseguimento no bloco
    *
    * */
    public static boolean verificaCompromissos () {

    	if (lista.size() == 0)
    		return false;
    	
    	return true;
    }

    public static void retornaTodasOsHorarios (){

        for (int i = 0; i < lista.size(); i++) {
            AgendaAtributos agenda = lista.get(i);

            System.out.println(agenda.getHorario().relacaoHorarios());
        }
    }
}
