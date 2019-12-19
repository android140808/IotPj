package cn.zhian.avater.netmodule;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-16 11:25
 * @Description:
 */
public class ServerManager {
    private static ServerManager manager;
    private static String TAG = ServerManager.class.getSimpleName();

    public static ServerManager getInstance() {
        if (manager == null) {
            synchronized (ServerManager.class) {
                if (manager == null) {
                    manager = new ServerManager();
                }
            }
        }
        return manager;
    }

    private ServerManager() {
    }
}
