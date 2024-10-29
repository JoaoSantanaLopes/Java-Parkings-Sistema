package org.example;

public class Endereco {
    private String cep;
    private String rua;
    private String bairro;
    private int numero;

    public Endereco(String cep, String rua, String bairro, int numero) {
        this.cep = cep;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
    }
    public String getCep() {
        return this.cep;
    }
    public String getRua() {
        return this.rua;
    }
    public String getBairro() {
        return this.bairro;
    }
    public int getNumero() {
        return this.numero;
    }
}
