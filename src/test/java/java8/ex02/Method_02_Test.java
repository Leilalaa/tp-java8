package java8.ex02;

import java.util.List;

import org.junit.Test;

import java8.data.Data;
import java8.data.Person;

/**
 * Exercice 02 - Redéfinition
 */
public class Method_02_Test {

    // tag::IDao[]
    interface IDao {
        List<Person> findAll();
        
        default String format(){
        	
        	int cpt = 0;
        	String nbPersons = new String();
        	
        	for (Person person: findAll()){
        		
        		cpt++;
        		
        	}
        	
        	nbPersons += "["+cpt+" persons]";
        	return nbPersons;
        	
        }

        // TODO créer une méthode String format()
        // TODO la méthode retourne une chaîne de la forme [<nb_personnes> persons]
        // TODO exemple de résultat : "[14 persons]", "[30 persons]"
    }
    // end::IDao[]

    // tag::DaoA[]
    class DaoA implements IDao {

        List<Person> people = Data.buildPersonList(20);

        @Override
        public List<Person> findAll() {
            
        	return people;           	
            	
            }
        
        public String format(){
        
        	String nbPersons = new String();
        	
        	
        	nbPersons = "DaoA"+IDao.super.format();
        	return nbPersons;
       
        }

        // TODO redéfinir la méthode String format()
        // TODO la méthode retourne une chaîne de la forme DaoA[<nb_personnes> persons]
        // TODO exemple de résultat : "DaoA[14 persons]", "DaoA[30 persons]"
        // TODO l'implémentation réutilise la méthode format() de l'interface

    }
    // end::DaoA[]

    @Test
    public void test_daoA_format() throws Exception {

        DaoA daoA = new DaoA();

        // TODO invoquer la méthode format() pour que le test soit passant
        String result = null;
        result = daoA.format();

        "DaoA[20 persons]".equals(result);
    }
}
