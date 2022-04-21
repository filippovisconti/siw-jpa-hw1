package it.uniroma3.siw.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private Date startDate;
	
	@Column(nullable = false)
	private Integer courseLengthInMonths;
	
	/*
	 * Strategia EAGER perché si tratta di una ManyToOne, e recuperare una istanza di un singolo oggetto non è costoso e ne vale la pena
	 * Cascade per il persist, perché così quando memorizzo un corso, memorizzo direttamente anche il docente
	 */
	@ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST})
	private Teacher lecturer;
	
	/*
	 * Strategia Lazy perché si tratta di una collezione potenzialmente numerosa, e non è una composizione, quindi potrebbe non essere richiesto consultarlo
	 * Inoltre, non essendo una composizione, non metto nemmeno il cascade su persist e merge.
	 */
	@ManyToMany(mappedBy="attendedCourses",fetch = FetchType.LAZY)
	private List<Student> attendingStudents;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Integer getCourseLengthInMonths() {
		return courseLengthInMonths;
	}

	public void setCourseLengthInMonths(Integer courseLengthInMonths) {
		this.courseLengthInMonths = courseLengthInMonths;
	}

	public Teacher getLecturer() {
		return lecturer;
	}

	public void setLecturer(Teacher lecturer) {
		this.lecturer = lecturer;
	}

	public List<Student> getAttendingStudents() {
		return attendingStudents;
	}

	public void setAttendingStudents(List<Student> attendingStudents) {
		this.attendingStudents = attendingStudents;
	}

}
