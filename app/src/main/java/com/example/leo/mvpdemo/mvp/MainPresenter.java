package com.example.leo.mvpdemo.mvp;

import android.widget.BaseAdapter;

import com.example.leo.mvpdemo.adapter.EmpregadoAdapter;
import com.example.leo.mvpdemo.dao.AbstractCollectionDao;
import com.example.leo.mvpdemo.dao.IDao;
import com.example.leo.mvpdemo.entity.Empregado;

import static com.example.leo.mvpdemo.mvp.MainActivityMVP.IMainActivity;

public class MainPresenter implements MainActivityMVP.IMainPresenter {

    private IMainActivity mainActivity;
    private Empregado empregadoSendoEditado;
    private EmpregadoAdapter adapter;
    private IDao<Empregado> dao;

    public MainPresenter() {
        dao = new AbstractCollectionDao<Empregado>() {};
        adapter = new EmpregadoAdapter(dao.listAll());
    }

    @Override
    public void setMainActivity(IMainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void salvarOuAtualizarEmpregado(String nome, String posicao) {
        if(empregadoSendoEditado != null){
            empregadoSendoEditado.setNome(nome);
            empregadoSendoEditado.setPosicao(posicao);
            if(empregadoSendoEditado.getId() != null){
                dao.update(empregadoSendoEditado);
            } else {
                dao.add(empregadoSendoEditado);
            }
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void criarNovoEmpregado() {
        empregadoSendoEditado = new Empregado();
        if(mainActivity != null){
            mainActivity.showEditDialog(null, null);
        }
    }

    @Override
    public void editarEmpregado(int index) {
        empregadoSendoEditado = adapter.getItem(index);
        if(mainActivity != null){
            mainActivity.showEditDialog(
                empregadoSendoEditado.getNome()
                , empregadoSendoEditado.getPosicao()
            );
        }
    }

    @Override
    public void deletarEmpregado(int index) {
        dao.delete(adapter.getItem(index));
        adapter.notifyDataSetChanged();
    }

    @Override
    public BaseAdapter getAdapter() {
        return adapter;
    }
}
