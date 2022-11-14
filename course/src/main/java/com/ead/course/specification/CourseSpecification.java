package com.ead.course.specification;


import com.ead.course.models.Course;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;

public class CourseSpecification {
    public static Specification<Course> filter(String description) {
        return (root,query,criteriaBuilder) -> {
          var predicates = new ArrayList<>();
          predicates.add(criteriaBuilder.like(root.get("description"),"%"+description+"%"));
          return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}
