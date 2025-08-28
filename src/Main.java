import java.sql.Connection;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Conexao connection = new Conexao();
        Connection conn = connection.connect();
        System.out.println(conn != null);
        connection.disconnect(conn);

        DepartmentDAO deptDao= new DepartmentDAO();
        System.out.println(deptDao.insert());
        connection.disconnect(conn);
    }
}