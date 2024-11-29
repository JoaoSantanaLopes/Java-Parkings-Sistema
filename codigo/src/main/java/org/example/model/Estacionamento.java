package org.example.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import org.example.DTO.UsoDaVagaDAO;
import org.example.DTO.VagaDAO;

public class Estacionamento implements Serializable{
    private String nome;
    private String rua;
    private String bairro;
    private int numero;
    private Map<String, Vaga> vagas;
    private static final long serialVersionUID = 1L;

    public Estacionamento() {
    }
    
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setVagas(Map<String, Vaga> vagas) {
        this.vagas = vagas;
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

    public void estacionarVeiculo(Vaga vaga, Cliente cliente) {
        UsoDaVaga novoUsoVaga = new UsoDaVaga(vaga, cliente);
        vaga.addUsoVaga(novoUsoVaga);
        vaga.setDisponibilidade(false);
        new UsoDaVagaDAO().CadastrarUsoDaVaga(novoUsoVaga, vaga);
        new VagaDAO().atualizarVaga(vaga.getIdentificador(), vaga.getIdEstacionamento(), vaga.isDisponibilidade());
}
    
    public void liberarVaga(String vaga) {
        Vaga vagaLiberada = vagas.get(vaga);
        vagaLiberada.setDisponibilidade(true);
        new VagaDAO().atualizarVaga(vagaLiberada.getIdentificador(), vagaLiberada.getIdEstacionamento(), vagaLiberada.isDisponibilidade());
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


