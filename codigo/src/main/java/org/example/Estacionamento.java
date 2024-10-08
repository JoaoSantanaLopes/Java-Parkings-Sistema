package org.example;

public class Estacionamento {
    private String nome;
    private Endereco endereco;
    private Map<String, Vaga> vagas;

    public Estacionamento (String nome, Endereco endereco, Map<String, Vaga> vagas) {
        this.nome = nome;
        this.endereco = endereco;
        this.vagas = vagas;
    }

    public String getNome() {
        return nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Vaga[] getVagas() {
        Collection<Vaga> values = vagas.values();
        return values.toArray(new Vaga[0]);;
    }

    public void estacionarVeiculo(String vaga,Veiculo veiculo, String dataHoraEntrada) {
        Vaga vagaDestino = vagas.get(vaga);
        vaga.addUsoVaga(veiculo, dataHoraEntrada);
    }
}

