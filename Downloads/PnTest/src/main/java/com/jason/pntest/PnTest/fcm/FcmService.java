package com.jason.pntest.PnTest.fcm;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 *测试FCM
 * @author Feiqs
 * @version 创建时间：2019年4月23日 上午10:52:53
 */
public class FcmService {
    private static final String String = null;
    //设备的token值
    public static String token = "dVBuBcWVM1w:APA91bH_lJ19155krSQSz_ZchMrlaNH1R7v8bnBVrHRpRvyt90k7qeBQ0f4cHqRsWrk_iQRsu3DqZO72zztov9FLDzTbotaW7L5OrTLIpXp6I1Zc0UPZWR2eislBH4Ftm-RWE2-sx8xK";
    //渠道名字，也是APP的名字
    public static String appName = "com.transmit.demoapp";
    //主题名字
    public static String topic = "China";
    //通知消息题目
    public static String title = "tip";
    //通知消息内容
    public static String body = "are you ok?";

    //测试内容

    public static void send() throws Exception {
        //添加tokens
        List<String> tokens = new LinkedList();
        tokens.add(token);
        //设置Java代理,端口号是代理软件开放的端口，这个很重要。
//        System.setProperty("proxyHost", "localhost");
//        System.setProperty("proxyPort", "1080");
        //如果FirebaseApp没有初始化
        if(!FireBaseUtil.isInit(appName)) {
            String jsonPath = FcmService.class.getResource("/").getPath()+"google-services.json" ;
            File f = new File(jsonPath);
            if(f.exists()){
                System.out.println("exist!!!");
            }else{
                System.out.println("not exist!!!");
            }
            String dataUrl = "https://transmit-test.firebaseio.com/";
            //初始化FirebaseApp
            FireBaseUtil.initSDK(jsonPath, dataUrl, appName);
        }

        FireBaseUtil.pushSingle(appName, token, title, body);  //单推


        FireBaseUtil.registrationTopic(appName, tokens, topic);  //设置主题

        FireBaseUtil.sendTopicMes(appName, topic, title, body);    //按主题推送

        FireBaseUtil.cancelTopic(appName, tokens, topic);  //取消主题

        //安卓设备推送
        FireBaseUtil.pushSingleToAndroid(appName, token, title, body);
        FireBaseUtil.registrationTopic(appName, tokens, topic);  //设置主题
        FireBaseUtil.sendTopicMesToAndroid(appName, topic, title, body);
    }
}
