package org.sunil_spring_demo.notes_web;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.sunil_spring_demo.notes_web.dao.NotesDAO;
import org.sunil_spring_demo.notes_web.entity.Notes;

@SpringBootApplication
public class NotesWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotesWebApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(NotesDAO notesDAO){
        return runner -> {
            createNote(notesDAO);
        };
    }

    public void createNote(NotesDAO notesDAO){
        Notes note = new Notes("2081/01/25", "happy", "It's a good day!");
        notesDAO.createNote(note);
        System.out.println("Note created successfully!");
        System.out.println(note);
    }

}
