package br.com.senaijandira.feiracultural.view;

import java.util.List;

import br.com.senaijandira.feiracultural.model.Agendamento;

/**
 * Created by sn1041520 on 29/10/2018.
 */

public interface MainView {

    void exibirBarraProgresso();

    void esconderBarraProgresso();

    void preencherLista(List<Agendamento> lstAgendamentos);

}
