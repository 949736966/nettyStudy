import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 9999);
        while (true){
            Scanner scanner=new Scanner(System.in);
            System.out.println("请输入:");
            String msg = scanner.nextLine();
            OutputStream outputStream = socket.getOutputStream();
            PrintStream ps=new PrintStream(outputStream);
            ps.println(msg);
            ps.flush();
        }
    }
}
