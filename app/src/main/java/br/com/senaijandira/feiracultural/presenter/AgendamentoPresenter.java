package br.com.senaijandira.feiracultural.presenter;

import br.com.senaijandira.feiracultural.model.Agendamento;
import br.com.senaijandira.feiracultural.model.ApiResult;
import br.com.senaijandira.feiracultural.service.AgendamentoService;
import br.com.senaijandira.feiracultural.view.AgendamentoView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AgendamentoPresenter {

    AgendamentoView view;
    AgendamentoService service;

    public AgendamentoPresenter(AgendamentoView view, AgendamentoService service){
        this.view = view;
        this.service = service;

    }

    public void agendarApresentacao(Agendamento agendamento){
        service.agendar(agendamento)
                .enqueue(new Callback<ApiResult>() {
                    @Override
                    public void onResponse(Call<ApiResult> call, Response<ApiResult> response) {
                        ApiResult result = response.body();

                        if(result.isSucesso()){
                            view.showMessage("Sucesso", "Agendado com sucesso");


                        }else{
                            view.showMessage("Erro", "Erro ao agendar");
                        }
                    }

                    @Override
                    public void onFailure(Call<ApiResult> call, Throwable t) {
                        t.printStackTrace();
                    }
                });



    }
}
