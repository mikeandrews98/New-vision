package br.com.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.projeto.beans.Candidato;
<<<<<<< HEAD
import br.com.projeto.beans.Usuario;
=======
>>>>>>> 3524192d38ebc28b6cae093b5744bef8f7b306f7
import br.com.projeto.conexao.Conecta;

public class CandidatoDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public CandidatoDAO() throws Exception{
		con = Conecta.getConnection();
	}
	
	public Candidato getCandidato(int codCandidato) throws Exception{
		stmt = (PreparedStatement) con.prepareStatement
				("SELECT * FROM tbCandidato WHERE codCandidato=?");
		stmt.setInt(1, codCandidato);
		rs = stmt.executeQuery();
		
		if(rs.next()) {
<<<<<<< HEAD
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			Usuario usuario = usuarioDAO.getUsuario(rs.getInt("codUsuario"));
			
			
			return new Candidato(
					usuario.getCodUsuario(),
					usuario.getLogin(),
					usuario.getSenha(),
					usuario.getEmail(),
					usuario.getNivel(),
					usuario.getEndereco(),
=======
			UsuarioDAO usuario = new UsuarioDAO();
			
			return new Candidato(
					rs.getInt("codUsuario"),
					usuario.getUsuario(rs.getInt("codUsuario")).getLogin(),
					usuario.getUsuario(rs.getInt("codUsuario")).getSenha(),
					usuario.getUsuario(rs.getInt("codUsuario")).getEmail(),
					usuario.getUsuario(rs.getInt("codUsuario")).getNivel(),
					usuario.getUsuario(rs.getInt("codUsuario")).getEndereco(),
>>>>>>> 3524192d38ebc28b6cae093b5744bef8f7b306f7
					rs.getInt("codCandidato"),
					rs.getString("nome"),
					rs.getString("cpf"),
					rs.getString("rg"),
					rs.getString("dataNasc"),
					rs.getString("descricao"),
<<<<<<< HEAD
					usuario
=======
					usuario.getUsuario(rs.getInt("codUsuario"))
>>>>>>> 3524192d38ebc28b6cae093b5744bef8f7b306f7
					);
		}else {
			return new Candidato();
		}
	}
	
	public int addCandidato(Candidato cand) throws Exception{
		stmt = con.prepareStatement
<<<<<<< HEAD
				("INSERT INTO tbCandidato (nomeCandidato, cpfCandidato, rgCandidato, dataNascimentoCandidato, descricaoCandidato, codUsuario) VALUES (?,?,?,?,?,?)");
		stmt.setString(1, cand.getNome());
		stmt.setString(2, cand.getCpf());
		stmt.setString(3, cand.getRg());
		stmt.setString(4, cand.getDataNasc());
		stmt.setString(5, cand.getDescricao());
		stmt.setInt(6, cand.getUsuario().getCodUsuario());
	
=======
				("INSERT INTO tbCandidato (codCandidato, nome, cpf, rg, dataNasc, descricao, codUsuario) VALUES (?,?,?,?,?,?,?)");
		stmt.setInt(1, cand.getCodCandidato());
		stmt.setString(2, cand.getNome());
		stmt.setString(3, cand.getCpf());
		stmt.setString(4, cand.getRg());
		stmt.setString(5, cand.getDataNasc());
		stmt.setString(6, cand.getDescricao());
		stmt.setInt(7, cand.getUsuario().getCodUsuario());
		
>>>>>>> 3524192d38ebc28b6cae093b5744bef8f7b306f7
		return stmt.executeUpdate();
	}
	
	public int deleteCandidato(int codCandidato) throws Exception{
		
		stmt = con.prepareStatement
				("DELETE FROM tbCandidato WHERE codCandidato=?");
		stmt.setInt(1, codCandidato);
		return stmt.executeUpdate();
	}
	
	public void fechar() throws Exception{
		con.close();
	}
	
}