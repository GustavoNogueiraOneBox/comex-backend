package br.com.onebox.app.api.pedido;

import br.com.onebox.app.api.produto.ProdutoDto;
import br.com.onebox.app.domain.ItemPedido;
import br.com.onebox.app.domain.TipoDescontoProdutoEnum;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ItemPedidoDto {
    private Long id;

    private ProdutoDto produto;

    private BigDecimal precoUnitario;

    private Integer quantidade;

    private BigDecimal desconto;

    private TipoDescontoProdutoEnum tipoDesconto;

    public ItemPedidoDto() {
    }

    public ItemPedidoDto(ItemPedido itemPedido){
        this.id = itemPedido.getId();
        this.produto = new ProdutoDto(itemPedido.getProduto());
        this.precoUnitario = itemPedido.getPrecoUnitario();
        this.quantidade = itemPedido.getQuantidade();
        this.desconto = itemPedido.getDesconto();
        this.tipoDesconto = itemPedido.getTipoDesconto();
    }

    public Long getId() {
        return id;
    }

    public ProdutoDto getProduto() {
        return produto;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public TipoDescontoProdutoEnum getTipoDesconto() {
        return tipoDesconto;
    }

    public List<ItemPedidoDto> converter(List<ItemPedido> itens){
        List<ItemPedidoDto> lista = new ArrayList<>();
        itens.forEach(item -> lista.add(new ItemPedidoDto(item)));
        return lista;
    }
}
