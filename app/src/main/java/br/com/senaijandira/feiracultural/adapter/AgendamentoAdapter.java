package br.com.senaijandira.feiracultural.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.senaijandira.feiracultural.R;
import br.com.senaijandira.feiracultural.model.Agendamento;

/**
 * Created by sn1041520 on 29/10/2018.
 */

public class AgendamentoAdapter extends ArrayAdapter<Agendamento> {

    public AgendamentoAdapter(Context ctx){
        //Construtor padrão, criando uma lista vazia
        super(ctx, 0, new ArrayList<Agendamento>());
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View v = convertView;

        if(v == null){
            v = LayoutInflater.from(getContext())
                    .inflate(R.layout.list_view_item,
                            parent, false);
        }

        Agendamento agendamento = getItem(position);

        TextView txtTurma= v.findViewById(R.id.txtTurma);
        TextView txtSala = v.findViewById(R.id.txtSala);
        TextView txtHorario = v.findViewById(R.id.txtHorario);

        txtTurma.setText(agendamento.getTurma());
        txtSala.setText(agendamento.getSala());
        txtHorario.setText(agendamento.getHorario());

        return v;
    }
}
