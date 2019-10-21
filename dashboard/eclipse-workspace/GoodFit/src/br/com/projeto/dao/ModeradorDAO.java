package br.com.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.projeto.beans.Moderador;
import br.com.projeto.beans.Usuario;
import br.com.projeto.conexao.Conexao;
/*
 * @author Nicolas RM82331
 * 
 */
public class ModeradorDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public ModeradorDAO() throws Exception{
		con = Conexao.getConnection();
	}
	
	public Moderador getModerador(int cod) throws Exception{
		stmt = (PreparedStatement) con.prepareStatement
				("SELECT * FROM tbAdministrador WHERE codAdministrador=?");
		stmt.setInt(1, cod);
		rs = stmt.executeQuery();
	
		if(rs.next()) {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			Usuario usuario = usuarioDAO.getUsuario(rs.getInt("codUsuario"));
			return new Moderador(
					usuario.getCodUsuario(),
					usuario.getLogin(),
					usuario.getSenha(),
					usuario.getEmail(),
					usuario.getNivel(),
					usuario.getEndereco(),
					rs.getInt("codAdministrador"),
					rs.getString("nomeAdministrador"),
					rs.getString("cpfAdministrador"),
					rs.getString("unidadeAdministrador"),
					new UsuarioDAO().getUsuario(rs.getInt("codUsuario"))
					);
			
		}else {
			return new Moderador();
		}
	}
	
	public int addModerador(Moderador mod) throws Exception{
		stmt = con.prepareStatement
				("INSERT INTO tbAdministrador (nomeAdministrador, cpfAdministrador, unidadeAdministrador, codUsuario) VALUES (?,?,?,?)");
		stmt.setString(1, mod.getNomeModerador());
		stmt.setString(2, mod.getCpfModerador());
		stmt.setString(3, mod.getUnidade());
		stmt.setInt(4, mod.getUsuario().getCodUsuario());
		
		return stmt.executeUpdate();
	}
	
	
	public int deleteEmpresa(int codModerador) throws Exception{
		
		stmt = con.prepareStatement
				("DELETE FROM tbModerador WHERE codAdministrador=?");
		stmt.setInt(1, codModerador);
		return stmt.executeUpdate();
	}
	
	public int atualizarModerador(int cod, String nome, String unidade, String cpf) throws Exception{
		stmt = con.prepareStatement
				("update tb tbModerador nomeAdministrador = ? cpfAdministrador = ? unidadeAdministrador = ? where codAdministrador = ?");
		stmt.setString(1, nome);
		stmt.setString(2, cpf);
		stmt.setString(3, unidade);
		stmt.setInt(4, cod);
		
		return stmt.executeUpdate();
	}
	
	public void fechar() throws Exception{
		con.close();
	}
}