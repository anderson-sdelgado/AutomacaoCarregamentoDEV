/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author anderson
 */
public class TCPIP {
    
    Socket socketCliente;
    InputStream sin;
    OutputStream sout;

    public void connect() {
        try {
            socketCliente = new Socket("192.168.5.5", 9100);
//            socketCliente = new Socket("192.168.5.6", 9100);
//            socketCliente = new Socket("192.168.0.22", 9100);
            sin = socketCliente.getInputStream();
            sout = socketCliente.getOutputStream();
        } catch (IOException ex) {
            Logger.getLogger(TCPIP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void write(byte[] b) throws IOException {
        sout.write(b);
    }
    
    public void write(String s) throws IOException {
        sout.write(s.getBytes());
    }
    
    public void close() {
        try {
            socketCliente.close();
        } catch (IOException ex) {
            Logger.getLogger(TCPIP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void cleanRecv() throws IOException {
        sin.skip(sin.available());
    }
    public byte readByte() throws IOException, InterruptedException {
        byte b = (byte) sin.read();
        for (int i = 0; i < 5 && b == -1; ++i)
        {
            Thread.sleep(250);
            b = (byte) sin.read();
        }        
        System.out.printf("LIDO: %02x\n", b);
        return b;
    }   
    
}
