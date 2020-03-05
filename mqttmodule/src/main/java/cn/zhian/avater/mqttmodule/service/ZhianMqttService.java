package cn.zhian.avater.mqttmodule.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * Date：2020/3/5
 * Author:Avater
 * Description:
 */
public class ZhianMqttService extends Service {

    private MqttAndroidClient client;
    private MqttConnectOptions connectOptions;

    private String host = "tcp://192.168.1.11";
    private String userName = "admin";
    private String passWord = "123456";
    private String clientId = "Android";

    @Override
    public void onCreate() {
        super.onCreate();

    }

    private void init() {
        client = new MqttAndroidClient(this, host, clientId);

    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private MqttCallback mqttCallback = new MqttCallback() {
        @Override
        public void connectionLost(Throwable cause) {

        }

        @Override
        public void messageArrived(String topic, MqttMessage message) throws Exception {

        }

        @Override
        public void deliveryComplete(IMqttDeliveryToken token) {

        }
    };
}
