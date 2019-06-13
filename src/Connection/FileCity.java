/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import Data.TinhThanh;
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
public class FileCity {
    
    private static final String fileName = "FileCity.dat";
    
    public void createFile() {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(FileCity.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void addCity(TinhThanh tinhThanh) {
        createFile();
        try {
            FileOutputStream fos = new FileOutputStream(fileName, true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(tinhThanh);
            oos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileCity.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileCity.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteCity(TinhThanh tinhThanh) {
        ArrayList<TinhThanh> list = getCity();
        File file = new File(fileName);
        file.delete();
        createFile();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaTinh() == tinhThanh.getMaTinh()) {
                list.remove(i);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            addCity(list.get(i));
        }
    }
    
    public void editCity(int id, TinhThanh tinhThanh) {
        ArrayList<TinhThanh> list = getCity();
        File file = new File(fileName);
        file.delete();
        createFile();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaTinh() == id) {
                list.get(i).setMaTinh(tinhThanh.getMaTinh());
                list.get(i).setTenTinh(tinhThanh.getTenTinh());
            }
        }
        for (int i = 0; i < list.size(); i++) {
            addCity(list.get(i));
        }
    }
    
    public ArrayList<TinhThanh> getCity() {
        createFile();
        ArrayList<TinhThanh> list = new ArrayList<>();
        FileInputStream fis;
        try {
            fis = new FileInputStream(fileName);
            ObjectInputStream ois;
            while (fis.available() > 0) {
                ois = new ObjectInputStream(fis);
                TinhThanh tinhThanh = (TinhThanh) ois.readObject();
                list.add(tinhThanh);
            }
            fis.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileCity.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileCity.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileCity.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
