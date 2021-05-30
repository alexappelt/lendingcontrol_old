package unoesc.edu.crudTeste.DAO;

import java.util.List;

import unoesc.edu.crudTeste.model.Produto;
	
public interface ProdutoDAO {

	Produto getProdutoById (int id);
	List<Produto> getProdutos();
	void insertProduto(Produto produto);
	void updateProduto(Produto produto);
	void deleteProduto(Produto produto);
	
}