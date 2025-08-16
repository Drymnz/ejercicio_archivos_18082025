package com.archivos.models;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.UUID;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import com.archivos.models.Plataform;


@Getter
@Setter
@EqualsAndHashCode(of = "id")

public class VideoGame implements Serializable{
    private final UUID id;
    private String title;
    private int hoursPlayerd;
    private boolean completed;
    private Plataform platform;
    
    public VideoGame(String title,Plataform platform ,int hoursPlayerd, boolean completed) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.hoursPlayerd = hoursPlayerd;
        this.completed = completed;
        this.platform = platform;
    }

    @Override
    public String toString() {
        return this.title + " - " + this.hoursPlayerd + " hours played - Completed: " + this.completed;
    }

    
    
}
