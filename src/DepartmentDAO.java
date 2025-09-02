import javax.xml.transform.Result;
import java.sql.*;

public class DepartmentDAO {
    public boolean insert(){
        Conexao conexao = new Conexao();
        Connection conn = conexao.connect();

        try{
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO DEPT" +
                    "(DEPTNO,DNAME,LOC) VALUES (?,?,?)");

            pstmt.setInt(1, 91);
            pstmt.setString(2, "Marketing");
            pstmt.setString(3, "RJ");
            pstmt.execute();
            conexao.disconnect(conn);
            return true;
        } catch (SQLException sqle){
            sqle.printStackTrace();
            conexao.disconnect(conn);
            return false;
        }
    }
    public boolean update(){
        Conexao conexao = new Conexao();
        Connection conn = conexao.connect();

        try{
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "UPDATE DEPT SET NAME ? WHERE DEPTNO = ?"
            );
            preparedStatement.setString(1, "Producao");
            preparedStatement.setInt(2, 90);
            preparedStatement.execute();
            conexao.disconnect(conn);
        } catch (SQLException sqle){
            sqle.printStackTrace();
            return false;
        }
        return true;
    }
    public boolean remove(){
        Conexao conexao = new Conexao();
        Connection conn = conexao.connect();

        try{
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "DELETE FROM DEPT WHERE DEPTNO = ?"
            );
            preparedStatement.setInt(1, 91);
            preparedStatement.execute();
            conexao.disconnect(conn);
        } catch (SQLException sqle){
            sqle.printStackTrace();
            return false;
        }
        return true;
    }

    public ResultSet search(){
        Conexao conexao = new Conexao();
        Connection conn = conexao.connect();
        ResultSet rs = null;

        try{
            Statement stmnt = conn.createStatement();
            rs = stmnt.executeQuery("SELECT * FROM DEPT ORDER BY DEPTNO");
            conexao.disconnect(conn);
        } catch (SQLException sqle){
            sqle.printStackTrace();
        }
        return rs;
    }
}