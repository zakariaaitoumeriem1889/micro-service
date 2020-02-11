package org.sid.microservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface StudentRepository extends JpaRepository<Student, Long> {
    @RestResource(path = "/byName")
    public List<Student> findByNameContains(@Param("mc") String mc);
}
