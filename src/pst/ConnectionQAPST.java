/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pst;

import java.sql.*;

/**
 *
 * @author Anderson
 */
public class ConnectionQAPST {
/*
  public final static String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
  public final static String url = "jdbc:odbc:STAFE";
  public final static String usuario = "INTERFACE";
  public final static String senha   = "FGBNY946";
 */
    
      public final static String driver = "oracle.jdbc.driver.OracleDriver";
      public final static String url = "jdbc:oracle:thin:@(DESCRIPTION = (ENABLE = BROKEN)(FAILOVER = ON)(LOAD_BALANCE = YES)" +
                                                "    (ADDRESS = (PROTOCOL = TCP)(HOST = stafe-scan)(PORT = 1521))" +
                                                "    (CONNECT_DATA =" +
                                                "      (SERVER = DEDICATED)" +
                                                "      (SERVICE_NAME = STAFEQA)" +
                                                "      (FAILOVER_MODE =" +
                                                "        (TYPE = SELECT)" +
                                                "        (METHOD = BASIC)" +
                                                "        (RETRIES = 180)" +
                                                "        (DELAY = 5)" +
                                                "       )" +
                                                "    )" +
                                                "  )";
      
      public final static String usuario = "INTERFACE";
      public final static String senha   = "FGBNY946";

  private Connection connection = null;

  private static ConnectionQAPST instance = null;

  private ConnectionQAPST() {
    inicializar();
  }

  public static ConnectionQAPST getInstance() {
    if (instance == null)
      instance = new ConnectionQAPST();
    return instance;
  }

  private void inicializar() {
    try {
      Class.forName(driver);
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
