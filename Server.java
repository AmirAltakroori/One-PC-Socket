/**
 *
 * @author Amir Altakroori
 */

package socketsProject

import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) {
        System.out.println("Server:");
        try {
            ServerSocket ss = new ServerSocket(1302);
            Socket s = ss.accept();;
            while (true) {
                s = ss.accept();

                new Thread(new Reading(s)).start();
                
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    
        

}
