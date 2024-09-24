public class Cliente {
    
    private String nome;
    private String cpf;
    private Veiculo[] veiculo;
    private String telefone;

    public Cliente(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.veiculo = veiculo;
    }

    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public Veiculo getVeiculo() {
        return veiculo;
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
    private void adicionarVeiculo(Veiculo veiculo) {
        veiculo.add(veiculo);

    }
    private void removerVeiculo(Veiculo veiculo) {
        veiculo.remove(veiculo);

    }

}
