package br.com.uninove.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.uninove.domain.Cadastro;
import br.com.uninove.factory.ConexaoFactory;

public class CadastroDAO {
	
	//salvar, editar, excluir, buscar,
	
	public void buscar(){
		
		try {
			
			
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		
		
	}
	public void salvar(Cadastro cad) throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO cadastro ");
		sql.append("(nome, ra, senha) ");
		sql.append("VALUES (?, ?, ?) ");
			
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement ps = conexao.prepareStatement(sql.toString());
		
		ps.setString(1, cad.getNome());
		ps.setString(2, cad.getRa());
		ps.setString(3, cad.getSenha());
		
		ps.executeUpdate();
		
	}
	public void editar(Cadastro c) throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("UPDATE cadastro ");
		sql.append("SET nome = ?, ra = ?, senha = ? ");
		sql.append("WHERE id = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement ps = conexao.prepareStatement(sql.toString());
		
		ps.setString(1, c.getNome());
		ps.setString(2, c.getRa());
		ps.setString(3, c.getSenha());
		ps.setLong(4, c.getId());
		
		ps.executeUpdate();
	}
	
	public void excluir(Cadastro c) throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("DELETE FROM cadastro ");
		sql.append("WHERE id = ? ");
		
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement ps = conexao.prepareStatement(sql.toString());
		
		ps.setLong(1, c.getId());
		
		ps.executeUpdate();
	}
	public ArrayList<Cadastro> listar() throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT c.id, c.nome, c.ra, c.senha ");
		sql.append("FROM cadastro c");
		
		Connection conexao = ConexaoFactory.conectar();
		PreparedStatement ps = conexao.prepareStatement(sql.toString());
		
		ResultSet resultado = ps.executeQuery();
		
		ArrayList<Cadastro> itens = new ArrayList<Cadastro>();
		
		while(resultado.next()){
			
			Cadastro ca = new Cadastro();
			
			ca.setId(resultado.getLong("c.id"));
			ca.setNome(resultado.getString("c.nome"));
			ca.setRa(resultado.getString("c.ra"));
			ca.setSenha(resultado.getString("c.senha"));
			
			itens.add(ca);
		}
		
		return itens;
		
	}
	
	
	
	
	
	
	
	/*salvar
	public static void main(String[] args) throws SQLException {
		
		Cadastro cad = new Cadastro();
		
		cad.setNome("Heitor Ribeiro Braz");
		cad.setRa("33333333");
		cad.setSenha("heitor");
		
		CadastroDAO dao = new CadastroDAO();
		dao.salvar(cad);
	}
	*/	
	/* update
	public static void main(String[] args) throws SQLException {
		
		Cadastro cad = new Cadastro();
		
		cad.setId(2L);
		cad.setNome("Rosemeire Ribeiro Braz");
		cad.setRa("111222333");
		cad.setSenha("rose");
		
		CadastroDAO dao = new CadastroDAO();
		dao.editar(cad);
	}
	*/
	
	/*excluir
	public static void main(String[] args) throws SQLException {
		
		Cadastro c = new Cadastro();
		c.setId(2L);
		
		CadastroDAO dao = new CadastroDAO();
		dao.excluir(c);
	}
	*/
	
	
	
}
