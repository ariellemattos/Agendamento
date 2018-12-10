package br.com.senaijandira.feiracultural.presenter;

import br.com.senaijandira.feiracultural.model.Agendamento;
import br.com.senaijandira.feiracultural.service.AgendamentoService;
import br.com.senaijandira.feiracultural.view.VizualizarAgendamentoView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VizualizarPresenter {
    AgendamentoService service;
    VizualizarAgendamentoView view;

    public VizualizarPresenter(AgendamentoService service, VizualizarAgendamentoView view) {
        this.service = service;
        this.view = view;
    }



    public void carregarAgendamento(int id){


       service.obterAgendamentoPorId(id).enqueue(new Callback<Agendamento>() {
           @Override
           public void onResponse(Call<Agendamento> call, Response<Agendamento> response) {
               Agendamento agendamento = response.body();
               view.mostrarDadosAgendados(agendamento);
           }

           @Override
           public void onFailure(Call<Agendamento> call, Throwable t) {
                t.printStackTrace();
           }
       });
    }
}
