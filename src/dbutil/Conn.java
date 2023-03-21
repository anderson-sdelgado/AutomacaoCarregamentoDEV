/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dbutil;

import java.sql.*;

/**
 *
 * @author Anderson
 */
public class Conn {
/*
  public final static String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
  public final static String url = "jdbc:odbc:STAFE";
  public final static String usuario = "INTERFACE";
  public final static String senha   = "FGBNY946";
 */
    
      public final static String driver = "oracle.jdbc.driver.OracleDriver";
      public final static String usuario = "INTERFACE";
      public final static String senha   = "FGBNY946";

  private Connection connection = null;
  private static Conn instance = null;

  private Conn() {
    inicializar();
  }

  public static Conn getInstance() {
    if (instance == null)
      instance = new Conn();
    return instance;
  }

  private void inicializar() {
    try {
        
        Class.forName(driver);

        String url = "jdbc:oracle:thin:@(DESCRIPTION = " +
                        "    (ADDRESS = (PROTOCOL = TCP)(HOST = 192.168.2.10)(PORT = 1521)) " +
                        "    (CONNECT_DATA = " +
                        "      (SERVER = DEDICATED) " +
                        "      (SERVICE_NAME = STAFEDEV) " +
                        "    ) " +
                        "  )";

       
      connection = DriverManager.getConnection(url, usuario, senha);
    } catch (ClassNotFoundException e) {
      System.out.println("O driver nao pode ser carregado ["
          + e.getMessage() + "]");
    }catch (SQLException e){
      System.out.println("A conexao nao pode ser estabelecida ["
          + e.getMessage() + "]");
    }
  }

	public Connection getConnection() {
		return connection;
	}

	public void closeConnection(){
   try{
     if (connection != null) connection.close();
   }
   catch(SQLException e){
     System.out.println("Erro ao fechar a conexao ["
         + e.getMessage() + "]");
   }
  }

}
