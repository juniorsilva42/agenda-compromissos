package com.br.ivaniciojr.agenda;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Util {

    public void screen(){
        System.out.println("=====================================================================");
        System.out.println("MINHA AGENDA\n");
        System.out.println("Hoje, "+this.exibeData());
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
                s.append(" às ");

            s.append(dataAtual[i].format(data));

            i++;
        }

        return s.toString();
    }

}
