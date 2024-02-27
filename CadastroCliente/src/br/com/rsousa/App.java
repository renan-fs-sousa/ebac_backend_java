package br.com.rsousa;

import br.com.rsousa.dao.ClienteMapDAO;
import br.com.rsousa.dao.IClienteDAO;
import br.com.rsousa.domain.Cliente;

import javax.swing.*;

public class App {

    private static IClienteDAO iClienteDAO;

    public static void main(String[] args) {
        iClienteDAO = new ClienteMapDAO();

        String opcao = JOptionPane.showInputDialog(null,
                "Digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração ou 5 para sair",
                "Cadastro", JOptionPane.INFORMATION_MESSAGE);

        opcao = validaStart(opcao);

        while (isOpcaoValida(opcao)) {

            if (isOpcaoSair(opcao)) {

                sair();

            } else if (isCadastro(opcao)) {

                String dados = JOptionPane.showInputDialog(null,
                        "Digite os dados do cliente separados por vígula " +
                                "(Ex.: Nome, CPF, Telefone, Endereço, Número, Cidade e Estado)",
                        "Cadastro", JOptionPane.INFORMATION_MESSAGE);

                if (dados != null) {

                    cadastrar(dados);

                }

            } else if (isConsulta(opcao)) {

                String dados = JOptionPane.showInputDialog(null,
                        "Digite o CPF do cliente:",
                        "Consulta cliente", JOptionPane.INFORMATION_MESSAGE);

                if (dados != null) {

                    consultar(dados);

                }

            } else if (isExclusao(opcao)) {

                String dados = JOptionPane.showInputDialog(null,
                        "Digite o CPF do cliente:",
                        "Consulta cliente", JOptionPane.INFORMATION_MESSAGE);

                if (dados != null) {

                    excluir(dados);

                }

            } else {

                String dados = JOptionPane.showInputDialog(null,
                        "Digite os dados do cliente separados por vígula " +
                                "(Ex.: Nome, CPF, Telefone, Endereço, Número, Cidade e Estado)",
                        "Atualização", JOptionPane.INFORMATION_MESSAGE);

                if (dados != null) {

                    atualizar(dados);

                }

            }

            opcao = JOptionPane.showInputDialog(null,
                    "Digite 1 para cadastro, 2 para consulta, 3 para exclusão, 4 para " +
                            "alteração ou 5 para sair",
                    "Cadastro", JOptionPane.INFORMATION_MESSAGE);

            if (opcao == null || opcao.equals("")) {
                opcao = validaStart(opcao);
            }

        }

    }

    private static void atualizar(String dados) {
        String[] dadosSeparados = dados.split(",");

        if (dadosSeparados.length < 6) {
            JOptionPane.showMessageDialog(null, "Faltam dados!", "Erro",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        else {

            Cliente consultacliente = iClienteDAO.consultar(Long.parseLong(dadosSeparados[1]));
            if (consultacliente != null) {

                Cliente cliente = new Cliente(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2],
                        dadosSeparados[3],
                        dadosSeparados[4], dadosSeparados[5], dadosSeparados[6]);

                iClienteDAO.alterar(cliente);
                JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!", "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(null,
                        "Registro não encontrado!\n", "Erro",
                        JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }

    private static void excluir(String dados) {

        if (!"".equals(dados)) {

            Cliente consultacliente = iClienteDAO.consultar(Long.parseLong(dados));
            if (consultacliente != null) {

                iClienteDAO.excluir(Long.parseLong(dados));
                JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!", "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,
                        "Registro não encontrado!\n", "Erro",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Faltam dados!", "Erro",
                    JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private static void consultar(String dados) {
        if (!"".equals(dados)) {

            Cliente cliente = iClienteDAO.consultar(Long.parseLong(dados));
            if (cliente != null) {
                JOptionPane.showMessageDialog(null,
                        "Cliente encontrado com sucesso!\n" + cliente.toString(), "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado!", "Erro",
                        JOptionPane.INFORMATION_MESSAGE);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Faltam dados!", "Erro",
                    JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private static void cadastrar(String dados) {
        String[] dadosSeparados = dados.split(",");

        if (dadosSeparados.length < 6) {
            JOptionPane.showMessageDialog(null, "Faltam dados!", "Erro",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {

            Cliente cliente = new Cliente(dadosSeparados[0], dadosSeparados[1], dadosSeparados[2], dadosSeparados[3],
                    dadosSeparados[4], dadosSeparados[5], dadosSeparados[6]);
            Boolean isCadastrado = iClienteDAO.cadastrar(cliente);
            if (isCadastrado) {
                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!",
                        "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Já existe um cadastro com esse CPF!",
                        "Erro", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }

    private static boolean isExclusao(String opcao) {
        if ("3".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static boolean isConsulta(String opcao) {
        if ("2".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static boolean isCadastro(String opcao) {
        if ("1".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static void sair() {
        String clientesCadastrados = "";
        for (Cliente cliente : iClienteDAO.buscarTodos()) {
            clientesCadastrados += cliente.toString() + "\n";
        }

        if (clientesCadastrados.equals("")) {
            clientesCadastrados = "Nenhum cliente cadastrado\n";
        }

        JOptionPane.showMessageDialog(null, "Você está saindo...\n\nClientes cadastrados:\n\n" + clientesCadastrados,
                "Exit",
                JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private static boolean isOpcaoSair(String opcao) {
        if ("5".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static boolean isOpcaoValida(String opcao) {
        if ("1".equals(opcao) || "2".equals(opcao)
                || "3".equals(opcao) || "4".equals(opcao) || "5".equals(opcao)) {
            return true;
        }
        return false;
    }

    private static String validaStart(String opcao) {

        while (!isOpcaoValida(opcao)) {
            opcao = JOptionPane.showInputDialog(null,
                    "Opção inválida digite 1 para cadastro, 2 para consulta, 3 para " +
                            "exclusão" +
                            " 4 para alteração ou 5 para sair",
                    "Cadastro", JOptionPane.INFORMATION_MESSAGE);

        }

        return opcao;

    }

}