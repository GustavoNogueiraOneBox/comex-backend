package br.com.onebox.app.api.pedido;

import br.com.onebox.app.domain.*;
import br.com.onebox.app.repository.ClienteRepository;
import br.com.onebox.app.repository.ProdutoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PedidoForm {
    private Long clienteId;
    private TipoDescontoPedidoEnum tipoDescontoPedidoEnum;
    private List<ProdutoDoPedidoForm> itens;

    public Pedido toEntity(ClienteRepository clienteRepository, ProdutoRepository produtoRepository){

        Optional<Cliente> cliente = clienteRepository.findById(clienteId);
        List<ItemPedido> itensPedido = new ArrayList<>();

        itens.forEach(listaProdutos -> {
            Optional<Produto> produto = produtoRepository.findById(listaProdutos.getId());
            itensPedido.add(new ItemPedido(produto, listaProdutos));
        });
        return new Pedido(itensPedido, cliente.get());
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public List<ProdutoDoPedidoForm> getItens() {
        return itens;
    }

    public void setItens(List<ProdutoDoPedidoForm> itens) {
        this.itens = itens;
    }

    public TipoDescontoPedidoEnum getTipoDescontoPedidoEnum() {
        return tipoDescontoPedidoEnum;
    }

    public void setTipoDescontoPedidoEnum(TipoDescontoPedidoEnum tipoDescontoPedidoEnum) {
        this.tipoDescontoPedidoEnum = tipoDescontoPedidoEnum;
    }
}
