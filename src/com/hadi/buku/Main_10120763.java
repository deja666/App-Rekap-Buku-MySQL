/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hadi.buku;
import com.hadi.buku.view.FormAppBuku_10120763;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author JATINET
 */
public class Main_10120763 {
     public static void main(String[] args) {
        // TODO code application logic here
        try {
            UIManager.setLookAndFeel(new WindowsLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
        }
        new FormAppBuku_10120763().setVisible(true);
        
    }
}
