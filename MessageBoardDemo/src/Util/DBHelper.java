package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库连接类
 * Created by 黄桂道 on 2017-1-4.
 */
public class DBHelper {
    //数据库驱动
    private final static String DRIVER = "com.mysql.jdbc.Driver";
    //连接数据库的URL地址
    private final static String URL = "jdbc:mysql://localhost:3306/imooc?useUnicode=true&characterEncoding=utf8&useSSL=true";
    //数据库的用户名
    private final static String USERNAME = "root";
    //数据库的密码
    private final static String PASSWORD = "daodao";
    //获取的数据库连接对象
    private static Connection conn = null;

    //静态代码块负责加载驱动
    static {
        try {
            //加载驱动程序  通过反射
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //工厂模型的单例化 返回数据库转接对象
    public static Connection getConnection(){
        if(conn==null){
            try {
                conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return conn;
        }
        return conn;
    }

}
