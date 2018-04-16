package com.bovink.androidlearning;

/**
 * Created by Retina975 on 17/5/8.
 * <p>
 * API域名工具类
 */

public class HttpUtils {

    private HttpUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 云朵服务器
     */
//    public static String Host = "http://yunduo.tiilii.com/";// 正式服务器
    public static final String Host = "http://59.175.213.88:8085/yunduo/";// 测试服务器
//    public static final String Host = "http://59.175.213.78:30164/yunduo/";// 本地Herb服务器

    /**
     * 云梯服务器
     */
//    public static String LadderHost = "http://jhladder.jhqedu.cn/";// 正式服务器
    public static final String LadderHost = "http://59.175.213.88:8085/";// 测试服务器

    /**
     * Socket服务器
     */
//    public static String SocketHost = "socket.tiilii.com";// 正式服务器
    public static String SocketHost = "59.175.213.88";// 测试服务器
//    public static String SocketHost = "59.175.213.78";// 本地Herb服务器


    /**
     * Socket服务器端口
     */
    public static int SocketPort = 9988;// 正式服务器和测试服务器通用端口
//    public static int SocketPort = 30161;// 本地Herb服务器端口

    /**
     * 获取学生做题的html页面
     */
    public final static String HOMEWORK_TOPIC = Host + "homeworkStu/getTopicForAnswer.do";
}

