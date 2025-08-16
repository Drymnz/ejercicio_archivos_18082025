package com.archivos.models;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.UUID;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = "id")

public class videojuego implements Serializable{
    private final UUID id;
    private String title;
    private int hoursPlayerd;
    private boolean completed;

    public videojuego(String title, int hoursPlayerd, boolean completed) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.hoursPlayerd = hoursPlayerd;
        this.completed = completed;
    }

    @Override
    public String toString() {
        return this.title + " - " + this.hoursPlayerd + " hours played - Completed: " + this.completed;
    }

    
    
}
