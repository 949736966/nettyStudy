import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * 多个客户端多发，服务端多收
 * 使用线程池进行管理，不算异步，只是对线程进行池化管理
 */
public class Server4 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        HandleSocketServerPool handleSocketServerPool = new HandleSocketServerPool(3, 5);
        while (true) {
            Socket accept = serverSocket.accept();
            //将这里线程创建 优化成线程池，池化管理
            //这里整了4个客户端就不能访问了，因为池已经满了

            //new ServerThread(accept).start();
            ServerThread4 serverThread = new ServerThread4(accept);
            handleSocketServerPool.execute(serverThread);
        }

    }
}
