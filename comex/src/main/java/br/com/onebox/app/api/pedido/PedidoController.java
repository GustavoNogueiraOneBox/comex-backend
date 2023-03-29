package br.com.onebox.app.api.pedido;

import br.com.onebox.app.domain.Pedido;
import br.com.onebox.app.repository.ClienteRepository;
import br.com.onebox.app.repository.PedidoRepository;
import br.com.onebox.app.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    ProdutoRepository produtoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<PedidoDto> cadastrar(@RequestBody @Valid PedidoForm form, UriComponentsBuilder uriComponentsBuilder){
        form.getItens().stream().forEach(p ->{
            Integer quantidadeItens = p.getQuantidadeDeItens();
            if(quantidadeItens >= 10){
                form.
            }
        });
        Pedido pedido = form.toEntity(clienteRepository, produtoRepository);
        pedido.setData(LocalDateTime.now());
        pedidoRepository.save(pedido);
        URI uri = uriComponentsBuilder.path("/api/pedidos/{id}").buildAndExpand(pedido.getId()).toUri();
        return ResponseEntity.created(uri).body(new PedidoDto(pedido));
    }
}