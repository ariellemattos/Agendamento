package br.com.senaijandira.feiracultural.service;

import java.util.List;

import br.com.senaijandira.feiracultural.model.Agendamento;
import br.com.senaijandira.feiracultural.model.ApiResult;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AgendamentoService {

    String URL_BASE = "http://10.0.2.2:5001/";

    @GET("/agendamentos")
    Call<List<Agendamento>> obterAgendamentos();

    @POST("/novo")
    Call<ApiResult> agendar (@Body Agendamento agendamento);

    @GET("/agendamento/{id}")
    Call<Agendamento> obterAgendamentoPorId(@Path("id") int id);

}
