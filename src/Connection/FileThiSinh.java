/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import Data.ThiSinh;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.function.UnaryOperator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Van Nam
 */
public class FileThiSinh {
    
    private static final String fileName = "FileStudent.dat";
    
    public void createFile() {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(FileThiSinh.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void addStudent(ThiSinh thiSinh) {
        createFile();
        FileOutputStream fos;
        try {
            fos = new FileOutputStream(fileName, true);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(thiSinh);
            oos.close();
            fos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileThiSinh.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileThiSinh.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void deleteStudent(ThiSinh thiSinh) {
        ArrayList<ThiSinh> list = getStudent();
        File file = new File(fileName);
        file.delete();
        createFile();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaThiSinh() == thiSinh.getMaThiSinh()) {
                list.remove(i);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            addStudent(list.get(i));
        }
    }
    
    public void editCity(int id, ThiSinh thiSinh) {
        ArrayList<ThiSinh> list = getStudent();
        File file = new File(fileName);
        file.delete();
        createFile();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getMaThiSinh() == id) {
                list.get(i).setMaThiSinh(thiSinh.getMaThiSinh());
                list.get(i).setTenThiSinh(thiSinh.getTenThiSinh());
                list.get(i).setNgaySinh(thiSinh.getNgaySinh());
                list.get(i).setMaQueQuan(thiSinh.getMaQueQuan());
                if (thiSinh.isGioiTinh() == "Nam") {
                    list.get(i).setGioiTinh(true);
                } else {
                    list.get(i).setGioiTinh(false);
                }
                list.get(i).setDiemToan(thiSinh.getDiemToan());
                list.get(i).setDiemLy(thiSinh.getDiemLy());
                list.get(i).setDiemHoa(thiSinh.getDiemHoa());
            }
        }
        for (int i = 0; i < list.size(); i++) {
            addStudent(list.get(i));
        }
    }
    
    public ArrayList<ThiSinh> getStudent() {
        createFile();
        ArrayList<ThiSinh> list = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois;
            while (fis.available() > 0) {
                ois = new ObjectInputStream(fis);
                ThiSinh thiSinh = (ThiSinh) ois.readObject();
                list.add(thiSinh);
            }
            fis.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileThiSinh.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FileThiSinh.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FileThiSinh.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
}
