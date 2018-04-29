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
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Hoje, "+this.exibeData());
        System.out.println("=====================================================================\n");
        System.out.println("O que deseja fazer? (digite uma opção correspondente)\n");
        System.out.println("1. Agendar um compromisso\n2. Cancelar um compromisso\n3. Ver meus compromissos");
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

    public boolean verificaData (String data){
        // Referência a https://docs.oracle.com/javase/tutorial/datetime/iso/format.html
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate d = LocalDate.parse(data, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static boolean validaHora (String horario) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        // desadapto a classe para números muito grandes, isso anula a possibilidade de colocar um valor como "25h" e ele somar e considerar como 01h00 da manhã, por exemplo
        sdf.setLenient(false);
        try{
            sdf.parse(horario);
        }catch(ParseException e){
            return false;
        }
        return true;
    }

}
