package java8.ex02;

import java8.data.Account;
import java8.data.Data;
import java8.data.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercice 02 - Map
 */
public class Lambda_02_Test {

	// tag::PersonToAccountMapper[]
	interface PersonToAccountMapper<T> {
		T map(Person p);
	}
	// end::PersonToAccountMapper[]

	// tag::map[]
	private <T> List<T> map(List<Person> personList, PersonToAccountMapper<T> mapper) {

		List<T> accounts = new ArrayList<>();

		for (Person p : personList) {

			accounts.add(mapper.map(p));

		}

		return accounts;

	}
	// end::map[]

	// tag::test_map_person_to_account[]
	@Test
	public void test_map_person_to_account() throws Exception {

		List<Person> personList = Data.buildPersonList(100);
		PersonToAccountMapper mapperAcc = a -> new Account(a, 100);

		List<Account> result = map(personList, mapperAcc);

		assert result.size() == personList.size();
		for (Account account : result) {
			assert account.getBalance().equals(100);
			assert account.getOwner() != null;
		}
	}
	// end::test_map_person_to_account[]

	// tag::test_map_person_to_firstname[]

	// On créé un mapper qui transforme la liste de personnes en liste de prenom
	interface PersonToNameMapper {
		String map(Person p);
	}

	private List<String> map(List<Person> personList, PersonToNameMapper mapper) {

		List<String> noms = new ArrayList<String>();

		for (Person p : personList) {

			noms.add(mapper.map(p));

		}

		return noms;

	}

	@Test
	public void test_map_person_to_firstname() throws Exception {
		
		PersonToNameMapper mapperName = p -> new String(p.getFirstname());

		List<Person> personList = Data.buildPersonList(100);

		List<String> result = map(personList, mapperName);

		assert result.size() == personList.size();
		for (String firstname : result) {
			assert firstname.startsWith("first");
		}
	}
	// end::test_map_person_to_firstname[]
}
