package com.example.leo.mvpdemo.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.example.leo.mvpdemo.R;
import com.example.leo.mvpdemo.utils.PresenterFactory;

import static com.example.leo.mvpdemo.mvp.MainActivityMVP.IMainActivity;
import static com.example.leo.mvpdemo.mvp.MainActivityMVP.IMainPresenter;

public class MainActivity extends AppCompatActivity implements IMainActivity{

    ListView listView;
    FloatingActionButton fab;
    IMainPresenter presenter = PresenterFactory.getMainPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter.setMainActivity(this);

        listView = findViewById(R.id.activity_main_empregado_listView);
        fab = findViewById(R.id.fab);

        //Preenche a lista de itens
        listView.setAdapter(presenter.getAdapter());

        //A gente edita no clique simples
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                presenter.editarEmpregado(i);
            }
        });

        //A gente deleta no clique longo (clica e segura)
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                presenter.deletarEmpregado(i);
                return false;
            }
        });

        //cria um novo quando clicar no botão de +
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.criarNovoEmpregado();
            }
        });
    }

    @Override
    public void showEditDialog(String nome, String posicao) {
        LayoutInflater inflater = this.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.edit_dialog_fragment, null);

        final EditText nomeEditText = dialogView.findViewById(R.id.edit_dialog_fragment_nome);
        final EditText posicaoEditText = dialogView.findViewById(R.id.edit_dialog_fragment_posicao);

        nomeEditText.setText(nome);
        posicaoEditText.setText(posicao);

        new AlertDialog.Builder(this)
            .setView(dialogView)
            .setNegativeButton("Cancelar", null)
            .setPositiveButton("Gravar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    String _nome = null;
                    if(nomeEditText != null && nomeEditText.getText() != null){
                        _nome = nomeEditText.getText().toString();
                    }
                    String _posicao = null;
                    if(posicaoEditText != null && posicaoEditText.getText() != null){
                        _posicao = posicaoEditText.getText().toString();
                    }
                    presenter.salvarOuAtualizarEmpregado(_nome, _posicao);
                }
            })
            .show();
    }
}
