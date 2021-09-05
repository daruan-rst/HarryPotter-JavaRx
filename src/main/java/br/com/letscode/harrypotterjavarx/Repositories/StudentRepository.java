package br.com.letscode.harrypotterjavarx.Repositories;

import br.com.letscode.harrypotterjavarx.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

    List<Student> findByName(String name);
}
