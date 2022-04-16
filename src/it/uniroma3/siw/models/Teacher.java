package it.uniroma3.siw.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Teacher {
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
	private String vatNumber;
	
	/*
	 * Strategia Lazy perché si tratta di una collezione potenzialmente numerosa, e non è una composizione, quindi potrebbe non essere richiesto consultarlo
	 * Inoltre, non essendo una composizione, non metto nemmeno il cascade su persist e merge.
	 */
	@OneToMany(mappedBy="lecturer",fetch = FetchType.LAZY)
	@Column(nullable = false)
	private List<Course> coursesHeld;
	
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

	public String getVatNumber() {
		return vatNumber;
	}

	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}

	public List<Course> getCoursesHeld() {
		return coursesHeld;
	}

	public void setCoursesHeld(List<Course> coursesHeld) {
		this.coursesHeld = coursesHeld;
	}

}
