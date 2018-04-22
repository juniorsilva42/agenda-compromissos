package com.br.ivaniciojr.agenda;

public class Atributos {

    private String nome;
    private String descricao;
    private String data;
    private Object[] horario;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Object[] getHorario() {
        return horario;
    }

    public void setHorario(Object[] horario) {
        this.horario = horario;
    }
}
