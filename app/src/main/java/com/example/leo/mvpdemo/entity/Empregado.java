package com.example.leo.mvpdemo.entity;

public class Empregado implements IEntity {
    private Integer id;
    private String nome;
    private String posicao;

    public Empregado() {}

    public Empregado(String nome, String posicao) {
        this.nome = nome;
        this.posicao = posicao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    /**
     * Código gerado pelo java não se preocupe com isso...
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Empregado empregado = (Empregado) o;

        return getId() != null ? getId().equals(empregado.getId()) : empregado.getId() == null;
    }

    /**
     * Código gerado pelo java não se preocupe com isso...
     * @return
     */
    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
