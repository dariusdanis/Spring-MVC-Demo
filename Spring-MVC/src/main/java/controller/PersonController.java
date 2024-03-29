package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import repositories.CompanyRepository;
import repositories.PersonRepository;

import entities.Address;
import entities.Person;

@Controller
public class PersonController {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private CompanyRepository companyRepository;

	@RequestMapping(value = "/person", params = "add", method = RequestMethod.GET)
	public String getAddPerson() {
		return "person/add";
	}

	@RequestMapping(value = "/person", params = "edit", method = RequestMethod.GET)
	public String getEditPerson(@RequestParam long id, Model model) {
		model.addAttribute("person", personRepository.findOne(id));
		model.addAttribute("managers", personRepository.findAll());
		model.addAttribute("employers", companyRepository.findAll());
		return "person/edit";
	}

	@RequestMapping(value = "/person", method = RequestMethod.GET)
	public String getViewPerson(@RequestParam long id, Model model) {
		model.addAttribute("person", personRepository.findOne(id));
		return "person/view";
	}
	
	@RequestMapping(value = "/person", params = "add", method = RequestMethod.POST)
	public String postAddPerson(@RequestParam String name,
			@RequestParam String street, @RequestParam String city,
			@RequestParam String state, @RequestParam String zip) {
		
		Address address = new Address(street, city, state, zip);
		Person person = new Person(name, address);
		person = personRepository.save(person);
		return "redirect:person?id=" + person.getId();
	}
	
	@Transactional
	@RequestMapping(value = "/person", params = "edit", method = RequestMethod.POST)
	public String postEditPerson(@RequestParam long id,
			@RequestParam String name, @RequestParam String street,
			@RequestParam String city, @RequestParam String state,
			@RequestParam String zip, @RequestParam("manager_id") long managerId,
			@RequestParam("employer_id") long employerId) {
		Person person = personRepository.findOne(id);
		Address address = person.getAddress();
		person.setName(name);
		person.setEmployer(companyRepository.findOne(employerId));
		person.setManager(personRepository.findOne(managerId));
		address.setStreet(street);
		address.setCity(city);
		address.setState(state);
		address.setZip(zip);
		personRepository.save(person);
		return "redirect:person?id=" + person.getId();
	}

	@RequestMapping(value = "/person", params = "delete", method = RequestMethod.POST)
	public String postDeletePerson(@RequestParam long id) {
		personRepository.delete(id);
		return "redirect:contacts";
	}

}