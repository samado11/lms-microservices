package Repostry;

import model.questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface qestionRepository extends JpaRepository<questions, Long> {
}
