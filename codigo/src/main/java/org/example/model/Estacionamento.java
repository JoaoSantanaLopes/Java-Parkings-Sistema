package org.example.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.Collection;

public class Estacionamento implements Serializable{
    private String nome;
    private String rua;
    private String bairro;
    private int numero;
    private Map<String, Vaga> vagas;
    private static final long serialVersionUID = 1L;

    public Estacionamento (String nome, String rua, String bairro, int numero, Map<String, Vaga> vagas) {
        this.nome = nome;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.vagas = vagas;
    }

    public String getNome() {
        return nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    

    public ArrayList<Vaga> getVagas() {
        ArrayList<Vaga> vagas = new ArrayList<>(this.vagas.values());
        return vagas;
    }

    public void adicionarVaga(String codigo, Vaga novaVaga) {
        if (!vagas.containsKey(codigo)) {
            vagas.put(codigo, novaVaga);
            System.out.println("Vaga " + codigo + " adicionada com sucesso.");
        } else {
            System.out.println("Erro: Já existe uma vaga com o código " + codigo + ".");
        }
    }

    public void estacionarVeiculo(String vaga, Veiculo veiculo, Cliente cliente) {
    Vaga vagaDestino = vagas.get(vaga);
        UsoDaVaga novoUsoVaga = new UsoDaVaga(vagaDestino, cliente);
        vagaDestino.addUsoVaga(novoUsoVaga);
        vagaDestino.setDisponibilidade(false);
}
    
    public void liberarVaga(String vaga) {
        Vaga vagaLiberada = vagas.get(vaga);
        vagaLiberada.setDisponibilidade(true);
    }

    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Estacionamento { ")
          .append("Nome: '").append(nome).append("', ")
          .append("Rua: '").append(rua).append("', ")
          .append("Bairro: '").append(bairro).append("', ")
          .append("Numero: ").append(numero).append(", ")
          .append("Vagas: {");

        for (Map.Entry<String, Vaga> entry : vagas.entrySet()) {
            sb.append("\n    ")
              .append("Codigo: '").append(entry.getKey()).append("', ")
              .append("Detalhes da Vaga: ").append(entry.getValue());
        }

        sb.append("\n} }");
        return sb.toString();
    }
}


