package com.ead.authuser.specification;

import com.ead.authuser.controllers.filters.UserFilter;
import com.ead.authuser.models.UserCourseModel;
import com.ead.authuser.models.UserModel;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class UserSpec {
    public static Specification<UserModel> filter(UserFilter params) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(params.getCpf() != null) {
                predicates.add(criteriaBuilder.equal(root.get("cpf"), params.getCpf()));
            }
            if(params.getFullName() != null) {
                predicates.add(criteriaBuilder.like(root.get("fullName"),"%"+params.getFullName()+"%"));
            }
            if(params.getEmail() != null) {
                predicates.add(criteriaBuilder.like(root.get("email"),"%"+params.getEmail()+"%"));
            }
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
    public static Specification<UserModel> filterUserByCourseId(UUID courseId) {
        return (root,query,builder) -> {
            var predicates = new ArrayList<>();
            query.distinct(true);
            Join<UserModel,UserCourseModel> userCourseRoot = root.join("usersCourse");

            if(courseId != null) {
                predicates.add(builder.equal(userCourseRoot.get("courseId"), courseId));
            }
            return builder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }
}
