package br.com.fiap.smartcities.socket;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import br.com.fiap.smartcities.dao.TipoEstabelecimentoDAO;
import br.com.fiap.smartcities.domain.TipoEstabelecimento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class ServidorSocket {

    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(7777);
        System.out.println("Porta 7777 aberta!");

        Socket cliente = servidor.accept();
        System.out.println(
                "Nova conexão com o cliente "
                        + cliente.getInetAddress().getHostAddress());

        PrintWriter saida = new PrintWriter(new PrintStream(
                cliente.getOutputStream()));

        saida.println("Tecle <Enter> para iniciar");
        saida.flush();

        Scanner leitor = new Scanner(cliente.getInputStream());
        while (leitor.hasNextLine()) {
            saida.println();
            saida.print("Pesquisa por código de Tipo de Estabelecimento (0 para sair): ");
            saida.flush();

            int codigoPesquisa = leitor.nextInt();

            if (codigoPesquisa == 0) {
                saida.close();
                cliente.close();
            }
            saida.print("Realizando pesquisa, aguarde... ");
            saida.flush();
            TipoEstabelecimento tipoEstabelecimento = createDAO().buscar(codigoPesquisa);

            if (tipoEstabelecimento != null) {
                saida.println(
                        "Registro encontrado: "
                                + tipoEstabelecimento.getNome());
            } else {
                saida.println("Nenhum registro encontrado!");
            }
            saida.flush();
        }
        saida.close();

        leitor.close();
        servidor.close();
        cliente.close();
    }

    private static TipoEstabelecimentoDAO createDAO() {

        EntityManager em = Persistence.createEntityManagerFactory("smartcities-orm")
                .createEntityManager();

        return new TipoEstabelecimentoDAO(em);
    }
}