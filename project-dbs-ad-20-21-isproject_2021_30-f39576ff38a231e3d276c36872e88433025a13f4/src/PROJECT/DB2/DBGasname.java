package PROJECT.DB2;


import PROJECT.LOGIC2.GasNames;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBGasname {


    public static GasNames getGasname(String dbgasName) throws DBException {
        Connection con = null;
        try {
            con = DBConnector.getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT * "
                    + "FROM gasName "
                    + "WHERE gasName = " + dbgasName;



            ResultSet srs = stmt.executeQuery(sql);
            String name;

            if (srs.next()) {
                name = srs.getString("gasName");



            } else {// we verwachten slechts 1 rij...
                return null;
            }
            GasNames gas = new GasNames(name);
            // hier effekes constructor gemaakt met alleen name, want snap niet goed wat er met values gebeurd
            return gas;



//


        } catch (Exception ex) {
            ex.printStackTrace();
            throw new DBException(ex);
        }
    }



    public static void save(GasNames g) throws DBException {
        Connection con = null;
        try {
            con = DBConnector.getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

            String sql = "SELECT gasName "
                    + "FROM gasName "
                    + "WHERE gasName = " + g.getName() ;
            ResultSet srs = stmt.executeQuery(sql);
            if (srs.next()) { // overbodig denk ik (emile)
                // UPDATE
                sql = "UPDATE measeredGas "
                        + "SET gasName = " + "'" +  g.getName() + "'" ;


                stmt.executeUpdate(sql);
            } else {
                // INSERT
                sql = "INSERT INTO gasName "
                        + "(gasName) "
                        + "VALUES ("
                        + "'"+ g.getName() + "'"
                        + ")";
                //System.out.println(sql);
                stmt.executeUpdate(sql);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new DBException(ex);
        }
    }

    public static void addGasName(String gasname, String measerementID) throws DBException {
        Connection con = null;   //con = DBConnector.getConnection()
        try {
            con = DBConnector.getConnection();
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "INSERT INTO measeredgas"
                    + "VALUES (" + "'" + gasname + "', " + measerementID + ")" ;
            ResultSet srs = stmt.executeQuery(sql);
        } catch (DBException dbe) {
            dbe.printStackTrace();

            throw dbe;
        } catch (Exception ex) {
            ex.printStackTrace();

            throw new DBException(ex);
        }
    }






}
