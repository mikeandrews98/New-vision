package br.com.projeto.teste;

import javax.swing.JOptionPane;

import br.com.projeto.beans.NivelUsuario;
import br.com.projeto.dao.NivelUsuarioDAO;
/*
 * @author Michael RM82443
 * 
 */
public class CadastroNivelUsuarioDAO {

	public static void main(String[] args) {
		NivelUsuarioDAO dao = null;
		
		
		try {
			dao = new NivelUsuarioDAO();
			NivelUsuario objNivelUsuario = new NivelUsuario();
			objNivelUsuario.setNome(JOptionPane.showInputDialog("Titulo do Nivel"));
			dao.addNivelUsuario(objNivelUsuario);

//			if(dao.addNivelUsuario(new NivelUsuario()) == 0){
//				System.out.println("Usuario não cadastrado");
//			}else {
//				System.out.println("usuario cadastrado");
//			}
//			
			
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