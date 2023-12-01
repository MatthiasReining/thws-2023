package de.thws.students.degreeprogrammes.control;

import de.thws.students.degreeprogrammes.entity.DegreeProgram;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@ApplicationScoped
public class DegreeProgramService {

    @PersistenceContext
    private EntityManager em;

    public DegreeProgram findByKey(String key) {

        return em.createNamedQuery(DegreeProgram.FIND_BY_KEY, DegreeProgram.class)
                .setParameter(DegreeProgram.PARAM_KEY, key)
                .getSingleResult();

    }
}
