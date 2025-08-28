//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        if (!connection.connect().equals(null)){
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}