package gabrielbarreto.alunos.utfpr.edu.br.ex08.dao;

import gabrielbarreto.alunos.utfpr.edu.br.ex08.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee, Long> {

}