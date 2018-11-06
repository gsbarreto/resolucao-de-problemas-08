package gabrielbarreto.alunos.utfpr.edu.br.ex08.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Employee {

	private @Id @GeneratedValue Long id;
	private String name;
	private int age;
        private float salary;

        public Employee(){
            
        }
        
	public Employee(String name, int age, float salary) {
		this.name = name;
		this.age = age;
                this.salary = salary;
	}
}