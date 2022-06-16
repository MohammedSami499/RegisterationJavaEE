
package net.javaguide.registeration.controller;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.javaguide.registeration.dao.EmployeeDao;
import net.javaguide.registeration.model.ContactCompany;
import net.javaguide.registeration.model.Employee;
import sun.rmi.server.Dispatcher;

/**
 *
 * @author Samy
 */
public class EmployeeServlet extends HttpServlet {

    private EmployeeDao empDao = new EmployeeDao();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/employeeregister.jsp");
        dispatcher.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String contact = request.getParameter("contact");
        
        //getting the identifying of contact company
        String sub = contact.substring(0, 3);
        
        Employee employee = new Employee();
        
        //check which company the user belongs to
        switch (sub) {
            case "010":
                employee.setContactCompany(ContactCompany.VODAFONE);
                break;
            case "012":
                employee.setContactCompany(ContactCompany.ORANGE);
                break;
            case "015":
                employee.setContactCompany(ContactCompany.WE);
                break;
            case "011":
                employee.setContactCompany(ContactCompany.ETISALATMISR);
                break;
            default:
                employee.setContactCompany(ContactCompany.WRONGENUMBER);
                break;
        }
        
        employee.setFirst_name(firstName);
        employee.setLast_name(lastName);
        employee.setAddress(address);
        employee.setPassword(password);
        employee.setContact(contact);
        
        try {
            
            empDao.registerEmployee(employee);
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        
        request.setAttribute("emp", employee);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/employeedetails.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
