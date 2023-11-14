import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThread extends Thread{
    private Socket socket;

    public ServerThread(Socket socket){
        this.socket=socket;
    }

    @Override
    public void run() {
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String name = Thread.currentThread().getName();
//        System.out.println("当前线程名称 "+name);
        BufferedReader bs=new BufferedReader(new InputStreamReader(inputStream));
        System.out.print("scoket读取的字节: ");
        String msg  ;

        // 在12行直接加while(true)强行监听链接也不行，因为代码程序已经在20行进入循环判断了，所以无法接收多个客户端
        try {
            while (((msg=bs.readLine())!=null)){
                System.out.println(name +" 服务端消息: "+msg);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
