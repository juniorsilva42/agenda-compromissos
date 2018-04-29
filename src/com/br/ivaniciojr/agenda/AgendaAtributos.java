package com.br.ivaniciojr.agenda;

public class AgendaAtributos {

    /*
    *
    * Arcabouço da estrutura
    *
    * */
    private String titulo;
    private String descricao;
    private DataAtributos data;
    private HorarioAtributos horario;

    /*
    *
    * Getters e setters
    *
    * */
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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
