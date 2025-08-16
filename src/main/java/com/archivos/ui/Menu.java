package com.archivos.ui;
import java.util.Scanner;
import java.util.UUID;

import com.archivos.services.VideoGameService;
import com.archivos.models.Plataform;
import com.archivos.models.VideoGame;


public class Menu {

    private final VideoGameService service;
    private final Scanner scanner = new Scanner(System.in);

    public Menu(VideoGameService service) {
        this.service = service;
    }
    
    public void showMenu() {
        int option;
        do {
            System.out.println("\n===== MENÚ VIDEOJUEGOS =====");
            System.out.println("1. Agregar video juego");
            System.out.println("2. Mostrar todos los video juegos");
            System.out.println("3. Buscar videojuego por ID");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            option = readInt();
            switch (option) {
                case 1:
                    addVideoGame();
                    break;
                case 2:
                    service.showVideoGames();
                    break;
                case 3:
                    findVideoGameById();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        } while (option != 4);
    }

    private void addVideoGame() {
        System.out.print("Ingrese el nombre del video juego: ");
        String title = scanner.nextLine();
        System.out.print("Ingrese la plataforma: ");
        Plataform platform = Plataform.valueOf(scanner.nextLine());
        System.out.print("Ingrese horas jugadas: ");
        int hours = readInt();
        System.out.print("¿Completado? (true/false): ");
        boolean completed = readBoolean();
        VideoGame game = new VideoGame(title, platform, hours, completed);
        service.addVideoGame(game);
    }

    private void findVideoGameById() {
        System.out.print("Ingrese el UUID del video juego: ");
        String idStr = scanner.nextLine();
        try {
            UUID id = UUID.fromString(idStr);
            service.printVideoGameById(id);
        } catch (IllegalArgumentException e) {
            System.out.println("UUID inválido.");
        }
    }

    private int readInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Número inválido. Intente de nuevo: ");
            }
        }
    }

    private boolean readBoolean() {
        while (true) {
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("true")) return true;
            if (input.equals("false")) return false;
            System.out.print("Valor inválido. Escriba true o false: ");
        }
    }

}