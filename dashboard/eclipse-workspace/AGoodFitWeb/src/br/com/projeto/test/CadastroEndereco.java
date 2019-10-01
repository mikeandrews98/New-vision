package br.com.projeto.test;

import javax.swing.JOptionPane;

import br.com.projeto.beans.Endereco;
import br.com.projeto.dao.EnderecoDAO;


public class CadastroEndereco {

	public static void main(String[] args) {
		EnderecoDAO dao = null;
		
		
		try {
			dao = new EnderecoDAO();
			Endereco endereco = new Endereco();
			endereco.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Código Assinatura")));
			endereco.setLougradouro(JOptionPane.showInputDialog("Endereco"));
			endereco.setNumero(JOptionPane.showInputDialog("Numero"));
			endereco.setComplemento(JOptionPane.showInputDialog("Complemento"));
			endereco.setCep(JOptionPane.showInputDialog("Cep"));
			endereco.setZona(JOptionPane.showInputDialog("Zona"));
			endereco.setBairro(JOptionPane.showInputDialog("Bairro"));
			endereco.setCidade(JOptionPane.showInputDialog("Cidade"));
			endereco.setEstado(JOptionPane.showInputDialog("Estado"));
			
			if(dao.addEndereco(new Endereco()) == 0){
				System.out.println("Usuario não cadastrado");
			}else {
				System.out.println("usuario cadastrado");
			}
			
			
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
