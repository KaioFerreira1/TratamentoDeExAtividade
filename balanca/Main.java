package br.com.balanca;

import br.com.balanca.enums.TipoBalanca;
import br.com.balanca.factory.BalancaFactory;
import br.com.balanca.interfaces.IBalanca;
import br.com.balanca.models.Produto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Produto produto1 = new Produto();
        produto1.setCodigo(276);
        produto1.setDescricao("QUEIJO GRUYERE KG");
        produto1.setTipo("9");
        produto1.setPrecoVenda(new BigDecimal("21.99"));

        Produto produto2 = new Produto();
        produto2.setCodigo(288);
        produto2.setDescricao("QUEIJO PROVOLETE KG");
        produto2.setTipo("9");
        produto2.setPrecoVenda(new BigDecimal("12.29"));

        List<Produto> produtos = new ArrayList<>();
        produtos.add(produto1);
        produtos.add(produto2);

        IBalanca balancaFilizola = BalancaFactory.getBalanca(TipoBalanca.FINIZOLA_SMART);
        balancaFilizola.exportar(produtos, "C:\\Users\\kaiof\\Desktop\\balanca");

        IBalanca balancaToledo = BalancaFactory.getBalanca(TipoBalanca.TOLEDO_MGV6);
        balancaToledo.exportar(produtos, "C:\\Users\\kaiof\\Desktop\\balanca");

        IBalanca balancaUrano = BalancaFactory.getBalanca(TipoBalanca.URANO_INTEGRA);
        balancaUrano.exportar(produtos, "C:\\Users\\kaiof\\Desktop\\balanca");

        System.out.println("Arquivos gerados com sucesso!");

    }
}

