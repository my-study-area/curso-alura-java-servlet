package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/alteraEmpresa")
public class AlteraEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idParam = request.getParameter("id");
		String nomeDaEmpresa = request.getParameter("empresa");
		String dataAbertura = request.getParameter("dataAbertura");
		Integer id = Integer.valueOf(idParam);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date data;
		try {
			data = sdf.parse(dataAbertura);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaPeloId(id);
		empresa.setNome(nomeDaEmpresa);
		empresa.setDataAbertura(data);
		response.sendRedirect("listaEmpresas");
	}

}
