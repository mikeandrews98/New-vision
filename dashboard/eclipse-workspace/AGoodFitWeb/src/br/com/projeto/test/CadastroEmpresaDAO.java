package br.com.projeto.test;

import javax.swing.JOptionPane;

import br.com.projeto.beans.Empresa;
import br.com.projeto.beans.Usuario;
import br.com.projeto.dao.EmpresaDAO;

public class CadastroEmpresaDAO {
	
	public static void main(String[] args) {
		EmpresaDAO dao = null;
		Empresa empresa = null;
		
		try {
			dao = new EmpresaDAO();
			empresa = new Empresa();
			
			empresa.setRazaoSocialEmpresa(JOptionPane.showInputDialog("Razao Social"));
			empresa.setNomeFantasiaEmpresa(JOptionPane.showInputDialog("Nome Fantasia"));
			empresa.setCnpjEmpresa(JOptionPane.showInputDialog("Cnpj Empresa"));
			
			Usuario usuario = new Usuario();
			usuario.setLogin(JOptionPane.showInputDialog("Login"));
			usuario.setSenha(JOptionPane.showInputDialog("Senha"));
			usuario.setEmail(JOptionPane.showInputDialog("E-mail"));	
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}