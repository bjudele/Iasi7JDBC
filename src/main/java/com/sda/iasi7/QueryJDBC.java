package com.sda.iasi7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class QueryJDBC {

  public static void main(String[] args) {

    Connection connection = DBService.getConnection();
    String sql = buildSql();
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        String firstName = resultSet.getString("first_name");
        String lastName = resultSet.getString("last_name");
        String className = resultSet.getString("class");
        System.out.println(firstName + " " + lastName + " " + className);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  private static String buildSql() {
    //nr n
    // n stringuri
    Scanner scanner = new Scanner(System.in);
    System.out.print("Numar de params: ");
    Integer numberOfParams = scanner.nextInt();
    String[] params = new String[numberOfParams];
    for (int index = 0; index < numberOfParams; index++) {
      System.out.print("Param " + index + ": ");
      params[index] = scanner.next();
    }
    String sql = "SELECT s.last_name, s.first_name, c.name as class " +
        "FROM students s " +
        "INNER JOIN classes c ON s.class_id = c.id " +
        "where c.name =";
    for (int index = 0; index < params.length - 1; index++) {
      sql += "'" + params[index] + "' or c.name = ";
    }
    sql += "'" + params[numberOfParams - 1] + "';";
    System.out.println(sql);
    return sql;
  }

}
