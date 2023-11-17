import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class BufferTest {
    public static void main(String[] args) {
        //selector 必须是非阻塞式，fileChannle是阻塞性得，不能跟selector连用
        //bytebuffer本质上是数组，channle.read() 相当于从channle中读取数据，写入到bytebuffer中，写入之后postion(index)变了
        //所以写入之后，必须调用flip()方法，进行读取，flip方法本质就是讲index重置，读取相应长度得数据
        try{
            FileInputStream fileInputStream = new FileInputStream("D:\\var\\2.txt");
            FileChannel channel = fileInputStream.getChannel();
            ByteBuffer buffer=ByteBuffer.allocate(10);
            int i=0;
            while (true){
                i++;
                System.out.println(" 循环 i="+i);
                System.out.println("limit="+buffer.limit());
                System.out.println("position="+buffer.position());
                System.out.println("capacity="+buffer.capacity());
                int length = channel.read(buffer);
                System.out.println("从channel中读取得字节数: "+length);
                if(length == -1) { // 没有内容了
                    break;
                }
//                System.out.println("limit"+buffer.limit());
//                System.out.println("position"+buffer.position());
//                System.out.println("capacity"+buffer.capacity());

                // 打印 buffer 的内容
//                buffer.flip(); // 切换至读模式
                while(buffer.hasRemaining()) { // 是否还有剩余未读数据
                    byte b = buffer.get();
                    System.out.print((char) b);
                }
                System.out.println("读完了");
//                buffer.clear(); // 切换为写模式
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
