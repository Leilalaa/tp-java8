package java8.ex01;

import java.util.List;

import org.junit.Test;

import java8.data.Data;
import java8.data.Person;


/**
 * Exercice 01 - Méthode par défaut
 */
public class Method_01_Test {

    // tag::IDao[]
    interface IDao {
        List<Person> findAll();

        // La méthode sumAge retourne le résultat de l'addition des ages des personnes
        
        default int sumAge(){
        	int sum=0;
        	for (Person person: findAll()){
        		sum+=person.getAge();
        	}
        	return sum;
        }
    }
    // end::IDao[]

    class DaoA implements IDao {

        List<Person> people = Data.buildPersonList(20);

        @Override
        public List<Person> findAll() {
            return people;
        }
    }

    class DaoB implements IDao {

        List<Person> people = Data.buildPersonList(100);

        @Override
        public List<Person> findAll() {
            return people;
        }
    }

    @Test
    public void test_daoA_sumAge() throws Exception {

        DaoA daoA = new DaoA();


        
        int result = 0;
        result = daoA.sumAge();
        System.out.println(result);

        assert result == 210;
    }

    @Test
    public void test_daoB_sumAge() throws Exception {

        DaoB daoB = new DaoB();

        
        int result = 0;
        result = daoB.sumAge();
        System.out.println(result);

        assert result == 5050;

    }
}
