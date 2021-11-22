package PROJECT.DB2;


import java.sql.*;

public class DBConnector {

    private static final String DB_NAME = "db2020_30";//vul hier uw databank naam in
    private static final String DB_PASS = "bysbxhea";//vul hier uw databank paswoord in
    private static Connection instance;

    public static Connection getConnection() throws DBException {
        if (instance == null) {
            Connection con = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                String protocol = "jdbc";
                String subProtocol = "mysql";
                String myDatabase = "//pdbmbook.com/" + DB_NAME;
                String URL = protocol + ":" + subProtocol + ":" + myDatabase
                        + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

                con = DriverManager.getConnection(URL, DB_NAME, DB_PASS);
                instance = con;
                return instance;
            } catch (SQLException sqle) {
                sqle.printStackTrace();
                closeConnection(con);   // deze moeten wel blijven
                throw new DBException(sqle);
            } catch (ClassNotFoundException cnfe) {
                cnfe.printStackTrace();
                closeConnection(con);  //
                throw new DBException(cnfe);
            } catch (Exception ex) {
                ex.printStackTrace();
                closeConnection(con);  //
                throw new DBException(ex);
            }
        } else {
            return instance;
        }
    }



    public static void closeConnection(Connection instance) {
        try {
            if(instance != null)
                instance.close();
        } catch (SQLException sqle) {
            //do nothing
        }
    }

    public static Connection getInstance() {
        return instance;
    }
}
