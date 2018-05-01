package com.br.ivaniciojr.agenda;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestaRecursos {

    public static void main(String[] args) {
        System.out.print("\n|-----------------------------------------------------------|");
        System.out.println("\n|\tNovo compromisso em 24/04/2018 das 10:30 às 11:30\t\t|");
        System.out.print("|-----------------------------------------------------------|\n");
        System.out.print("|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|\n");
        System.out.print("|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|\n");
        System.out.print("|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|\n");
        System.out.println("|-----------------------------------------------------------|");
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
