package com.example.leo.mvpdemo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.leo.mvpdemo.R;
import com.example.leo.mvpdemo.entity.Empregado;

import java.util.List;

/**
 * Created by leo on 11/6/17.
 */

public class EmpregadoAdapter extends BaseAdapter {

    private List<Empregado> empregadoList;

    public EmpregadoAdapter(List<Empregado> empregadoList) {
        this.empregadoList = empregadoList;
    }

    @Override
    public int getCount() {
        return empregadoList.size();
    }

    @Override
    public Empregado getItem(int i) {
        return empregadoList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = layoutInflater.inflate(R.layout.empregado_list_item, viewGroup, false);
        TextView nomeTextView = itemView.findViewById(R.id.empregado_list_item_nome);
        TextView posicaoTextView = itemView.findViewById(R.id.empregado_list_item_posicao);

        Empregado empregado = getItem(i);
        nomeTextView.setText(empregado.getNome());
        posicaoTextView.setText(empregado.getPosicao());

        return itemView;
    }
}
