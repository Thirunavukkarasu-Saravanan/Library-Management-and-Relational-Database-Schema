package cs5330_lib.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cs5330_lib.data.MemberDAO;
import cs5330_lib.data.*;
import cs5330_lib.data.RenewDAO;
import cs5330_lib.model.*;
import cs5330_lib.model.*;


/**
 * Servlet implementation class LibraryController
 */
@WebServlet("/LibraryController")
public class LibraryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//	private void getBookParam (HttpServletRequest request, Book book) {
//		book.setBook(request.getParameter("idcompany"),request.getParameter("company_name"),request.getParameter("phone"),request.getParameter("email"),request.getParameter("idcompany"),request.getParameter("idcompany"),request.getParameter("idcompany"),request.getParameter("idcompany"),request.getParameter("idcompany"),request.getParameter("idcompany"),request.getParameter("idcompany"),request.getParameter("idcompany"));  
//	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action"), url="";
		HttpSession session = request.getSession();
		//Book book = new Book();
		
		if (action.equalsIgnoreCase("register")) {
			Member member = new Member();
			MemberDAO register = new MemberDAO();
			
// Validating values			
		member.setLid(request.getParameter("lid"));
		member.setSsn(request.getParameter("ssn"));
		member.setFname(request.getParameter("fname"));
		member.setMname(request.getParameter("mname"));
		member.setLname(request.getParameter("lname"));	
		member.setFullname(request.getParameter("fullname"));
		member.setPhone(request.getParameter("phone"));
		member.setMtype(request.getParameter("mtype"));
		member.setHaddr(request.getParameter("haddr"));
		member.setCaddr(request.getParameter("caddr"));
		member.setExpdt(request.getParameter("expdt"));
		member.setValdty(request.getParameter("valdty"));
// returning query status         
		int status = register.insertUser(member);
		if (status == 1) {
		   System.out.println("db updated");
		   response.sendRedirect("/cs5330_lib/member.jsp");
		}
		else{
			System.out.println("Please try again with correct data");
		}
		
		}
		else if (action.equalsIgnoreCase("addbook")){
			Book book = new Book();
			BookDAO addto = new BookDAO();
			// Validating values			
			book.setISBN(request.getParameter("isbn"));
			book.setTitle(request.getParameter("title"));
			book.setAuthor(request.getParameter("author"));
			book.setAvailability(request.getParameter("availability"));
			book.setLocation(request.getParameter("location"));	
			book.setRentbook(request.getParameter("rentbook"));
			book.setTotalcopies(request.getParameter("totalcopies"));
			// returning query status         
			int status = addto.insertBook(book);
			if (status == 1) {
			   System.out.println("db updated");
			   response.sendRedirect("/cs5330_lib/books.jsp");
			}
			else{
				
				System.out.println("Please try again with correct data");
			}
			
			
			
		}
		else if (action.equalsIgnoreCase("renewex")){
			Renewlid renewlid = new Renewlid();
			RenewDAO renmem = new RenewDAO();
			// Validating values			
			renewlid.setRlid(request.getParameter("rlid"));
			renewlid.setRvaliddt(request.getParameter("rvaliddt"));
			renewlid.setRvalidflag(request.getParameter("rvalidflag"));
			// returning query status
			int status = renmem.updatemembership(renewlid);
			if (status == 1) {
			   System.out.println("db updated");
			   response.sendRedirect("/cs5330_lib/renewmem.jsp");
			}
			else{
				System.out.println("Please try again with correct data");
			}

						
			
		}
		else if (action.equalsIgnoreCase("rentbook")){
			Rentbook rentbook = new Rentbook();
			Book book = new Book();
			CheckoutDAO checkout = new CheckoutDAO();
			// Validating values for checkout
			rentbook.setOisbn(request.getParameter("oisbn"));
			rentbook.setCid(request.getParameter("cid"));
			rentbook.setCodt(request.getParameter("codt"));
			rentbook.setDuedt(request.getParameter("duedt"));
			rentbook.setNoofbook(request.getParameter("noofbook"));
			rentbook.setIsovrdue(request.getParameter("isovrdue"));
			rentbook.setGrcdt(request.getParameter("grcdt"));
			rentbook.setEnumb(request.getParameter("enumb"));
			//book = CheckoutDAO.selectBook(request.getParameter("oisbn"));
			//Validating values for book
			book.setISBN(book.getISBN());
			book.setAvailability(book.getAvailability());
			
			System.out.println("Printing availability inside controller...."+book.getAvailability());
			System.out.println("Printing availability inside controller...."+book.getISBN());
			
			
			int status = checkout.insertcheckout(rentbook);
			//int status_upd = checkout.updatebook(book);
			if (status == 1 ) {
				   System.out.println("db updated");
				   response.sendRedirect("/cs5330_lib/checkoutbook.jsp");
				}
				else{
					System.out.println("Please try again with correct data");
				}
			
			
		}
		
		else if(action.equalsIgnoreCase("retbook")){
			Returnbook returnbook = new Returnbook();
			ReturnDAO rtrn = new ReturnDAO();
			// validating values for returnbook
			returnbook.setRisbn(request.getParameter("risbn"));
			returnbook.setRid(request.getParameter("rid"));
			returnbook.setRcodt(request.getParameter("rcodt"));
			returnbook.setRdt(request.getParameter("rdt"));
			//
			
			int status = rtrn.returnupdate(returnbook);
			if (status == 1 ){
				System.out.println("db updated");
				   response.sendRedirect("/cs5330_lib/returnbook.jsp");

				}
				else{
				System.out.println("Please try again with correct data");
			}
			
		}
		
	}

}
