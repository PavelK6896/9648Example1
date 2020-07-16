import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class Http1 {
    public static void main(String[] args) {
        try {
            int c;
            final PrintStream out2 = System.out;
            Socket socket = new Socket("google.com", 80);
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            out2.println("Start!" + socket.toString());
            byte[] write = ("GET / HTTP/1.1\nHost: google.com\n\n").getBytes();
            out.write(write); // запрост

            while ((c = in.read()) != -1) { // ответ
                out2.print((char) c);
            }

            Thread.sleep(500);
            socket.close();
            out2.println("close!");

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
