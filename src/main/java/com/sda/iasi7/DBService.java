package com.sda.iasi7;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBService {

  private static final String url = "jdbc:mysql://localhost:3306/iasi7";
  private static final String user = "bogdan";
  private static final String password = "password";
  private static Connection myConnection = null;

  public static Connection getConnection() {
    if (myConnection == null) {
      try {
        myConnection = DriverManager.getConnection(url, user, password);
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return myConnection;

  }
}
