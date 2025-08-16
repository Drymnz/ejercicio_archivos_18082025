package com.archivos;

import com.archivos.services.VideoGameService;
import com.archivos.ui.Menu;
import com.archivos.utils.FileChooser;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println("Hello AXUI");
        String folderPath = FileChooser.selectPath();
        if (folderPath == null) {
            System.out.println("No se seleccionó ninguna carpeta. Saliendo...");
            return;
        }
        VideoGameService service = new VideoGameService(folderPath);
        Menu menu = new Menu(service);
        menu.showMenu();
    }
}
