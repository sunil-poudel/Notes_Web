package org.sunil_spring_demo.notes_web.dao;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.sunil_spring_demo.notes_web.entity.Notes;

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

}
