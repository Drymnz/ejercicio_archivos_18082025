package com.archivos.utils;

import java.io.File;

import javax.swing.JFileChooser;

public class FileChooser {
    private final static JFileChooser  filechooser;

    static {
        filechooser = new JFileChooser();
        filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        filechooser.setAcceptAllFileFilterUsed(false);
    }

    public static String selectPath() {
    // Configurar el filechooser para seleccionar archivos y carpetas
    filechooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
    
    final int result = filechooser.showOpenDialog(null);
    if (result == JFileChooser.APPROVE_OPTION) {
        final File selectedFile = filechooser.getSelectedFile();
        final String path = selectedFile.getAbsolutePath();
        
        // Verificar si es archivo o carpeta para el mensaje
        if (selectedFile.isDirectory()) {
            System.out.println("Se selecciona carpeta: " + path);
        } else {
            System.out.println("Se selecciona archivo: " + path);
        }
        
        return path;
    } else {
        return null;
    }
}
}
