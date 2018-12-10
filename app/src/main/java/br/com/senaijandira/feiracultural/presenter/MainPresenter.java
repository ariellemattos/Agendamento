package br.com.senaijandira.feiracultural.presenter;

import android.util.Log;

import java.util.List;

import br.com.senaijandira.feiracultural.model.Agendamento;
import br.com.senaijandira.feiracultural.service.AgendamentoService;
import br.com.senaijandira.feiracultural.view.MainView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sn1041520 on 29/10/2018.
 */

public class MainPresenter {

    MainView mainView;
    AgendamentoService service;

    public MainPresenter(MainView mainView, AgendamentoService service){
        this.mainView = mainView;
        this.service = service;
    }

    public void carregarAgendamentos() {

        //Objeto de chamada a API de alunos
        Call<List<Agendamento>> call = service.obterAgendamentos();

        mainView.exibirBarraProgresso();

        //Efetuar a chamada a API
        call.enqueue(new Callback<List<Agendamento>>() {
            @Override
            public void onResponse(Call<List<Agendamento>> call, Response<List<Agendamento>> response) {

                //Lista de alunos retornada pelo servidor
                List<Agendamento> agendamentos = response.body();

                //Exibe os alunos na tela
                mainView.preencherLista(agendamentos);

                mainView.esconderBarraProgresso();
            }

            @Override
            public void onFailure(Call<List<Agendamento>> call, Throwable t) {
                Log.e("ERRO_API", t.getMessage());
            }
        });

    }

}
