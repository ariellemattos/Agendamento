package br.com.senaijandira.feiracultural.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import br.com.senaijandira.feiracultural.R;
import br.com.senaijandira.feiracultural.model.Agendamento;
import br.com.senaijandira.feiracultural.presenter.VizualizarPresenter;
import br.com.senaijandira.feiracultural.service.ServiceFactory;
import br.com.senaijandira.feiracultural.view.VizualizarAgendamentoView;

public class VizualizarActivity extends AppCompatActivity implements VizualizarAgendamentoView {
    TextView txtTurma, txtSala, txtHorario, txtApresentacao, txtClasse;

    VizualizarPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vizualizar);

        txtTurma = findViewById(R.id.txtTurma);
        txtHorario = findViewById(R.id.txtHorario);
        txtApresentacao = findViewById(R.id.txtApresentacao);
        txtSala = findViewById(R.id.txtSala);
        txtClasse = findViewById(R.id.txtClasse);

        presenter= new VizualizarPresenter(ServiceFactory.create(), this );


        int idAgendamento = getIntent().getIntExtra("idAgendamento", 0);
        Log.d("ID_AGENDAMENTO", idAgendamento+"");

        presenter.carregarAgendamento(idAgendamento);



    }

    @Override
    public void mostrarDadosAgendados(Agendamento agendamento){
        txtTurma.setText(agendamento.getTurma());
        txtSala.setText(agendamento.getSala());
        txtHorario.setText(agendamento.getHorario());
        txtApresentacao.setText(agendamento.getApresentacao());
        txtClasse.setText(agendamento.getClasse());

    }

}
