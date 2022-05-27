package Linkcode.bank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Linkcode.bank.Dao.AccountDao;
import Linkcode.bank.Model.Account;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//retrive values from registerview
		Account acc=new Account();
		acc.setAccno(Integer.parseInt(request.getParameter("accno")));
		acc.setCname((request.getParameter("cname")));
		acc.setUname(request.getParameter("uname"));
		acc.setPass((request.getParameter("pass")));
		acc.setBal(Integer.parseInt(request.getParameter("accbal")));
		System.out.println(acc.getBal()+acc.getPass());
		AccountDao adao=new AccountDao();
		List<Account> lst=new LinkedList<Account>();
		lst.add(acc);
		int i=adao.savedata(lst);
		if(i>0)
		{
			System.out.println("Registered the data..");
			response.sendRedirect("LoginView.jsp");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
