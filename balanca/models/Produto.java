package br.com.balanca.models;

import br.com.balanca.exceptions.InvalidProductValueException;
import java.math.BigDecimal;

public class Produto {
    private int codigo;
    private String descricao;
    private String tipo;
    private double valor;
    private BigDecimal precoVenda;

    public Produto() {
    }

    public Produto(int codigo, String descricao, String tipo, double valor) {
        if (valor < 0) {
            throw new InvalidProductValueException("O valor do produto não pode ser negativo.");
        }
        this.codigo = codigo;
        this.descricao = descricao;
        this.tipo = tipo;
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        if (valor < 0) {
            throw new InvalidProductValueException("O valor do produto não pode ser negativo.");
        }
        this.valor = valor;
    }

    public BigDecimal getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(BigDecimal precoVenda) {
        this.valor = precoVenda.doubleValue();
    }
}
