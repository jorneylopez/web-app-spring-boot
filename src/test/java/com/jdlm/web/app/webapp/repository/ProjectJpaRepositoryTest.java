package com.jdlm.web.app.webapp.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.jdlm.web.app.webapp.model.Project;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ProjectJpaRepositoryTest {
    
    @Autowired
    IProjectJpaRepository projRepo;

    @Test
    public void projectTest() {
        Project proj1 = new Project("PROJECT1");
        proj1 = projRepo.save(proj1);
        assertNotNull(proj1);
        assertNotNull(proj1.getId());
        assertEquals("PROJECT1", proj1.getName());
        assertEquals(proj1.getId(), projRepo.findByName("PROJECT1").getId());
    }
}
