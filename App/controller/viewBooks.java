package cs5330_lib.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cs5330_lib.data.BookDAO;
import cs5330_lib.model.Book;
import cs5330_lib.model.Catalogue;
import cs5330_lib.model.Member;
import cs5330_lib.model.Notice;
import cs5330_lib.model.Rentbook;
import cs5330_lib.model.Staff;

/**
 * Servlet implementation class viewBooks
 */
@WebServlet("/viewBooks")
public class viewBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("action").equals("viewbooks")){
		ArrayList<Book> viewBooks = new ArrayList<Book>();
		HttpSession session = request.getSession();
		BookDAO bookdao = new BookDAO();
		viewBooks = bookdao.viewBooks();
		//System.out.println("Printing list of books..."+viewBooks.get(1).getTitle());
		String url ="/viewBook.jsp";
		session.setAttribute("viewbookslist", viewBooks);
		getServletContext().getRequestDispatcher(url).forward(request, response);
		}
		else if(request.getParameter("action").equals("viewcatalogue")){
			ArrayList<Catalogue> viewCatalogue = new ArrayList<Catalogue>();
			HttpSession session = request.getSession();
			BookDAO bookdao = new BookDAO();
			viewCatalogue = bookdao.viewCatalogue();
			//System.out.println("Printing the catalogue..."+viewBooks.get(1).getTitle());
			String url ="/viewCatalogues.jsp";
			session.setAttribute("viewcataloguelist", viewCatalogue);
			getServletContext().getRequestDispatcher(url).forward(request, response);
			}
		else if(request.getParameter("action").equals("viewmember")){
			ArrayList<Member> viewMember = new ArrayList<Member>();
			HttpSession session = request.getSession();
			BookDAO bookdao = new BookDAO();
			viewMember = bookdao.viewMember();
			//System.out.println("Printing the catalogue..."+viewBooks.get(1).getTitle());
			String url ="/viewMember.jsp";
			session.setAttribute("viewmemberlist", viewMember);
			getServletContext().getRequestDispatcher(url).forward(request, response);
			}
		else if(request.getParameter("action").equals("viewstaff")){
			ArrayList<Staff> viewStaff = new ArrayList<Staff>();
			HttpSession session = request.getSession();
			BookDAO bookdao = new BookDAO();
			viewStaff = bookdao.viewStaff();
			//System.out.println("Printing the catalogue..."+viewBooks.get(1).getTitle());
			String url ="/viewStaff.jsp";
			session.setAttribute("viewstafflist", viewStaff);
			getServletContext().getRequestDispatcher(url).forward(request, response);
			}
		else if(request.getParameter("action").equals("viewnotice")){
			ArrayList<Notice> viewNotice = new ArrayList<Notice>();
			HttpSession session = request.getSession();
			BookDAO bookdao = new BookDAO();
			viewNotice = bookdao.viewNotice();
			//System.out.println("Printing the catalogue..."+viewBooks.get(1).getTitle());
			String url ="/viewNotice.jsp";
			session.setAttribute("viewnoticelist", viewNotice);
			getServletContext().getRequestDispatcher(url).forward(request, response);
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ISBN = request.getParameter("isbn");
		String CID = request.getParameter("cid");
		HttpSession session = request.getSession();
		BookDAO bookdao = new BookDAO();
		Rentbook receipt = new Rentbook();
		String url ="/receipt.jsp";
		receipt = bookdao.viewReceipt(ISBN, CID);
		session.setAttribute("receipt", receipt);
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
