/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import Data.Gmail;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Van Nam
 */
public class FileGmail {

    private static final String fileName = "FileGmail.dat";

    public void createFile() {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(FileGmail.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void addGmail(Gmail gmail) {
        createFile();
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(fileName, true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(gmail);
            oos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileGmail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileGmail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Gmail> getGmail() {
        createFile();
        ArrayList<Gmail> list = new ArrayList<>();
        FileInputStream fis;
        try {
            fis = new FileInputStream(fileName);
            ObjectInputStream ois;
            while (fis.available() > 0) {
                ois = new ObjectInputStream(fis);
                Gmail gmail = (Gmail) ois.readObject();
                list.add(gmail);
            }
            fis.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileGmail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileGmail.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileGmail.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

}
