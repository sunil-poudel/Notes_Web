package org.sunil_spring_demo.notes_web;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.sunil_spring_demo.notes_web.dao.NotesDAO;
import org.sunil_spring_demo.notes_web.entity.Notes;

import java.util.List;

@SpringBootApplication
public class NotesWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotesWebApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(NotesDAO notesDAO){
        return runner -> {
//            createNote(notesDAO);
//            createMultipleNotes(notesDAO);

//            readNote(notesDAO, 4);
//            readMultipleNotes(notesDAO);

//            updateNote(notesDAO, new Notes("2072/10/13", "Tired", "Yesterday's party was too much"));

//            updateMultipleNotes(notesDAO,
//                List.of(1,2,4),
//                List.of(
//                        new Notes("2081/06/01", "Exciting", "Vacation has started"),
//                        new Notes("2082/01/12", "Frustrating", "There is war around the globe"),
//                        new Notes("2082/10/08", "Blessed", "Just finished year long project")
//                )
//            );

//            deleteNote(notesDAO, 2);

            deleteMultipleNotes(notesDAO);


        };
    }

    public void createNote(NotesDAO notesDAO){
        Notes note = new Notes("2081/01/25", "sad", "It's a long boring day!");
        notesDAO.createNote(note);
        System.out.println("Note created successfully!");
        System.out.println(note);
    }

    public void createMultipleNotes(NotesDAO notesDAO){
        List<Notes> notesList = List.of(
                new Notes("2081/01/01", "Cool", "It's raining"),
                new Notes("2072/01/12", "Frustrating", "There was just an earthquake"),
                new Notes("2072/10/12", "Happy", "Today's my birthday"),
                new Notes("2082/10/08", "Chill", "Just finished board exam")
        );
        notesDAO.createMultipleNotes(notesList);
        System.out.println("Notes created successfully!");
        for(Notes note:notesList){
            System.out.println(note);
        }
    }

    public void readNote(NotesDAO notesDAO, int id){
        Notes note = notesDAO.readNote(id);
        System.out.println("Note read successfully!");
        System.out.println(note);
    }

    public void readMultipleNotes(NotesDAO notesDAO){
        List<Notes> notes = notesDAO.readMultipleNotes();
        System.out.println("Note(s) read successfully!");
        System.out.println(notes);
    }

    public void updateNote(NotesDAO notesDAO, Notes note){
        notesDAO.updateNote(3,note);
        System.out.println("Note updated successfully!");
    }

    public void updateMultipleNotes(NotesDAO notesDAO, List<Integer> ids, List<Notes> updatedNotes){
        notesDAO.updateMultipleNotes(ids, updatedNotes);
    }

    public void deleteNote(NotesDAO notesDAO, int id){
        try {
            notesDAO.deleteNote(id);
            System.out.println("Note deleted successfully!");
        } catch (Exception e){
            System.out.println("Not found!");
        }

        //try catch is actually not needed, we can simply check if null is result because invalid id yields null

    }

    public void deleteMultipleNotes(NotesDAO notesDAO){
        notesDAO.deleteMultipleNotes();
    }

}
