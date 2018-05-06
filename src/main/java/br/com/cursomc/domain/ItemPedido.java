package br.com.cursomc.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemPedido implements Serializable{

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private ItemPedidoPk itemPedidoPk = new ItemPedidoPk();

	private Double desconto;

	private Integer quantidade;

	private Double preco;

	public ItemPedido() {
		
	}
	
	public ItemPedido(Pedido pedido, Produto produto, Double desconto, Integer quantidade, Double preco) {
		this.itemPedidoPk.setPedido(pedido);
		this.itemPedidoPk.setProduto(produto);
		this.desconto = desconto;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public ItemPedidoPk getItemPedidoPk() {
		return itemPedidoPk;
	}

	public Double getDesconto() {
		return desconto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setItemPedidoPk(ItemPedidoPk itemPedidoPk) {
		this.itemPedidoPk = itemPedidoPk;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	@JsonIgnore
	public Pedido getPedido() {
		return itemPedidoPk.getPedido();
	}

	public Produto getProduto() {
		return itemPedidoPk.getProduto();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemPedidoPk == null) ? 0 : itemPedidoPk.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemPedido other = (ItemPedido) obj;
		if (itemPedidoPk == null) {
			if (other.itemPedidoPk != null)
				return false;
		} else if (!itemPedidoPk.equals(other.itemPedidoPk))
			return false;
		return true;
	}

}
