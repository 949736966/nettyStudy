import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端开发接收任意文件，并保存
 */

public class FileServer {
    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(9999);
            while (true){
                Socket accept = serverSocket.accept();
                new ServerFileThread(accept).start();
            }

        }catch (Exception e){
            e.getStackTrace();
        }

    }
}
