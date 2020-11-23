package packageUtils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DbUtils {

    private static String url;
    private static String username;
    private static String password;

    static {
        // 读取属性文件，并解析
        InputStream is = DbUtils.class.getResourceAsStream("/jdbc.properties");

        Properties prop = new Properties();
        try {
            // 加载属性文件
            prop.load(is);

            // 加载驱动
            String driver = prop.getProperty("jdbc.driver");
            Class.forName(driver);

            // 获得属性
            url = prop.getProperty("jdbc.url");
            username = prop.getProperty("jdbc.username");
            password = prop.getProperty("jdbc.password");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获得连接对象
     */
    public static Connection getConn() {

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) {
        Connection conn = DbUtils.getConn();
        System.out.println(conn);
    }
}
