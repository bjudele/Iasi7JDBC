package com.sda.iasi7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertJDBC {

  public static void main(String[] args) {
    // we want to insert a new student in Students table

    Scanner scanner = new Scanner(System.in);
    System.out.print("First name: ");
    String firstName = scanner.next();
    System.out.print("Last name: ");
    String lastName = scanner.next();
    System.out.print("Email: ");
    String email = scanner.next();
    System.out.print("Class: ");
    int classId = scanner.nextInt();
    Connection connection = DBService.getConnection();
    String sql = "insert into students (first_name, last_name, email, class_id) values (?, ?, ?, ?);";
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(3, email);
      preparedStatement.setInt(4, classId);
      preparedStatement.setString(1, firstName);
      preparedStatement.setString(2, lastName);

      int ceva = preparedStatement.executeUpdate();
      System.out.println(ceva);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
