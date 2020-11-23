package dbtest;

import java.sql.Connection;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import packageUtils.DbUtils;

public class Test {
    private static Connection conn = DbUtils.getConn();

    /**
     * 增加：方式1
     */

    public void insert1() throws Exception {
        String sql = "insert into users values(?,?,?,?,?,?)";
        QueryRunner runner = new QueryRunner();
        runner.update(conn, sql, "1325469945@qq.com","123","男","新疆大学","软件学院","软件18-3");
    }

    /**
     * 增加：方式2（获得当前自增ID值） ScalarHandler：返回结果集是一个标量（没有单位的数值）
     */
    public void insert2() throws Exception {
        String sql = "insert into tb_user values(?,?,?)";
        QueryRunner runner = new QueryRunner();
        Long id = runner.insert(conn, sql, new ScalarHandler<>(), "张三", 20);
        System.out.println(id);
    }

    /**
     * 多插入几条记录：批处理
     */
    public void insert_many() throws Exception {
        String sql = "insert into tb_user values(null,?,?)";
        QueryRunner runner = new QueryRunner();

        for (int i = 0; i < 10; i++) {
            runner.update(conn, sql, "test_" + i, 20 + i);
        }
    }

    /**
     * 修改
     */

    public void update() throws Exception {
        String sql = "update tb_user set name=? where id=?";
        QueryRunner runner = new QueryRunner();
        runner.update(conn, sql, "王五", 10);
    }

    /**
     * 删除
     */

    public void delete() throws Exception {
        String sql = "delete from tb_user where id=?";
        QueryRunner runner = new QueryRunner();
        runner.update(conn, sql, 11);
    }

    //////////////////////// 查询 //////////////////////
    /**
     * 熟练掌握10种Handler
     * ArrayHandler：返回一个数组，查询到一条记录
     */

    public void test1() throws Exception {
        String sql = "select * from tb_user where id=?";
        QueryRunner runner = new QueryRunner();
        Object[] arr = runner.query(conn, sql, new ArrayHandler(), 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * ArrayListHandler：返回多个数组（每个数组是一条记录），查询到多条记录
     */

    public void test2() throws Exception {
        String sql = "select * from tb_user";
        QueryRunner runner = new QueryRunner();
        List<Object[]> list = runner.query(conn, sql, new ArrayListHandler());

        for (Object[] arr : list) {
            System.out.println(Arrays.toString(arr));
        }
    }

    /**
     * ScalarHandler：返回一条记录组成的Map（转成JSON）
     */
    public void test3() throws Exception {
        String sql = "select count(*) from users";
        QueryRunner runner = new QueryRunner();
        Long cnt = runner.query(conn, sql, new ScalarHandler<>());

        System.out.println(cnt);
    }

    /**
     * MapHandler：返回一行一列的值
     */

    public void test4() throws Exception {
        String sql = "select * from tb_user where id=?";
        QueryRunner runner = new QueryRunner();
        Map<String, Object> map = runner.query(conn, sql, new MapHandler(), 1);
        System.out.println(map);
    }

    /**
     * MapListHandler：返回Map的集合，查询到多条记录
     */

    public void test5() throws Exception {
        String sql = "select * from tb_user";
        QueryRunner runner = new QueryRunner();
        List<Map<String, Object>> list = runner.query(conn, sql, new MapListHandler());

        for (Map<String, Object> map : list) {
            System.out.println(map);
        }
    }

}


