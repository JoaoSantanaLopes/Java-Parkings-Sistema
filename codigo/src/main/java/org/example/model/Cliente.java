package org.example.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable{

    private String nome;
    private String cpf;
    private ArrayList<Veiculo> veiculos;
    private String telefone;
     private static final long serialVersionUID = 1L;

    public Cliente(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.veiculos = new ArrayList<>(); 
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }
    
    public Veiculo getVeiculoPlaca(String placa) {
        for(Veiculo obj : veiculos) {
            if(obj.getPlaca() == placa) {
                return obj;
            }
        }
        return null;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public void removerVeiculo(Veiculo veiculo) {
        veiculos.remove(veiculo);
    }
    
    @Override
    public String toString() {
    return "Cliente { " +
           "Nome: '" + nome + '\'' +
           ", CPF: '" + cpf + '\'' +
           ", Telefone: '" + telefone + '\'' +
           ", Veiculos: " + veiculos +
           " }";
}
}
