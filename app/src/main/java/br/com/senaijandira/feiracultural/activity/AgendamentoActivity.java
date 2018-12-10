package br.com.senaijandira.feiracultural.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import br.com.senaijandira.feiracultural.R;
import br.com.senaijandira.feiracultural.model.Agendamento;
import br.com.senaijandira.feiracultural.presenter.AgendamentoPresenter;
import br.com.senaijandira.feiracultural.service.AgendamentoService;
import br.com.senaijandira.feiracultural.service.ServiceFactory;
import br.com.senaijandira.feiracultural.view.AgendamentoView;

public class AgendamentoActivity extends AppCompatActivity implements AgendamentoView {
    EditText txtTurma, txtSala, txtHorario, txtApresentacao;

    Spinner spinner_classe;

    AgendamentoPresenter presenter;

    AgendamentoService service = ServiceFactory.create();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrro);

        presenter = new AgendamentoPresenter(this, service);

        txtTurma = findViewById(R.id.txtTurma);
        txtHorario = findViewById(R.id.txtHorario);
        txtApresentacao = findViewById(R.id.txtApresentacao);
        txtSala = findViewById(R.id.txtSala);

       spinner_classe =  findViewById(R.id.spinner_classe);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_classe, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_classe.setAdapter(adapter);


    }



    public void Agendar(View view) {

        String turma = txtTurma.getText().toString();
        String sala = txtSala.getText().toString();
        String horario = txtHorario.getText().toString();
        String apresentacao = txtApresentacao.getText().toString();

        String classe = spinner_classe.getSelectedItem().toString();


        Agendamento agendamento=  new Agendamento();
        agendamento.setTurma(turma);
        agendamento.setSala(sala);
        agendamento.setHorario(horario);
        agendamento.setApresentacao(apresentacao);
        agendamento.setClasse(classe);

        presenter.agendarApresentacao(agendamento);

    }

    @Override
    public void showMessage(String titulo, String mensagem){
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(titulo);
        alert.setMessage(mensagem);
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alert.show();
    }


}
