package edu.unoesc.project.DAO;

import java.util.List;

import edu.unoesc.project.models.Produto;

public interface ProdutoDAO {
	Produto getProdutoById (int id);
	List<Produto> getProdutos();
	boolean deleteProduto(int id);
	boolean insertProduto(Produto p);
	boolean updateProduto(Produto p);
}
