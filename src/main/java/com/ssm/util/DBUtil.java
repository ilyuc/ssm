package com.ssm.util;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.*;

/**
 * @author ilyuc
 * @date 2020/6/7 15:10
 */
public class DBUtil {

    private static Logger log= LoggerFactory.getLogger(DBUtil.class);

    /**
     * 驱动
     */
    public static String driver=null;
    /**
     * 地址
     */
    public static String url=null;
    /**
     * 用户名
     */
    public static String username=null;
    /**
     * 密码
     */
    public static String password=null;
    /**
     * 是否自动提交
     */
    public static Boolean isAutoCommit=true;
    /**
     * 数据库连接
     */
    public static Connection conn=null;
    /**
     * 连接池对象
     */
    private static BasicDataSource ds;
    /**
     * 连接池默认连接数
     */
    public static int initSize=1;
    /**
     * 连接池最大连接数
     */
    public static int maxSize=5;

    /**
     * 读取配置到内存中
     */
    static{//静态块

        Properties prop = new Properties();
        InputStream in=null;
        try {
            //获取参数文件
            in = new BufferedInputStream(new FileInputStream("/config/jdbc.properties"));
            //加载文件
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try{
                if(in!=null){
                    in.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }

        driver=(String)prop.get("jdbc.driver");
        url=(String)prop.get("jdbc.url");
        username=(String)prop.get("jdbc.username");
        password=(String)prop.get("jdbc.password");

        //创建连接池
        ds = new BasicDataSource();

        //设置参数
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        ds.setInitialSize(initSize);
        ds.setMaxActive(maxSize);

    }

    /**
     * 使用连接池创建连接
     */
    public static Connection getConnection() throws SQLException{
        if(conn==null){
            try {
                conn= ds.getConnection();
            }catch (Exception e){
                log.error("创建数据库链接失败！链接："+url+"，账户："+username+"，密码："+password, e);
            }}
        return conn;
    }



    /**
     * 拼接sql
     * @param sql
     * @param strings
     * @return
     */
    private static String produceSQL(String sql,String...strings) {

        StringBuffer sb = new StringBuffer();

        //有种情况是?这个字符在末尾,为了解决这个问题,直接在末尾加" "
        sql += " ";

        String[] strs = sql.split("\\?");

        for (int i=0;i<strs.length-1;i++) {
            if(strings[i]==null) {
                strings[i] = "";
            }
            sb.append(strs[i]+"'"+strings[i]+"'");
        }
        sb.append(strs[strs.length - 1]);

        log.info("SQL:"+sb.toString());

        return sb.toString();
    }




    /**
     * 运行 sql
     * @param sql
     * @return
     */
    public static Integer executeUpdate(String sql) {
        Connection conn=null;
        try{
            //连接池获取连接
            conn= ds.getConnection();
        } catch(Exception e){
            log.error("创建数据库链接失败！链接："+url+"，账户："+username+"，密码："+password, e);
        }
        Integer number=null;
        try {
            Statement stmt = conn.prepareStatement(sql);
            //返回结果
            number= stmt.executeUpdate(sql);
            conn.commit();
            stmt.close();
        } catch (SQLException e) {
            log.error("执行SQL[" +sql+"]异常",e);
        }
        return number;
    }

    public static String getDriver() {
        return driver;
    }

    public static void setDriver(String driver) {
        DBUtil.driver = driver;
    }

    public static String getUrl() {
        return url;
    }

    public static void setUrl(String url) {
        DBUtil.url = url;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        DBUtil.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        DBUtil.password = password;
    }



}
