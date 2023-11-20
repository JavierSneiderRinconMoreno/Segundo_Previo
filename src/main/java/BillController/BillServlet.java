package BillController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bill_Dao.Bill_Dao;
import Bill_Dao.Bill_Dao_Factori;
import modelo.Bill;


/**
 * Servlet implementation class UsuarioServlet
 */
@WebServlet("/")
public class BillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Bill_Dao billDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		String type = getServletContext().getInitParameter("type");
		this.billDao =  Bill_Dao_Factori.getUsuarioDao(type);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		try {
		switch(action) {
		case "/new" : 
			showNewForm(request, response);
			break;
		case "/insert" : 
			insertarUsuario(request,response);
			break;
		case "/delete" : 
			eliminarUsuario(request,response);
			break;
		case "/edit" :
			showEditForm(request, response);
			break;
		case "/update" : 
			actualizarUsuario(request, response);
			break;
		default : 
			listUsuarios(request,response);
			break;
		}
		}catch(SQLException e) {
			throw new ServletException(e);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("Bill.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertarUsuario(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		String date_bill =request.getParameter("date_bill");
		String observation = request.getParameter("observation");
		String value =request.getParameter("value");
		
		Bill usuario = new Bill( Integer.parseInt(date_bill),  observation, Double.parseDouble(value) );
		
		
		/*Bill_Dao.insert(usuario);*/
		
		response.sendRedirect("list");
		
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		//Bill usuarioActual = Bill_Dao.select(id);
		
		request.setAttribute("usuario", "");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(".jsp");
		dispatcher.forward(request, response);
	}
	
	private void actualizarUsuario(HttpServletRequest request, HttpServletResponse response) throws SQLException,ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String email = request.getParameter("email");
		String pais = request.getParameter("pais");
		
		Bill usuario = new Bill();
		
		//Bill_Dao.update(usuario);
		
		response.sendRedirect("list");
		
	}
	
	private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		//Bill_Dao.delete(id);
		
		response.sendRedirect("list");		
	}
	
	private void listUsuarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
		//List<Bill> listUsuario = Bill_Dao.selectAll();
		
		request.setAttribute("listUsuarios", "");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(".jsp");
		dispatcher.forward(request, response);
		
	}
	
	
	
}

