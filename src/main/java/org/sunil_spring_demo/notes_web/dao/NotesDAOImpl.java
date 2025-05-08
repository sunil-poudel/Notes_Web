package org.sunil_spring_demo.notes_web.dao;

import jakarta.persistence.EntityManager;
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

}
