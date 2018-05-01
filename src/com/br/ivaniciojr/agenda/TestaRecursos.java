package com.br.ivaniciojr.agenda;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Logger;

public class TestaRecursos {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat formatador = new SimpleDateFormat("HH:mm");

        String[] horarioCompromissoAgora = { "10:30", "11:30" };
        String[] listaDeHorarios = { "11:30", "12:30", "10:11", "15:30"};


        for (int i = 0; i < horarioCompromissoAgora.length; i++) {

        }

        Date ha = formatador.parse(horarioCompromissoAgora[0]);
        Date hb = formatador.parse(horarioCompromissoAgora[1]);

        long hinicial =  ha.getTime();
        long hfinal = hb.getTime();

        if (hinicial == hfinal){
            System.out.println("Você n pode iniciar uma tarefa em um determinado horário e terminar nesse mesmo determinado horário.");
        }

        Date dAgora = new Date();
        Date dMin = formatador.parse("10:30");
        Date dMax = formatador.parse("9:30");

        if ((dAgora.getTime() > dMin.getTime()) && (dAgora.getTime() < dMax.getTime())){

        }
        else
        {

        }
    }


}
