public class Estacionamento {
    private String nome;
    private Endereco endereco;
    private Map<String, Vaga> vagas;
    private float precoPorMinuto;
    private float valorLimite;

    public Estacionamento (String nome, Endereco endereco, Map<String, Vaga> vagas, float precoPorMinuto, float valorLimite) {
        this.nome = nome;
        this.endereco = endereco;
        this.vagas = vagas;
        this.precoPorMinuto = precoPorMinuto;
        this.valorLimite = valorLimite;
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

    public float getPrecoPorMinuto() {
        return precoPorMinuto;
    }

    public float getValorLimite() {
        return valorLimite;
    }

    public void estacionarVeiculo(String vaga,Veiculo veiculo, String dataHoraEntrada) {
        Vaga vagaDestino = vagas.get(vaga);
        vaga.addUsoVaga(veiculo, dataHoraEntrada);
    }

    private int calcularTempoEstadia(String dataHoraEntrada, String dataHoraSaida) {
        //TO DO
    }

    public void baixarVaga(String vaga, String dataHoraSaida) {
        Vaga vagaDestino = vagas.get(vaga);
        UsoVaga[] usosVaga = vaga.getUsosVaga();
        UsoVaga usoVaga = usosVaga[usosVaga.length - 1];
        float valorAPagar = calcularTempoEstadia(usoVaga.dataHoraEntrada, dataHoraSaida) * precoPorMinuto;
        if (valorAPagar > valorLimite) {
            return valorLimite;
        }
        return valorAPagar;
    }

    public void setPrecoPorMinuto(float precoPorMinuto) {
        this.precoPorMinuto = precoPorMinuto;
    }

    public void setValorLimite(float valorLimite) {
        this.valorLimite = valorLimite;
    }
}
