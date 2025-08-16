package com.archivos.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.archivos.models.videojuego;

public class VideoGamesService {
    private List<videojuego> videojuegos;
    private final String filePath;

    public VideoGamesService(String filePath) {
        this.filePath = filePath + File.separator + "list.bp";
        this.videojuegos = new ArrayList<>();
    }

    private void savedInFile() {
        // Logic to save the videojuego instance to a file
        try (ObjectOutputStream objeto = new ObjectOutputStream(new FileOutputStream(this.filePath))){
            objeto.writeObject(objeto);
        } catch (Exception e) {
            System.out.println("no de pudo GG");
            System.out.println(e.getMessage());
        }
    }

    private void loadDAta(){
        final File file = new File(this.filePath);
        if (file.exists()) {
            try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(file))) {
                final Object object = input.readObject();
                final List<videojuego> list = returVideojuegos(object);
                if (list == null) {
                    System.out.println("no existe");
                    return;
                }
                this.videojuegos = list;
                System.out.println("se cargo el juego");
            } catch (Exception e) {
                System.out.println("Error loading data: " + e.getMessage());
            }
        } else {
            this.videojuegos = new ArrayList<>();
        }
    }

    private List<videojuego> returVideojuegos(Object object) {
        if (!(object instanceof List<?>)) {
            final List<?> list = (List<?>) object;
            for (Object object2 : list) {
                
            }
            return (List<videojuego>) object;
        } else {
            System.out.println("Error: Object is not a List<videojuego>");
            return new ArrayList<>();
        }
    }
}
