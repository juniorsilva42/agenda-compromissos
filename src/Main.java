import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import com.br.ivaniciojr.agenda.*;

public class Main {

    private static Scanner in = new Scanner(System.in);
    private static Util util = new Util();

    private static AgendaAtributos agenda = new AgendaAtributos();
    private static DataAtributos data = new DataAtributos();
    private static HorarioAtributos horario = new HorarioAtributos();

    private static SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) throws Exception {

        util.screen();

        // Limpa o buffer do teclado
        in.nextLine();

        agendarCompromisso();

    }

    public static void agendarCompromisso() {
        String titulo, descricao, dataCompromisso;

        System.out.println("Passo 1/3\nTítulo do compromisso:");
        titulo = in.nextLine();
        agenda.setTitulo(titulo);

        System.out.println("Passo 2/3\nDescrição do compromisso:");
        descricao = in.nextLine();
        agenda.setDescricao(descricao);

        System.out.println("Passo 3/3\nData do compromisso:");
        dataCompromisso = in.nextLine();

        // válida
        if (util.verificaData(agenda.obtemData())){
            data.setData(dataCompromisso);
            agenda.setData(data);
        } else {
            System.out.println("OPS! Data inválida!");
        }



    }

    public static void cancelarCompromisso() {
        System.out.println("Vamos cancelar?!");
    }
}
