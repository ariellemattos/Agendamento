package br.com.senaijandira.feiracultural.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.List;

import br.com.senaijandira.feiracultural.R;
import br.com.senaijandira.feiracultural.adapter.AgendamentoAdapter;
import br.com.senaijandira.feiracultural.model.Agendamento;
import br.com.senaijandira.feiracultural.presenter.MainPresenter;
import br.com.senaijandira.feiracultural.service.ServiceFactory;
import br.com.senaijandira.feiracultural.view.MainView;

public class MainActivity extends AppCompatActivity implements MainView, AdapterView.OnItemClickListener{
    ListView listView;

    AgendamentoAdapter adapter;

    ProgressBar progressBar;

    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progressBar);

        listView = findViewById(R.id.listView);

        listView.setOnItemClickListener(this);

        //instanciar o Adapter
        adapter = new AgendamentoAdapter(this);

        //plugar o adapter na lista
        listView.setAdapter(adapter);

        //config presenter
        presenter = new MainPresenter(this,
                ServiceFactory.create());

    }

    @Override
    public void onResume() {
        super.onResume();

        presenter.carregarAgendamentos();

    }

    @Override
    public void exibirBarraProgresso(){
        progressBar.setVisibility(View.VISIBLE);
        listView.setVisibility(View.GONE);
    }

    @Override
    public void esconderBarraProgresso(){
        progressBar.setVisibility(View.GONE);
        listView.setVisibility(View.VISIBLE);
    }

    @Override
    public void preencherLista(List<Agendamento> lstAgendamento){
        adapter.clear();
        adapter.addAll(lstAgendamento);
    }

    public void abrirAgendamento(View view) {
        //Abrindo tela de cadastro
        startActivity(new Intent(this, AgendamentoActivity.class));
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        //Identificar o aluno clicado pela posicao da lista
        Agendamento agendamentoClicado = adapter.getItem(position);

        //Abrir a tela
        Intent intent = new Intent(this, VizualizarActivity.class);
        intent.putExtra("idAgendamento", agendamentoClicado.getId());
        startActivity(intent);

    }


}
