package de.thws.students.students.boundary;

import de.thws.students.degreeprogrammes.entity.DegreeProgram;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@ApplicationScoped
public class DegreeProgramService {

    @PersistenceContext
    private EntityManager em;

    public DegreeProgram findByKey(String key) {

        return em.createQuery("SELECT dp FROM DegreeProgram dp WHERE dp.key = :key", DegreeProgram.class)
                .setParameter("key", key)
                .getSingleResult();

    }
}
