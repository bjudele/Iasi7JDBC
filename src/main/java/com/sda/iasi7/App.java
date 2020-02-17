package com.sda.iasi7;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Hello world!
 */
public class App {

  public static void main(String[] args) {

    try {
      Statement statement = DBService.getConnection().createStatement();
      ResultSet resultSet = statement.executeQuery("select first_name, last_name from students where email = 'a@b.c'");

      while (resultSet.next()) {
        String firstName = resultSet.getString("first_name");
        String lastName = resultSet.getString("last_name");
        System.out.println("Hello " + firstName + " " + lastName);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    System.out.println("Hello World!");
  }
}
