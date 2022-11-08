package com.ead.course.repository;

import com.ead.course.models.Course;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CourseRepository extends JpaRepository<Course, UUID> {
    @EntityGraph(value = Course.MODULE_GRAPH, type = EntityGraph.EntityGraphType.FETCH)
    List<Course> findAll();
}
