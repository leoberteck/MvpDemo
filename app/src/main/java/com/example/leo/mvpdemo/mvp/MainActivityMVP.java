package com.example.leo.mvpdemo.mvp;


import android.widget.BaseAdapter;

/**
 * No modelo MVP (Model-View-Presenter) de projeto, as funcionalidades de
 * tela e tudo que depende de regras de negócio fica no presenter (a classe que implementa MainPresenter).
 * Tudo o que tem a ver com manipular a view (mudar cor de botão, mudar orientacao da tela, mostrar animacao
 * , mostrar dialog de erro... efim tudo que envolve a view) fica na classe da Activity (MainActivity.java)
 * que implementa a interface IMainActivity.
 *
 * MainPresenter coversa com IMainActivity.
 *
 * IMainActivity              MainPresenter
 * ------------             -----------------
 * | Manipula |             | Faz cálculos, |
 * | a tela e | <---------- | manipula o    |
 * |  recebe  |             | banco de dados|
 * | eventos  | ----------> | salva o estado|
 * |          |             | da activity   |
 * -----------              -----------------
 */
public interface MainActivityMVP {
    interface IMainActivity {
        void showEditDialog(String nome, String posicao);
    }

    interface IMainPresenter{
        /**
         * Como no activityLifeCycle do Android
         * a Activity é constantemente destruída
         * e construída novamente é preciso
         * renovar a referência dela no presenter
         * através no método.
         * @param mainActivity
         */
        void setMainActivity(IMainActivity mainActivity);

        /**
         * A view não sabe se estamos editando um usuário existente
         * ou criando um novo. Ela só sabe que o usuário quer salvar
         * um Nome e uma Posicao. O presenter é quem tem que se virar.
         * @param nome
         * @param posicao
         */
        void salvarOuAtualizarEmpregado(String nome, String posicao);

        /**
         * Chama o dialog de edicao com dados vazios
         */
        void criarNovoEmpregado();

        /**
         * Busca o empregado no adapter com a posicao solicitada e mostra
         * o dialog de edicao na view
         * @param index
         */
        void editarEmpregado(int index);

        /**
         * Busca o empregado no adapter e remove da view e do banco
         * @param index
         */
        void deletarEmpregado(int index);

        /**
         * Retorna o adapter do listView que contém os empregados do banco.
         * @return
         */
        BaseAdapter getAdapter();
    }
}
