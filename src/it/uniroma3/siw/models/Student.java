package it.uniroma3.siw.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
	@Column(nullable = false)
	private String placeOfBirth;
	
	@Column(nullable = false)
	private Date dateOfBirth;
	
	@Column(nullable = false)
	private String studentId;
	
	@Column(nullable = false)
	private String emailAddress;
	
	/*
	 * Strategia EAGER perché si tratta di una OneToOne, e recuperare una istanza di un singolo oggetto non è costoso e ne vale la pena
	 * Cascade per il persist, perché così quando memorizzo un impiegato, memorizzo direttamente anche il datore di lavoro
	 */
	@OneToOne(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST})
	@Column(nullable = false)
	private Company employer;
	
	/*
	 * Strategia LAZY perché si tratta di una collezione potenzialmente numerosa, e non è una composizione, quindi potrebbe non essere richiesto consultarlo
	 * Inoltre, non essendo una composizione, non metto nemmeno il cascade su persist e merge.
	 */
	@ManyToMany(fetch = FetchType.LAZY)
	@Column(nullable = false)
	private List<Course> attendedCourses;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Company getEmployer() {
		return employer;
	}

	public void setEmployer(Company employer) {
		this.employer = employer;
	}

	public List<Course> getAttendedCourses() {
		return attendedCourses;
	}

	public void setAttendedCourses(List<Course> attendedCourses) {
		this.attendedCourses = attendedCourses;
	}
}
