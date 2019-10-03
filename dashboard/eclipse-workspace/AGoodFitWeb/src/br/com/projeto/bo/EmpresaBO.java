package br.com.projeto.bo;

import br.com.projeto.beans.Empresa;
import br.com.projeto.dao.EmpresaDAO;

public class EmpresaBO {
		
	public String addEmpresa(Empresa empresa) throws Exception{		
		EmpresaDAO endDao = new EmpresaDAO();
		Empresa end = endDao.getEmpresa(empresa.getCodEmpresa());
		
		if((end.getCnpjEmpresa().length() < 14) || (end.getCnpjEmpresa().length() > 14)) {
			return "CNPJ deve conter 14 digitos";
		}
		
		empresa.setRazaoSocialEmpresa(empresa.getRazaoSocialEmpresa().toUpperCase());
		empresa.setNomeFantasiaEmpresa(empresa.getNomeFantasiaEmpresa().toUpperCase());
		
		return "Cadastro realizado com sucesso";
	}

}