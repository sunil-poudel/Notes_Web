package org.sunil_spring_demo.notes_web.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.sunil_spring_demo.notes_web.entity.Notes;

import java.util.List;

@Repository
public class NotesDAOImpl implements NotesDAO{
    private EntityManager entityManager;

    @Autowired
    public NotesDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void createNote(Notes note) {
        entityManager.persist(note);
    }

    @Override
    @Transactional
    public void createMultipleNotes(List<Notes> notesList) {
        for(Notes note:notesList){
            entityManager.persist(note);
        }
    }

    @Override
    public Notes readNote(int id){
        Notes note = entityManager.find(Notes.class, id);
        return note;
    }

    @Override
    public List<Notes> readMultipleNotes() {
        TypedQuery<Notes> notes = entityManager.createQuery(
                "FROM Notes WHERE mood='happy'", Notes.class
        );
        return notes.getResultList();
    }

    @Override
    @Transactional
    public void updateNote(int id, Notes updatedNote) {
        Notes note = entityManager.find(Notes.class, id);
        note.setDate(updatedNote.getDate());
        note.setMood(updatedNote.getMood());
        note.setText(updatedNote.getText());
    }

    @Override
    @Transactional
    public void updateMultipleNotes(List<Integer> ids, List<Notes> updatedNotes) {
        int j=0;
        if(ids.size()==updatedNotes.size()) {
            for (int i : ids) {
                Notes note = entityManager.find(Notes.class, i);
                Notes updatedNote = updatedNotes.get(j);
                j++;

                note.setDate(updatedNote.getDate());
                note.setMood(updatedNote.getMood());
                note.setText(updatedNote.getText());
            }
            System.out.println("Notes updated successfully");

        } else{
            System.out.println("Invalid operation! Make sure number of ids and updated notes are same!!!");
        }
    }

    @Override
    @Transactional
    public void deleteNote(int id) {
        Notes note = entityManager.find(Notes.class, id);
        entityManager.remove(note);
    }

}
