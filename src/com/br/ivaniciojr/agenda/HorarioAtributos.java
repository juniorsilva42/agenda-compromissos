package com.br.ivaniciojr.agenda;

import java.util.ArrayList;
import java.util.List;

public class HorarioAtributos {

    private String[] horario;

    public String[] getHorario() {
        return horario;
    }

    public void setHorario(String[] horario) {
        this.horario = horario;
    }

    public int obtemTamanho (){
        return this.horario.length;
    }

    @Override
    public String toString () {
        StringBuilder s = new StringBuilder();

        s.append(" das "+this.horario[0]+" às "+this.horario[1]);

        return s.toString();
    }

    public String relacaoHorarios (){
        List<String> relacaoDeHorarios = new ArrayList<>();

        StringBuilder s = new StringBuilder();

        for (int i = 0; i < this.obtemTamanho(); i++){
            relacaoDeHorarios.add(this.horario[i]);

            s.append(relacaoDeHorarios.get(i));
        }
        return s.toString();
    }
}
