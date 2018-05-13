package br.com.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cursomc.domain.Pedido;
import br.com.cursomc.repositories.PedidoRepository;
import br.com.cursomc.services.exception.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	public Pedido find(Integer id) throws ObjectNotFoundException {

		Optional<Pedido> pedido = pedidoRepository.findById(id);

		return pedido.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrador! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}
}
