package com.br.ivaniciojr.agenda;

public class AgendaAtributos {

    /*
    *
    * Arcabouço da estrutura
    *
    * */
    private String nome;
    private String descricao;
    private DataAtributos data;
    private HorarioAtributos horario;

    /*
    *
    * Getters e setters
    *
    * */
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

    public void setData(DataAtributos data) {
        this.data = data;
    }

    public DataAtributos getData() {
        return data;
    }

    public HorarioAtributos getHorario() {
        return horario;
    }

    public void setHorario(HorarioAtributos horario) {
        this.horario = horario;
    }

    /*
     *
     * Exibição
     *
     * */
    public String obtemData () {
        return data.getData();
    }

}
