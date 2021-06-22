package unoesc.edu.emprestimo.dao;

import java.util.List;

import unoesc.edu.emprestimo.model.Emprestimo;
	
public interface EmprestimoDAO {

	Emprestimo getEmprestimoById (int id);
	List<Emprestimo> getEmprestimos();
	void insertEmprestimo(Emprestimo emprestimo);
	void updateEmprestimo(Emprestimo emprestimo);
	void deleteEmprestimo(Emprestimo emprestimo);
	
}