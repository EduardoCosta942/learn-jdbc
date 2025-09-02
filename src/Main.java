import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        Connection conn = conexao.connect();
        System.out.println(conn != null);
        conexao.disconnect(conn);

        DepartmentDAO deptDao= new DepartmentDAO();
/*        System.out.println(deptDao.insert());
        conexao.disconnect(conn);*/


        ResultSet rs = deptDao.search();
        try{
            while (rs.next()){
                String line = "depto{"
                        + "DEPTNO=" + rs.getInt("DEPTNO")
                        + ", DNAME=" + rs.getString("DNAME")
                        + ", LOC=" + rs.getString("LOC")
                        + "};";
                System.out.println(line);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

    }
}