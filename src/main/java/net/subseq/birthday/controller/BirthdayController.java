package net.subseq.birthday.controller;

import net.subseq.birthday.data.DataGenerator;

import net.subseq.birthday.data.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import org.joda.time.*;


@Controller
public class BirthdayController {

	// CONSTANTS
	static final int days = 21;
	static final int max_employees = 500;
	
    @RequestMapping(value = "/")
    public String index(Model model) {

        /*
            Zufällig generierte List von Mitarbeitern / employees.
            Jeder Mitarbeiter enthält folgende Daten:
                - String: firstname,
                - String: lastname and
                - LocalDate: birthday
        */
        List<Employee> employees = DataGenerator.getRandomEmployees(max_employees);


        /*  TODO Liste 'employees' filtern,
            sodass die Liste nur Mitarbeiter enthält,
            die in den nächsten 14 Tagen ihren Geburtstag feiern.
        */

        // STEP 1 - get upper date_range from now on
        
        LocalDate date_range = LocalDate.now().plusDays(days);
        System.out.println("max. Datum: " + date_range);
  
        // STEP 2 - remove employees from list
        
        for (int i = employees.size(); i >= 1; i--) {
       
        	LocalDate date_bday = employees.get(i-1).getBirthday();
        	date_bday = date_bday.plusYears(LocalDate.now().getYear() - date_bday.getYear());
        	
	        if (date_bday.isAfter(LocalDate.now()) && (date_bday.isBefore(date_range))) {	
	          // alles OK!
	        	System.out.println("ALLES OK:" + date_range + " > " + date_bday + " > " + LocalDate.now());
	        } else {
	     employees.remove(i-1);
	        }
         }
        
        int filter_employees = employees.size();
        
        // Liste zum 'Model' hinzufügen, um im Template darauf zuzugreifen
        model.addAttribute("employees", employees);
        model.addAttribute("days", days);
        model.addAttribute("max_employees", max_employees);
        model.addAttribute("filter_employees", filter_employees);
        
        // Template: templates/index.ftl
        return "index";
    }

}
