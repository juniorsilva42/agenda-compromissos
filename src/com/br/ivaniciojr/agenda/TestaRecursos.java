package com.br.ivaniciojr.agenda;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestaRecursos {

    public static void main(String[] args) {

        String horario = "08:30:00:100";

        System.out.println(validaHora(horario));
    }

    public static boolean validaString (String s){
        if(s == null || s.isEmpty())
            return false;

        return true;
    }

    public static boolean validaHora (String horario){

        String[] arranjo = horario.split(":");
        int horas = Integer.parseInt(arranjo[0]);
        int minutos = Integer.parseInt(arranjo[1]);

        // Quebro a string em um Array de carateres
        char[] arranjoQuebrado = String.valueOf(horario).toCharArray();
        int contador = 0;

        // Percorro todos os caracteres da string e passo um a um mediante a variável itensHorario
        // Com isso, posso verificar se o horário é do tipo 00:00, com a ajuda de uma var auxiliar: contador.

        for (int i = 0; i < arranjo.length; i++){
            String teste = arranjo[i];
        }

        for (char itensHorario: arranjoQuebrado) {
            if (itensHorario == ':')
                contador++;
        }

        if (contador < 1 || contador >= 3){
            return false;
        } else if (horas < 0 || horas > 23){
            return false;
        } else if (minutos < 0 || minutos > 59){
            return false;
        }

        return true;
    }

    public boolean ehInteiro (String s) {
        char[] c = s.toCharArray();
        boolean d = true;

        for (int i = 0; i < c.length; i++) {
            // verifica se o char não é um dígito
            if ( !Character.isDigit( c[ i ] ) ) {
                d = false;
                break;
            }
    }
    return d;
}

    public static boolean validaHora2 (String horario) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        sdf.setLenient(false);
        try{
            sdf.parse(horario);
        }catch(ParseException e){
            return false;
        }
        return true;
    }
}
