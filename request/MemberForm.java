package sgsits.cse.dis.academics.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.Getter;
//import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberForm {

	@NotBlank(message = "MemberId cannot be empty")
	private String memberId;

	@NotBlank(message = "Name cannot be empty")
	private String name;
	
	@NotBlank(message = "Designation cannot be empty")
	private String designation;

	private String email;

	private long mobileNo;
	
	private String dob;
}
