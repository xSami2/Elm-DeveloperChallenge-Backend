package com.elm.developerChallenge.Spec;

import com.elm.developerChallenge.DTO.CarFilter;
import com.elm.developerChallenge.Entity.CarEntity;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import java.math.BigDecimal;
import java.util.Objects;

@Data
public class CarSpec {

    public static Specification<CarEntity> createSpecification(CarFilter criteria) {
        return (root, query, builder) -> {
            Predicate predicate = builder.conjunction(); // Start with an always true predicate

            // Apply filters only for non-null search criteria
            if (criteria.getMaker() != null) {
                predicate = builder.and(predicate, builder.like(root.get("maker"), "%" + criteria.getMaker() + "%"));
            }
            if (criteria.getModel() != null) {
                predicate = builder.and(predicate, builder.like(root.get("model"), "%" + criteria.getModel() + "%"));
            }
            if (criteria.getModelYear() != null) {
                predicate = builder.and(predicate, builder.equal(root.get("modelYear"), criteria.getModelYear()));
            }
            if (criteria.getPrice() != null) {
                predicate = builder.and(predicate, builder.greaterThanOrEqualTo(root.get("price"), criteria.getPrice()));
            }

            if (criteria.getCarShowroomId() != null) {
                Join<Object, Object> carShowroom = root.join("carShowroom", JoinType.LEFT);
                predicate = builder.and(predicate, builder.equal(carShowroom.get("id"), criteria.getCarShowroomId()));
            }

            return predicate;
        };
    }

}
