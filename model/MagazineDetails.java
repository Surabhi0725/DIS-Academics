package sgsits.cse.dis.academics.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Getter 
@Setter 
@NoArgsConstructor
@Table(name = "magazine_details")
public class MagazineDetails {

	@Id
	@Column(name = "magazine_id", nullable = false)
	@GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name="UUID",
            strategy="org.hibernate.id.UUIDGenerator"
    )
	private String magazineId;

	@Column(name = "userId", nullable = false)
	private String userId;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "topic", nullable = false)
	private String topic;

	@Column(name = "article", nullable = false)
	private String article;

	@Column(name = "member_name", nullable = false)
	private String memberName;

	@Column(name = "member_designation", nullable = false)
	private String memberDesignation;
	
	@Column(name = "submittedby_name", nullable = false)
	private String submittedByName;
	
	@Column(name = "submittedby_designation", nullable = false)
	private String submittedByDesignation;
	
	@Column(name = "date", nullable = false)
	private String date;

	@Column(name = "status")
	private String status;

	@Lob
	@Column(name = "notesheet")
	private byte[] notesheet;

	@Column(name = "notesheet_file_type")
	private String notesheetFileType;

	@Column(name = "notesheet_extension")
	private String notesheetExtension;

	@Column(name = "remarks")
	private String remarks;

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberName() {
		return memberName;
	}
}
	