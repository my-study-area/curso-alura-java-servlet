package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

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
		Empresa empresa = new Empresa();
		empresa.setNome(nomeDaEmpresa);
		
        Banco banco = new Banco();
        banco.adiciona(empresa);
		
		PrintWriter out = response.getWriter();
		out.append("<html>");
		out.append("<body>");
		out.println("<html><body>Empresa " + nomeDaEmpresa + " cadastrada com sucesso!</body></html>");
		out.append("</body>");
		out.append("</html>");
	}

}
