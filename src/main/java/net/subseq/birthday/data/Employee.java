package net.subseq.birthday.data;



import org.joda.time.Days;
import org.joda.time.LocalDate;

public class Employee {

 	public Employee(String firstname, String lastname, LocalDate birthday, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthday = birthday;
        this.age= age;
        this.daysbetween = this.getDays_next_birthday();
    }

	private String firstname;
    private String lastname;
    private LocalDate birthday;
    private int age;
    
    public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getDaysbetween() {
		return daysbetween;
	}

	public void setDaysbetween(long daysbetween) {
		this.daysbetween = daysbetween;
	}

	private long daysbetween;
    
    public String getFirstname() {
        return firstname;
    }

    public long getDays_next_birthday() {
    	LocalDate bday_this_year = birthday.plusYears(LocalDate.now().getYear() - birthday.getYear());
    	long daysbetween = Days.daysBetween(LocalDate.now(), bday_this_year).getDays();
    	return daysbetween;
	}


	public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
