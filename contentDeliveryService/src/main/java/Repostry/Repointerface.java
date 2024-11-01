package Repostry;

import model.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repointerface extends JpaRepository<Content, Long> {

}
