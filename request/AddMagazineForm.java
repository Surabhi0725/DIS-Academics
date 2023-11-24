package sgsits.cse.dis.academics.request;

import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;

@Getter
public class AddMagazineForm {

	@NotBlank(message="Title cannot be empty")
	public String title;

	@NotBlank(message="Topic cannot be empty")
	public String topic;
	
	@NotBlank(message="Member name cannot be null")
	public String memberName;
	
	public String memberDesignation;
	
	public String date;

	public String coordinator;

	public String article;

	public String submittedByName;

	public String submittedByDesignation;

	public byte[] notesheet;

	public String notesheetFileType;

	public String notesheetExtension;

	public String remarks;
	
}
