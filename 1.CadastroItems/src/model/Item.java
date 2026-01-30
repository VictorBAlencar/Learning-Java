package model;

public class Item {

    //Atributos
    private String nome;
    private double preco;

    //Construtores

    public Item(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public Item() {
    }

    //Getters e Setters(para acesso controlado)

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
