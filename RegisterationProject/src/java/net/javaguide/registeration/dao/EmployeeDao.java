/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.javaguide.registeration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.javaguide.registeration.model.Employee;

/**
 *
 * @author Samy
 */
public class EmployeeDao {

    public int registerEmployee(Employee employee) throws ClassNotFoundException {

        
        String INSERT_USERS_SQL = "INSERT INTO \"employee\" "
                + "(id , first_name , last_name , username, password, address, contact) VALUES"
                + "( ? , ? , ? , ? , ? , ? , ?);";

        int result = 0;
        
        Class.forName("org.postgresql.Driver");
        
        
        try (
                Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/5432", "postgres", "12345");
                //create a statement using a connection object
                PreparedStatement pr = con.prepareStatement(INSERT_USERS_SQL);) {

            pr.setInt(1, 1);
            pr.setString(2, employee.getFirst_name());
            pr.setString(3, employee.getLast_name());
            pr.setString(4, employee.getUsername());
            pr.setString(5, employee.getPassword());
            pr.setString(6, employee.getAddress());
            pr.setString(7, employee.getContact());

            //excute or update the query
            result = pr.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return result;

    }

}
