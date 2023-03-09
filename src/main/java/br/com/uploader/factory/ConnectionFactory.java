package br.com.uploader.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String USERNAME = "root";
    private static final String PASSWORD ="1234";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/images";

    public static Connection createConnectionToMySQL() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
        return connection;
    };

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection con = createConnectionToMySQL();
        System.out.println(con);
        if(con != null){
            System.out.println("Conexão estabelecida com sucesso!");
            con.close();
        }
    }
}
