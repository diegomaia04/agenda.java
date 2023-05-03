package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/main", "/insert", "/select", "/update", "/delete" })

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	DAO dao = new DAO();

	JavaBeans contato = new JavaBeans();

	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		System.out.println(action);

		if (action.equals("/main")) {
			contatos(request, response);
		} else if (action.equals("/insert")) {
			novoContatos(request, response);
		} else if (action.equals("/select")) {
			listarContatos(request, response);
		} else if (action.equals("/update")) {
			editarContatos(request, response);
		} else if (action.equals("/delete")) {
			removerContatos(request, response);
		} else {
			response.sendRedirect("index.html");
		}

		// dao.testeConexao();
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.sendRedirect("agenda.jsp");
		// criando um objeto que ira receber os dados JavBeans
		ArrayList<JavaBeans> lista = dao.listarContatos();

		// encaminhar a lista ao documento agenda.jsp
		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);

		// teste de recebimento da lista
		/**
		 * for (int i = 0; i < lista.size(); i++) {
		 * 
		 * System.out.println(lista.get(i).getIdcon());
		 * System.out.println(lista.get(i).getNome());
		 * System.out.println(lista.get(i).getFone());
		 * System.out.println(lista.get(i).getEmail());
		 * 
		 * }
		 */

	}

	protected void novoContatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("fone"));
		System.out.println(request.getParameter("email"));

		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));

		dao.inserirContato(contato);

		response.sendRedirect("main");

	}

	protected void listarContatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idcon = request.getParameter("idcon");
		// System.out.println(idcon);
		// setar a variavel JavaBeans
		contato.setIdcon(idcon);
		// executar o metodo selecionarcontato (DAO)
		dao.selecionarContato(contato);

		/*
		 * teste de recebimento //System.out.println(contato.getIdcon());
		 * //System.out.println(contato.getNome());
		 * //System.out.println(contato.getFone());
		 * System.out.println(contato.getEmail());
		 */

		// setar os atributos do formulario com o conteudo do JavaBeans
		request.setAttribute("idcon", contato.getIdcon());
		request.setAttribute("nome", contato.getNome());
		request.setAttribute("fone", contato.getFone());
		request.setAttribute("email", contato.getEmail());

		// encaminhar (despachar) ao documento editar.jsp
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);

	}

	protected void editarContatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// setar as variaveis javabeans
		contato.setIdcon(request.getParameter("idcon"));
		contato.setNome(request.getParameter("nome"));
		contato.setFone(request.getParameter("fone"));
		contato.setEmail(request.getParameter("email"));

		dao.editarContato(contato);

		response.sendRedirect("main");

	}

	protected void removerContatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idcon = request.getParameter("idcon");
		// System.out.println(idcon);
		contato.setIdcon(idcon);

		dao.DeletarContato(contato);

		response.sendRedirect("main");
		
	}

}
