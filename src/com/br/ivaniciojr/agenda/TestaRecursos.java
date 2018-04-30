package com.br.ivaniciojr.agenda;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestaRecursos {

    public static void main(String[] args) {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(df.format(date));
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
