import javax.xml.transform.Result;
import java.sql.*;

public class DepartmentDAO {
    public boolean insert(int deptno, String dname, String dloc){
        Conexao conexao = new Conexao();
        Connection conn = conexao.connect();

        try{
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO DEPT" +
                    "(DEPTNO,DNAME,LOC) VALUES (?,?,?)");

            pstmt.setInt(1, deptno);
            pstmt.setString(2, dname);
            pstmt.setString(3, dloc);
            return pstmt.executeUpdate() != 0;
        } catch (SQLException sqle){
            sqle.printStackTrace();
            conexao.disconnect(conn);
            return false;
        } finally {
            conexao.disconnect(conn);
        }
    }
    public boolean updateName(String deptName, int id){
        Conexao conexao = new Conexao();
        Connection conn = conexao.connect();

        try{
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "UPDATE DEPT SET NAME = ? WHERE DEPTNO = ?"
            );
            preparedStatement.setString(1, deptName);
            preparedStatement.setInt(2, id);
            int afetadas = preparedStatement.executeUpdate();
            return afetadas > 0;
        } catch (SQLException sqle){
            sqle.printStackTrace();
            return false;
        } finally {
            conexao.disconnect(conn);
        }
    }
    public boolean updateLoc(int deptId, String loc){
        Conexao conexao = new Conexao();
        Connection conn = conexao.connect();

        try{
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE DEPT SET LOC = ? WHERE DEPTNO = ?");
            preparedStatement.setString(1, loc);
            preparedStatement.setInt(2, deptId);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return false;
        } finally {
            conexao.disconnect(conn);
        }
    }
    public boolean remove(int id){
        Conexao conexao = new Conexao();
        Connection conn = conexao.connect();

        try{
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "DELETE FROM DEPT WHERE DEPTNO = ?"
            );
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException sqle){
            sqle.printStackTrace();
            return false;
        } finally {
            conexao.disconnect(conn);
        }

    }


    public ResultSet search(){
        Conexao conexao = new Conexao();
        Connection conn = conexao.connect();

        try{
            Statement stmnt = conn.createStatement();
            return stmnt.executeQuery("SELECT * FROM DEPT ORDER BY DEPTNO");
        } catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.disconnect(conn);
        }
    }

    public ResultSet searchByNumber(int id) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.connect();

        try{
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM DEPT WHERE DEPTNO = ?");
            preparedStatement.setInt(1, id);
            return preparedStatement.executeQuery();
        } catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.disconnect(conn);
        }
    }

    public ResultSet searchByName(String name){
        Conexao conexao = new Conexao();
        Connection conn = conexao.connect();

        try{
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM DEPT WHERE DNAME = ?");
            preparedStatement.setString(1, name);
            return preparedStatement.executeQuery();
        } catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.disconnect(conn);
        }
    }

    public ResultSet searchByLoc(String loc){
        Conexao conexao = new Conexao();
        Connection conn = conexao.connect();

        try{
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM DEPT WHERE DLOC = ?");
            preparedStatement.setString(1, loc);
            return preparedStatement.executeQuery();
        } catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.disconnect(conn);
        }
    }


}