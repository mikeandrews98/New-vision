package br.com.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

import br.com.projeto.beans.Candidato;
import br.com.projeto.beans.Usuario;
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
	
		}else {
			return new Candidato();
		}
	}
	
	public int addCandidato(Candidato cand) throws Exception{
		stmt = con.prepareStatement
				("INSERT INTO tbCandidato (nome, cpf, rg, dataNasc, descricao, codUsuario) VALUES (?,?,?,?,?,?)");
		stmt.setString(1, cand.getNome());
		stmt.setString(2, cand.getCpf());
		stmt.setString(3, cand.getRg());
		stmt.setString(4, cand.getDataNasc());
		stmt.setString(5, cand.getDescricao());
		stmt.setInt(6, cand.getUsuario().getCodUsuario());

		
		
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
