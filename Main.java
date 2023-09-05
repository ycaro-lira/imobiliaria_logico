package principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        List<Cliente> clientes = new ArrayList<>();
        List<Imovel> imoveis = new ArrayList<>();
        List<Compra> compras = new ArrayList<>();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Imóvel");
            System.out.println("3. Realizar Transação");
            System.out.println("4. Consultar Transações");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int escolha = entrada.nextInt();
            entrada.nextLine();  

            switch (escolha) {
                case 1:
                    cadastrarCliente(entrada, clientes);
                    break;
                case 2:
                    cadastrarImovel(entrada, imoveis);
                    break;
                case 3:
                    realizarTransacao(entrada, clientes, imoveis, compras);
                    break;
                case 4:
                    consultarTransacoes(compras);
                    break;
                case 5:
                    System.out.println("Saindo do programa. Até logo!");
                    entrada.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void cadastrarCliente(Scanner entrada, List<Cliente> clientes) {
        System.out.println("Digite os dados do cliente:");
        System.out.print("Nome: ");
        String nomeCliente = entrada.nextLine();
        System.out.print("CPF: ");
        String cpfCliente = entrada.nextLine();
        System.out.print("Email: ");
        String emailCliente = entrada.nextLine();
        System.out.print("Telefone: ");
        String telefoneCliente = entrada.nextLine();

        Cliente cliente = new Cliente(nomeCliente, cpfCliente, emailCliente, telefoneCliente);
        clientes.add(cliente);
        System.out.println("Cliente cadastrado com sucesso.");
    }

    private static void cadastrarImovel(Scanner entrada, List<Imovel> imoveis) {
        System.out.println("Digite os dados do imóvel:");
        System.out.print("Endereço: ");
        String enderecoImovel = entrada.nextLine();
        System.out.print("Número da Casa: ");
        String numeroImovel = entrada.nextLine();
        System.out.print("Valor de Compra: ");
        double valorCompraImovel = entrada.nextDouble();
        entrada.nextLine(); 
        System.out.print("Valor de Aluguel: ");
        double valorAluguelImovel = entrada.nextDouble();
        entrada.nextLine(); 

        Imovel imovel = new Imovel(enderecoImovel, numeroImovel, valorCompraImovel, valorAluguelImovel);
        imoveis.add(imovel);
        System.out.println("Imóvel cadastrado com sucesso.");
    }

    private static void realizarTransacao(Scanner entrada, List<Cliente> clientes, List<Imovel> imoveis, List<Compra> compras) {
        System.out.println("Digite o CPF do cliente que deseja realizar a transação:");
        String cpfCliente = entrada.nextLine();
        Cliente cliente = buscarClientePorCPF(clientes, cpfCliente);

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        System.out.println("Lista de imóveis disponíveis:");
        listarImoveis(imoveis);

        System.out.print("Digite o ID do imóvel que deseja adquirir/alugar: ");
        int idImovel = entrada.nextInt();
        entrada.nextLine(); 

        Imovel imovelSelecionado = buscarImovelPorId(imoveis, idImovel);

        if (imovelSelecionado == null) {
            System.out.println("Imóvel não encontrado.");
            return;
        }

        System.out.println("Escolha a opção:");
        System.out.println("1. Comprar");
        System.out.println("2. Alugar");
        System.out.print("Digite a opção desejada: ");
        int opcao = entrada.nextInt();
        entrada.nextLine();  

        if (opcao == 1) {
            System.out.print("Digite o valor da compra: ");
            double valorCompra = entrada.nextDouble();
            entrada.nextLine();  
            Compra compra = new Compra(cliente, imovelSelecionado, valorCompra, 0);
            compras.add(compra);
            System.out.println("Compra realizada com sucesso.");
        } else if (opcao == 2) {
            System.out.print("Digite o valor do aluguel: ");
            double valorAluguel = entrada.nextDouble();
            entrada.nextLine();  
            Compra compra = new Compra(cliente, imovelSelecionado, 0, valorAluguel);
            compras.add(compra);
            System.out.println("Aluguel realizado com sucesso.");
        } else {
            System.out.println("Opção inválida.");
        }
    }

    private static void consultarTransacoes(List<Compra> compras) {
        System.out.println("Consultar Transações Realizadas:");
        for (Compra compra : compras) {
            System.out.println("Cliente: " + compra.getCliente().getNome());
            System.out.println("Imóvel Comprado/Alugado: " + compra.getImovel().getEndereco());
            System.out.println("Número da Residência: " + compra.getImovel().getNumero());
            if (compra.getValorCompra() > 0) {
                System.out.println("Tipo: Compra");
                System.out.println("Valor da Compra: R$" + compra.getValorCompra());
            } else {
                System.out.println("Tipo: Aluguel");
                System.out.println("Valor do Aluguel: R$" + compra.getValorAluguel());
            }
            System.out.println("-----------------------------");
        }
    }

    private static Cliente buscarClientePorCPF(List<Cliente> clientes, String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    private static Imovel buscarImovelPorId(List<Imovel> imoveis, int id) {
        for (Imovel imovel : imoveis) {
            if (imovel.getId() == id) {
                return imovel;
            }
        }
        return null;
    }

    private static void listarImoveis(List<Imovel> imoveis) {
        for (Imovel imovel : imoveis) {
            System.out.println("ID do Imóvel: " + imovel.getId());
            System.out.println("Número da Casa: " + imovel.getNumero());
            System.out.println("Endereço: " + imovel.getEndereco());
            System.out.println("Valor de Compra: R$" + imovel.getValorCompra());
            System.out.println("Valor de Aluguel: R$" + imovel.getValorAluguel());
            System.out.println("-----------------------------");
        }
    }
}