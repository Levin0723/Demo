package text01;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * Created by 黄桂道 on 2017-1-14.
 */
public class DataBasicTest {
    public static void main(String[] args) {
        Connection conn = DBCPTest.getConn();
        String sql = "SELECT * FROM imooc.goods_list;";
        Statement smt = null;
        ResultSet rs = null;
        String result = null;

        try {
            smt = conn.createStatement();
            rs = smt.executeQuery(sql);
            while (rs.next()) {
                result = rs.getString("goods_name");
                System.out.println(result);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
