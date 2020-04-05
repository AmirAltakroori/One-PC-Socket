/**
 *
 * @author Amir Altakroori
 */

package socketsProject

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reading implements Runnable {

    private final Socket s;

    public Reading(Socket s) {
        this.s = s;
    }

    
    public void run() {
        try {
            
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String msgin = "", msgout = "";
        while (!msgin.equals(("end"))) {
            msgin = din.readUTF();
            System.out.println(msgin);
            msgout = br.readLine();
            dout.writeUTF(msgout);
            dout.flush();
        }
        s.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
