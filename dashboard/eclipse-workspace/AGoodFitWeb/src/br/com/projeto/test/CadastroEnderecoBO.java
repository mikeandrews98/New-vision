package br.com.projeto.test;


import javax.swing.JOptionPane;

import br.com.projeto.beans.Endereco;
import br.com.projeto.bo.EnderecoBO;
import br.com.projeto.dao.EnderecoDAO;

/*
 * @author Michael RM82443
 * 
 * */

public class CadastroEnderecoBO {
	public static void main(String[] args) {
		Endereco end = null;
		EnderecoDAO daoEnd = null;
		EnderecoBO boEnd = null;
		
		try {
			end = new Endereco();
			daoEnd = new EnderecoDAO();
			boEnd = new EnderecoBO();
			
			end.setLougradouro(JOptionPane.showInputDialog("Endereco"));
			end.setNumero(JOptionPane.showInputDialog("Numero"));
			end.setComplemento(JOptionPane.showInputDialog("Complemento"));
			end.setCep(JOptionPane.showInputDialog("Cep"));
			end.setZona(JOptionPane.showInputDialog("Zona"));
			end.setBairro(JOptionPane.showInputDialog("Bairro"));
			end.setCidade(JOptionPane.showInputDialog("Cidade"));
			end.setEstado(JOptionPane.showInputDialog("Estado"));
			
			boEnd.addEndereco(end);
			daoEnd.addEndereco(end);
				
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
