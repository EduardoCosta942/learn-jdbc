import Models.Department;

import javax.xml.transform.Result;
import java.sql.*;

public class DepartmentDAO {
    public boolean insert(Department department){
        Conexao conexao = new Conexao();
        Connection conn = conexao.connect();

        try{
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO DEPT" +
                    "(DEPTNO,DNAME,LOC) VALUES (?,?,?)");

            pstmt.setInt(1, department.getDeptno());
            pstmt.setString(2, department.getDname());
            pstmt.setString(3, department.getDloc());
            return pstmt.executeUpdate() != 0;
        } catch (SQLException sqle){
            sqle.printStackTrace();
            conexao.disconnect(conn);
            return false;
        } finally {
            conexao.disconnect(conn);
        }
    }
    public int updateName(String deptName, int id){
        Conexao conexao = new Conexao();
        Connection conn = conexao.connect();

        try{
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "UPDATE DEPT SET NAME = ? WHERE DEPTNO = ?"
            );
            preparedStatement.setString(1, deptName);
            preparedStatement.setInt(2, id);
            int afetadas = preparedStatement.executeUpdate();

            if (afetadas > 1) return 1;
            return 0;
        } catch (SQLException sqle){
            sqle.printStackTrace();
            return -1;
        } finally {
            conexao.disconnect(conn);
        }
    }
    public int updateLoc(int deptId, String loc){
        Conexao conexao = new Conexao();
        Connection conn = conexao.connect();

        try{
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE DEPT SET LOC = ? WHERE DEPTNO = ?");
            preparedStatement.setString(1, loc);
            preparedStatement.setInt(2, deptId);
            if (preparedStatement.executeUpdate() > 0) return 1;
            return 0;
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            return -1;
        } finally {
            conexao.disconnect(conn);
        }
    }
    public int remove(int id){
        Conexao conexao = new Conexao();
        Connection conn = conexao.connect();

        try{
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "DELETE FROM DEPT WHERE DEPTNO = ?"
            );
            preparedStatement.setInt(1, id);
            if (preparedStatement.executeUpdate() > 0) return 1;
            return 0;
        } catch (SQLException sqle){
            sqle.printStackTrace();
            return -1;
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

    public Department searchByNumber(int id) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.connect();
        ResultSet rs = null;

        try{
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM DEPT WHERE DEPTNO = ?");
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();
            return new Department(rs.getInt("DEPTNO"), rs.getString("DNAME"), rs.getString("DLOC"));
        } catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.disconnect(conn);
        }
    }

    public Department searchByName(String name){
        Conexao conexao = new Conexao();
        Connection conn = conexao.connect();
        ResultSet rs = null;

        try{
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM DEPT WHERE DNAME = ?");
            preparedStatement.setString(1, name);
            rs = preparedStatement.executeQuery();
            return new Department(rs.getInt("DEPTNO"), rs.getString("DNAME"), rs.getString("DLOC"));
        } catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.disconnect(conn);
        }
    }

    public Department searchByLoc(String loc){
        Conexao conexao = new Conexao();
        Connection conn = conexao.connect();
        ResultSet rs = null;

        try{
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM DEPT WHERE DLOC = ?");
            preparedStatement.setString(1, loc);
            rs = preparedStatement.executeQuery();
            return new Department(rs.getInt("DEPTNO"), rs.getString("DNAME"), rs.getString("DLOC"));
        } catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.disconnect(conn);
        }
    }
}