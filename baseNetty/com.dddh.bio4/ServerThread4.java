import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class ServerThread4 extends Thread{
    private Socket socket;

    public ServerThread4(Socket socket){
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
        BufferedReader bs=new BufferedReader(new InputStreamReader(inputStream));
        System.out.print("scoket读取的字节: ");
        String msg  ;
        try {
            while (((msg=bs.readLine())!=null)){
                System.out.println(name +" 服务端消息: "+msg);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
