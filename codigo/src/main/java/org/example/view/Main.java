package org.example.view;

import java.io.*;
import java.time.Month;
import java.util.*;

import org.example.model.*;

public class Main {
    private static int vagaIdCounter = 1;

    public static void main(String[] args) {
        List<Estacionamento> estacionamentos = carregarEstacionamentos();
        List<Cliente> clientes = carregarClientes();
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            System.out.println("\nSistema de Estacionamentos");
            System.out.println("1. Cadastrar Estacionamento");
            System.out.println("2. Cadastrar Cliente");
            System.out.println("3. Estacionar Veículo");
            System.out.println("4. Liberar Vaga");
            System.out.println("5. Listar Estacionamentos");
            System.out.println("6. Listar arrecadação total por mês");
            System.out.println("7. Listar valor médio por utilização");
            System.out.println("8. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarEstacionamento(estacionamentos, scanner);
                    salvarEstacionamentos(estacionamentos);
                    break;

                case 2:
                    cadastrarCliente(clientes, scanner);
                    salvarClientes(clientes);
                    break;

                case 3:
                    estacionarVeiculo(estacionamentos, clientes, scanner);
                    salvarEstacionamentos(estacionamentos);
                    break;

                case 4:
                    liberarVaga(estacionamentos, scanner);
                    salvarEstacionamentos(estacionamentos);
                    break;

                case 5:
                    listarEstacionamentos(estacionamentos);
                    break;

                case 6:
                    valorArrecadadoPorMes(estacionamentos, scanner);
                    break;

                case 7:
                    calcularValorMedioPorUtilizacao(estacionamentos);
                    break;

                case 8:
                    sair = true;
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }

    private static void cadastrarEstacionamento(List<Estacionamento> estacionamentos, Scanner scanner) {
        System.out.print("Nome do Estacionamento: ");
        String nomeEst = scanner.nextLine();
        System.out.print("CEP: ");
        String cep = scanner.nextLine();
        System.out.print("Rua: ");
        String rua = scanner.nextLine();
        System.out.print("Bairro: ");
        String bairro = scanner.nextLine();
        System.out.print("Número: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        Endereco endereco = new Endereco(cep, rua, bairro, numero);
        Map<String, Vaga> vagas = new HashMap<>();

        System.out.print("Quantas vagas deseja cadastrar? ");
        int quantidadeVagas = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < quantidadeVagas; i++) {
            String idVaga = "Vaga-" + vagaIdCounter++;

            System.out.println("\nEscolha o tipo de vaga para " + idVaga + ":");
            System.out.println("1. Vaga Normal");
            System.out.println("2. Vaga Vip");
            System.out.println("3. Vaga Idoso");
            System.out.println("4. Vaga PCD");
            System.out.print("Opção: ");
            int tipoVaga = scanner.nextInt();
            scanner.nextLine();

            Vaga vaga;
            switch (tipoVaga) {
                case 1:
                    vaga = new Vaga(idVaga, true, new ArrayList<>());
                    break;
                case 2:
                    vaga = new VagaVip(idVaga, true, new ArrayList<>());
                    break;
                case 3:
                    vaga = new VagaIdoso(idVaga, true, new ArrayList<>());
                    break;
                case 4:
                    vaga = new VagaPCD(idVaga, true, new ArrayList<>());
                    break;
                default:
                    System.out.println("Opção inválida. Atribuindo vaga como 'Vaga Normal'.");
                    vaga = new Vaga(idVaga, true, new ArrayList<>());
                    break;
            }

            vagas.put(idVaga, vaga);
        }

        Estacionamento estacionamento = new Estacionamento(nomeEst, endereco, vagas);
        estacionamentos.add(estacionamento);
        System.out.println("Estacionamento cadastrado com sucesso!");
    }


    private static void cadastrarCliente(List<Cliente> clientes, Scanner scanner) {
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        Cliente cliente = new Cliente(nome, cpf, telefone);
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void estacionarVeiculo(List<Estacionamento> estacionamentos, List<Cliente> clientes, Scanner scanner) {
        System.out.print("Nome do Estacionamento: ");
        String nomeEstacionamento = scanner.nextLine();
        Estacionamento est = buscarEstacionamento(estacionamentos, nomeEstacionamento);

        if (est != null) {
            System.out.print("CPF do Cliente: ");
            String cpf = scanner.nextLine();
            Cliente cliente = buscarCliente(clientes, cpf);

            if (cliente != null) {
                System.out.print("Placa do Veículo: ");
                String placa = scanner.nextLine();
                System.out.print("Modelo do Veículo: ");
                String modelo = scanner.nextLine();
                System.out.print("Marca do Veículo: ");
                String marca = scanner.nextLine();

                Veiculo veiculo = new Veiculo(placa, modelo, marca, cliente);
                cliente.adicionarVeiculo(veiculo);

                System.out.print("Identificador da Vaga: ");
                String idVaga = scanner.nextLine();
                est.estacionarVeiculo(idVaga, veiculo);
                System.out.println("Veículo estacionado com sucesso!");
            } else {
                System.out.println("Cliente não encontrado!");
            }
        } else {
            System.out.println("Estacionamento não encontrado!");
        }
    }

    private static void liberarVaga(List<Estacionamento> estacionamentos, Scanner scanner) {
        System.out.print("Nome do Estacionamento: ");
        String nomeEstacionamento = scanner.nextLine();
        Estacionamento est = buscarEstacionamento(estacionamentos, nomeEstacionamento);

        if (est != null) {
            System.out.print("Identificador da Vaga: ");
            String idVaga = scanner.nextLine();
            Vaga vaga = buscarVaga(est, idVaga);

            if (vaga != null) {
                UsoDaVaga uso = vaga.getUsoDaVaga().get(vaga.getUsoDaVaga().size() - 1);
                double valor = uso.baixarUsoDaVaga();
                System.out.println("Vaga liberada. Valor a ser pago: R$ " + valor);
            } else {
                System.out.println("Vaga não encontrada!");
            }
        } else {
            System.out.println("Estacionamento não encontrado!");
        }
    }


    private static void listarEstacionamentos(List<Estacionamento> estacionamentos) {
        for (Estacionamento est : estacionamentos) {
            System.out.println("Estacionamento: " + est.getNome() + ", Endereço: " + est.getEndereco().getRua());
            for (Vaga vaga : est.getVagas()) {
                System.out.println("Vaga: " + vaga.getIdentificador() + ", Disponível: " + vaga.getDisponibilidade());
            }
        }
    }

    private static Estacionamento buscarEstacionamento(List<Estacionamento> estacionamentos, String nome) {
        for (Estacionamento est : estacionamentos) {
            if (est.getNome().equalsIgnoreCase(nome)) {
                return est;
            }
        }
        return null;
    }

    private static Cliente buscarCliente(List<Cliente> clientes, String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    private static Vaga buscarVaga(Estacionamento estacionamento, String idVaga) {
        Vaga[] vagas = estacionamento.getVagas();
        if (vagas == null) {
            return null;
        }
        return Arrays.stream(vagas)
                .filter(vaga -> vaga.getIdentificador().equals(idVaga))
                .findFirst()
                .orElse(null);
    }

    private static List<Estacionamento> carregarEstacionamentos() {
        List<Estacionamento> estacionamentos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("estacionamentos.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 5) {
                    Endereco endereco = new Endereco(dados[1], dados[2], dados[3], Integer.parseInt(dados[4]));
                    Estacionamento estacionamento = new Estacionamento(dados[0], endereco, new HashMap<>());

                    while ((linha = reader.readLine()) != null && !linha.trim().isEmpty()) {
                        String[] vagaDados = linha.split(",");
                        if (vagaDados.length == 3) {
                            String idVaga = vagaDados[0];
                            boolean disponibilidade = Boolean.parseBoolean(vagaDados[1]);
                            Vaga vaga = new Vaga(idVaga, disponibilidade, new ArrayList<>());
                            estacionamento.adicionarVaga(idVaga,vaga);
                        }
                    }
                    estacionamentos.add(estacionamento);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar estacionamentos: " + e.getMessage());
        }
        return estacionamentos;

    }

    private static void salvarEstacionamentos(List<Estacionamento> estacionamentos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("estacionamento.txt"))) {
            for (Estacionamento estacionamento : estacionamentos) {
                writer.write(estacionamento.getNome() + "," +
                        estacionamento.getEndereco().getCep() + "," +
                        estacionamento.getEndereco().getRua() + "," +
                        estacionamento.getEndereco().getBairro() + "," +
                        estacionamento.getEndereco().getNumero());
                writer.newLine();

                for (Vaga vaga : estacionamento.getVagas()) {
                    writer.write(vaga.getIdentificador() + "," +
                            vaga.getDisponibilidade() + "," +
                            vaga.getUsoDaVaga().size());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar estacionamentos: " + e.getMessage());
        }

    }

    private static List<Cliente> carregarClientes() {
            List<Cliente> clientes = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(new FileReader("cliente.txt"))) {
                String linha;
                while ((linha = reader.readLine()) != null) {
                    String[] dados = linha.split(",");
                    if (dados.length == 3) {
                        Cliente cliente = new Cliente(dados[0], dados[1], dados[2]);
                        clientes.add(cliente);
                    }
                }
            } catch (IOException e) {
                System.err.println("Erro ao carregar clientes: " + e.getMessage());
            }
            return clientes;
        }

    private static void salvarClientes(List<Cliente> clientes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("clientes.txt"))) {
            for (Cliente cliente : clientes) {
                writer.write(cliente.getNome() + "," + cliente.getCpf() + "," + cliente.getTelefone());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar clientes: " + e.getMessage());
        }
    }

    private static double valorArrecadadoPorMes(List<Estacionamento> estacionamentos, Scanner scanner) {
        Utils utils = new Utils();
        for (Month mes : Month.values()) {
            int index = mes.getValue();
            System.out.println(index + ". " + utils.traduzirNomeDoMes(mes));
        }

        System.out.print("Selecione o mês desejado: ");
        String mes = scanner.nextLine();
        Month mesParsed = Month.of(Integer.parseInt(mes));

        List<UsoDaVaga> vagasDoMes = new ArrayList<>();

        for (Estacionamento estacionamento : estacionamentos) {
            for (Vaga vaga : estacionamento.getVagas()) {
                List<UsoDaVaga> usoDaVaga = vaga.getUsoDaVaga();

                for (UsoDaVaga uso : usoDaVaga) {
                    Month dateMes = uso.getDataHoraEntrada().getMonth();

                    if (dateMes.equals(mesParsed)) {
                        vagasDoMes.add(uso);
                    }
                }
            }
        }

        double valorTotal = 0;

        for (UsoDaVaga uso : vagasDoMes) {
            valorTotal += uso.calcularPrecoEstadia();
        }

        System.out.println("Valor total arrecadado no mês de " + utils.traduzirNomeDoMes(mesParsed) + " foi de: " + valorTotal);

        return valorTotal;
    }

    private static void calcularValorMedioPorUtilizacao(List<Estacionamento> estacionamentos) {
        double valorTotal = 0;
        int totalUsos = 0;

        for (Estacionamento estacionamento : estacionamentos) {
            for (Vaga vaga : estacionamento.getVagas()) {
                List<UsoDaVaga> usoDaVaga = vaga.getUsoDaVaga();

                for (UsoDaVaga uso : usoDaVaga) {
                    valorTotal += uso.calcularPrecoEstadia();
                    totalUsos++;
                }
            }
        }

        double valorMedio = totalUsos > 0 ? valorTotal / totalUsos : 0;
        System.out.println("Valor médio por utilização em todas as utilizações foi de: " + valorMedio);
    }
}