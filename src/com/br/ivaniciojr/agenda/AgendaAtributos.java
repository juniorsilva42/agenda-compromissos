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
     * Método para deixar enxuta a exibição da data, isso evita ter que ficar repetindo
       o uso de agenda.getData().getData(), isso deixava o cód. confuso, com isso, uso apenas
       agenda.obtemData(), onde por trás, este método opera o getter respectivo
     *
     * */
    public String obtemData () {
        return data.getData();
    }

}
