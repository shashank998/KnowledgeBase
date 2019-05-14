package com.altimetrik.knowledgeBase.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.altimetrik.knowledgeBase.entity.Problems;

public interface ProblemRepo extends JpaRepository<Problems, Integer> {

	@Query("select p from Problems p where p.problemStatement LIKE %:problemStatement%")
	List<Problems> getByProblemStatement(@Param("problemStatement") String problemStatement);

}
