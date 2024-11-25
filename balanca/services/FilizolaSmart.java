package br.com.balanca.services;

import br.com.balanca.exceptions.InvalidDirectoryException;
import br.com.balanca.interfaces.IBalanca;
import br.com.balanca.models.Produto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FilizolaSmart implements IBalanca<Produto> {
    private static final String PESO_TIPO = "P";
    private static final String UNITARIO_TIPO = "U";
    private static final String SUFIXO = "000";

    @Override
    public void exportar(List<Produto> produtos, String pastaArquivoTxt) {
        File directory = new File(pastaArquivoTxt);

        if (!directory.exists() || !directory.isDirectory()) {
            throw new InvalidDirectoryException("O diretório especificado não existe ou não é válido: " + pastaArquivoTxt);
        }

        File arquivo = new File(pastaArquivoTxt + "/CADTXT.TXT");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
            for (Produto produto : produtos) {
                validarProduto(produto);
                String linha = formatarProduto(produto);
                writer.write(linha);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private String formatarProduto(Produto produto) {
        String codigo = String.format("%06d", produto.getCodigo());
        String tipo = "9".equals(produto.getTipo()) ? PESO_TIPO : UNITARIO_TIPO;
        String descricao = String.format("%-22s", produto.getDescricao());
        String preco = String.format("%07d", (int) (produto.getValor() * 100));

        return codigo + tipo + descricao + preco + SUFIXO;
    }

    private void validarProduto(Produto produto) {
        if (produto.getCodigo() <= 0) {
            throw new IllegalArgumentException("Código do produto inválido: " + produto.getCodigo());
        }
        if (produto.getDescricao() == null || produto.getDescricao().isEmpty()) {
            throw new IllegalArgumentException("Descrição do produto está vazia.");
        }
        if (produto.getValor() <= 0) {
            throw new IllegalArgumentException("Valor do produto deve ser maior que zero: " + produto.getValor());
        }
    }
}
