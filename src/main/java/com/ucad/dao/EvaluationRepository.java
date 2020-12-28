package com.ucad.dao;

import com.ucad.entities.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource
public interface EvaluationRepository extends JpaRepository<Evaluation,Long> {
}
