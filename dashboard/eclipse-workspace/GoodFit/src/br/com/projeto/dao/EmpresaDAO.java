package br.com.projeto.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.projeto.beans.Empresa;
import br.com.projeto.beans.Usuario;
import br.com.projeto.conexao.Conexao;
/*
 * @author Jonatas RM76593
 * 
 */
public class EmpresaDAO {
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;

	public EmpresaDAO() throws Exception{
		con = Conexao.getConnection();
	}
	
	public Empresa getEmpresa(int cod) throws Exception{
		stmt = (PreparedStatement) con.prepareStatement
				("SELECT * FROM tbEmpresa WHERE codEmpresa=?");
		stmt.setInt(1, cod);
		rs = stmt.executeQuery();
	
		if(rs.next()) {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			Usuario usuario = usuarioDAO.getUsuario(rs.getInt("codUsuario"));
			return new Empresa(
				usuario.getCodUsuario(),
				usuario.getLogin(),
				usuario.getSenha(),
				usuario.getEmail(),
				usuario.getNivel(),
				usuario.getEndereco(),
				rs.getInt("codEmpresa"),
				rs.getString("razaoSocialEmpresa"),
				rs.getString("nomeFantasiaEmpresa"),
				rs.getString("cnpjEmpresa"),
				new UsuarioDAO().getUsuario(rs.getInt("codUsuario"))
				);
		}else {
			return new Empresa();
		}
	}
	
	public int addEmpresa(Empresa emp) throws Exception{
		stmt = con.prepareStatement
				("INSERT INTO tbEmpresa (razaoSocialEmpresa, nomeFantasiaEmpresa, cnpjEmpresa, codUsuario) VALUES (?,?,?,?)");
		stmt.setString(1, emp.getRazaoSocialEmpresa());
		stmt.setString(2, emp.getNomeFantasiaEmpresa());
		stmt.setString(3, emp.getCnpjEmpresa());
		stmt.setInt(4, emp.getUsuario().getCodUsuario());
		
		return stmt.executeUpdate();
	}
	
	public int deleteEmpresa(int codEmpresa) throws Exception{
		
		stmt = con.prepareStatement
				("DELETE FROM tbEmpresa WHERE codEmpresa=?");
		stmt.setInt(1, codEmpresa);
		return stmt.executeUpdate();
	}
	
	public void fechar() throws Exception{
		con.close();
	}
}