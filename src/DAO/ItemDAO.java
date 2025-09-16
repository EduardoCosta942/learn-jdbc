package DAO;

import Models.Department;
import Models.Item;

import java.sql.*;

public class ItemDAO {
    public boolean insert(Item item){
        Conexao conexao = new Conexao();
        Connection conn = conexao.connect();

        try{
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO ITEM" +
                    "(ordid,itemid,prodid,actualPrice,qty,itemtot) VALUES (?,?,?,?,?,?)");

            pstmt.setInt(1, item.getOrdid());
            pstmt.setInt(2, item.getItemid());
            pstmt.setInt(3, item.getProdid());
            pstmt.setDouble(4, item.getActualPrice());
            pstmt.setInt(5, item.getQty());
            pstmt.setDouble(6, item.getItemtot());
            return pstmt.executeUpdate() != 0;
        } catch (SQLException sqle){
            sqle.printStackTrace();
            conexao.disconnect(conn);
            return false;
        } finally {
            conexao.disconnect(conn);
        }
    }
    public int updateActualPrice(double actualPrice, int ordid){
        Conexao conexao = new Conexao();
        Connection conn = conexao.connect();

        try{
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "UPDATE ITEM SET ACTUALPRICE = ? WHERE ORDID = ?"
            );
            preparedStatement.setDouble(1, actualPrice);
            preparedStatement.setInt(2, ordid);
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

    public int updateProdid(int prodid, int ordid){
        Conexao conexao = new Conexao();
        Connection conn = conexao.connect();

        try{
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE ITEM SET PRODID = ? WHERE ORDID = ?");
            preparedStatement.setInt(1, prodid);
            preparedStatement.setInt(2, ordid);
            if (preparedStatement.executeUpdate() > 1) return 1;
            return 0;
        } catch (SQLException sqle){
            sqle.printStackTrace();
            return -1;
        } finally {
            conexao.disconnect(conn);
        }
    }

    public int updateQty(int qty, int ordid){
        Conexao conexao = new Conexao();
        Connection conn = conexao.connect();

        try{
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE ITEM SET QTY = ? WHERE ORDID = ?");
            preparedStatement.setInt(1, qty);
            preparedStatement.setInt(2, ordid);
            if (preparedStatement.executeUpdate() > 1) return 1;
            return 0;
        } catch (SQLException sqle){
            sqle.printStackTrace();
            return -1;
        } finally {
            conexao.disconnect(conn);
        }
    }

    public int updateItemtot(double itemtot, int ordid){
        Conexao conexao = new Conexao();
        Connection conn = conexao.connect();

        try{
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE ITEM SET ITEMTOT = ? WHERE ORDID = ?");
            preparedStatement.setDouble(1, itemtot);
            preparedStatement.setInt(2, ordid);
            if (preparedStatement.executeUpdate() > 1) return 1;
            return 0;
        } catch (SQLException sqle){
            sqle.printStackTrace();
            return -1;
        } finally {
            conexao.disconnect(conn);
        }
    }

    public int remove(int ordid){
        Conexao conexao = new Conexao();
        Connection conn = conexao.connect();

        try{
            PreparedStatement preparedStatement = conn.prepareStatement(
                    "DELETE FROM ITEM WHERE ORDID = ?"
            );
            preparedStatement.setInt(1, ordid);
            if (preparedStatement.executeUpdate() > 0) return 1;
            return 0;
        } catch (SQLException sqle){
            sqle.printStackTrace();
            return -1;
        } finally {
            conexao.disconnect(conn);
        }
    }

    public int removeByItemid(int itemid){
        Conexao conexao = new Conexao();
        Connection conn = conexao.connect();

        try{
            PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM ITEM WHERE ITEMID = ?");
            preparedStatement.setInt(1, itemid);
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
            return stmnt.executeQuery("SELECT * FROM ITEM ORDER BY ORDID");
        } catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.disconnect(conn);
        }
    }

    public ResultSet searchByQty(int qty){
        Conexao conexao = new Conexao();
        Connection conn = conexao.connect();

        try{
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM ITEM WHERE QTY = ?");
            preparedStatement.setInt(1, qty);
            return preparedStatement.executeQuery();
        } catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.disconnect(conn);
        }
    }

    public ResultSet searchByItemid(int itemid){
        Conexao conexao = new Conexao();
        Connection conn = conexao.connect();

        try{
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM ITEM WHERE ITEMID = ?");
            preparedStatement.setInt(1, itemid);
            return preparedStatement.executeQuery();
        } catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.disconnect(conn);
        }
    }

    public ResultSet searchByProdid(int prodid){
        Conexao conexao = new Conexao();
        Connection conn = conexao.connect();

        try{
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM ITEM WHERE PRODID= ?");
            preparedStatement.setInt(1, prodid);
            return preparedStatement.executeQuery();
        } catch (SQLException sqle){
            sqle.printStackTrace();
            return null;
        } finally {
            conexao.disconnect(conn);
        }
    }
}