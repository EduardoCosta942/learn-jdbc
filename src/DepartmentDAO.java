import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DepartmentDAO {
    public boolean insert(){
        Conexao conexao = new Conexao();
        Connection conn = conexao.connect();

        try{
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO DEPT" +
                    "(DEPTNO,DNAME,LOC) VALUES (?,?,?)");

            pstmt.setInt(1, 90);
            pstmt.setString(2, "Marketing");
            pstmt.setString(3, "Sao Paulo");
            pstmt.execute();
            return true;
        } catch (SQLException sqle){
            sqle.printStackTrace();
            return false;
        }
    }
}
