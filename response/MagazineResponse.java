package sgsits.cse.dis.academics.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MagazineResponse {
	
	public String magazineId;

	public String title;
	
	public String topic;

	public String article;
	
	public String submittedByName;
	
	public String submittedByDesignation;

	public String memberName;

	public String date;
	
	public String status;

}
