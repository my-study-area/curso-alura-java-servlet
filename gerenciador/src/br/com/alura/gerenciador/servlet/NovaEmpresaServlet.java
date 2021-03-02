package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");
		String nomeDaEmpresa = request.getParameter("empresa");
		String dataAbertura = request.getParameter("dataAbertura");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date data;
		try {
			data = sdf.parse(dataAbertura);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeDaEmpresa);
		empresa.setDataAbertura(data);
		
		empresa.setDataAbertura(data);
		
        Banco banco = new Banco();
        banco.adiciona(empresa);
        
        RequestDispatcher rd = request.getRequestDispatcher("/novaEmpresaCriada.jsp");
        request.setAttribute("empresa", empresa.getNome());
        rd.forward(request, response);
		
	}

}
