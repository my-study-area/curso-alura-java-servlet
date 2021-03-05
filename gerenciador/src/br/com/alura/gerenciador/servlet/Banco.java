package br.com.alura.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
    private static List<Empresa> lista = new ArrayList<>();
    
    static {
    	Empresa empresa1 = new Empresa();
    	Empresa empresa2 = new Empresa();
    	int id = 1;
    	
    	empresa1.setId(id++);
    	empresa1.setNome("Alura");
    	empresa2.setId(id++);
    	empresa2.setNome("Caelum");
    	lista.add(empresa1);
    	lista.add(empresa2);
    }

    public void adiciona(Empresa empresa) { 
        lista.add(empresa);
    }
    
    public List<Empresa> getEmpresas(){ 
        return Banco.lista;
    }
    
	public void removeEmpresa(Integer id) {
		Iterator<Empresa> iterator = lista.iterator();
		Empresa empresa;
		while (iterator.hasNext()) {
			empresa = iterator.next();
			if (empresa.getId() == id) {
				iterator.remove();
			}
		}
	}

	public Empresa buscaEmpresaPeloId(Integer id) {
		for (Empresa empresa : lista) {
			if (empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}
}
