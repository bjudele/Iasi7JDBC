package com.sda.iasi7;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTableJDBC {

  public static void main(String[] args) {
    createTable("tabel_xyz", "username", "password", "favoriteBand", "details");
    createTable("tabel_abc", "a", "b", "c", "d", "e", "f");
    createTable("tabel_mic", "h");
  }

  private static void createTable(String tableName, String... columnNames) {
    Connection connection = DBService.getConnection();
    String sql =
        "CREATE TABLE " + tableName + "( id int primary key AUTO_INCREMENT, ";
    for (int index = 0; index < columnNames.length - 1; index++) {
      sql += columnNames[index] + " VARCHAR(255),";
    }
    sql += columnNames[columnNames.length - 1] + " VARCHAR(255));";
    try {
      Statement statement = connection.createStatement();
      statement.execute(sql);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
