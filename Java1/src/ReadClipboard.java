import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.FlavorEvent;
import java.awt.datatransfer.FlavorListener;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class ReadClipboard {
    public static void main(String[] args) {
        //подписка на изменения буфера обмена
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Toolkit.getDefaultToolkit().getSystemClipboard().addFlavorListener(new FlavorListener() {
                    @Override
                    public void flavorsChanged(FlavorEvent e) {
                        System.out.println("ClipBoard UPDATED: " + e.getSource() + " " + e.toString());
                        String data = null;
                        try {
                            data = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
                        } catch (UnsupportedFlavorException | IOException unsupportedFlavorException) {
                            unsupportedFlavorException.printStackTrace();
                        }
                        System.out.println(data);
                    }
                });
            }
        });
        thread.setDaemon(true);
        thread.start();

        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
