package org.sid.microservice;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "p1", types = Student.class)
public interface StudentProjection {
    public String getEmail();
    public String getName();
    public Laboratory getLaboratory();
}
