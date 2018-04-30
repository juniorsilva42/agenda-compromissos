package com.br.ivaniciojr.agenda;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Util {

    public void screen(){
        System.out.println("=====================================================================");
        System.out.println("MINHA AGENDA");
        System.out.println("Hoje, "+this.exibeData());
        System.out.println("---------------------------------------------------------------------");
        System.out.println("O que deseja fazer? (digite uma opção correspondente)\n");
        System.out.println("1. Agendar um compromisso\n2. Cancelar um compromisso\n3. Ver meus compromissos");
        System.out.println("=====================================================================\n");
    }

    public String exibeData (){

        Date data = new Date();
        StringBuilder s = new StringBuilder();

        SimpleDateFormat[] dataAtual = new SimpleDateFormat[2];
        dataAtual[0] = new SimpleDateFormat("dd/MM/yyyy");
        dataAtual[1] = new SimpleDateFormat("HH:mm");

        int i = 0;
        while (i < 2) {

            if (dataAtual.length-1 == i)
                s.append(", ");

            s.append(dataAtual[i].format(data));
            i++;
        }

        return s.toString();
    }

    public boolean validaData (String data){
        // Referência a https://docs.oracle.com/javase/tutorial/datetime/iso/format.html
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate d = LocalDate.parse(data, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static boolean validaString (String s){
        if(s == null || s.isEmpty())
            return false;

        return true;
    }

    public static boolean validaHorario (String horario) {

        String[] arranjo = horario.split(":");
        int tamanhoArranjo = arranjo.length;

        int horas = Integer.parseInt(arranjo[0]);
        int minutos = 0;

        if (tamanhoArranjo >= 2) minutos = Integer.parseInt(arranjo[1]);

        // Quebro a string em um Array de carateres
        char[] arranjoQuebrado = String.valueOf(horario).toCharArray();
        int contador = 0;

        /*
         *
         * Percorro todos os caracteres da string e passo um a um mediante a variável itensHorario, com isso, posso verificar se o horário é do tipo 00:00, com a ajuda de uma var auxiliar: "contador".
         *
         *
         */
        for (char itensHorario: arranjoQuebrado) {

            if (itensHorario == ':') {
                contador++;
                continue;
            }

            if (!Character.isDigit(itensHorario))
                return false;
        }

        if (contador < 1 || contador >= 3)
            return false;
        else if (horas < 0 || horas > 23)
            return false;
        else if (minutos < 0 || minutos > 59)
            return false;

        return true;
    }

}
