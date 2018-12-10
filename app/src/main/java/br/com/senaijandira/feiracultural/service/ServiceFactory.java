package br.com.senaijandira.feiracultural.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceFactory {

    public static AgendamentoService create(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AgendamentoService.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(AgendamentoService.class);
    }
}
