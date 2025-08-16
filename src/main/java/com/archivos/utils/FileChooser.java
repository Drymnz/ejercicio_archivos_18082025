package com.archivos.utils;

import javax.swing.JFileChooser;

public class FileChooser {
    private final static JFileChooser  filechooser;

    static {
        filechooser = new JFileChooser();
        filechooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        filechooser.setAcceptAllFileFilterUsed(false);
    }

    public static selectPath() {
        final int result = filechooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            return filechooser.getSelectedFile().getAbsolutePath();
        } else {
            return null;
        }
    }
}
