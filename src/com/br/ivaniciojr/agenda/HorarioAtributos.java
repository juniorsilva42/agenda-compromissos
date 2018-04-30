package com.br.ivaniciojr.agenda;

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
    public String toString (){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < this.obtemTamanho(); i++){
            if (this.horario[i] != null)
                s.append(this.horario[i]+"\n");
        }

        return s.toString();
    }
}
