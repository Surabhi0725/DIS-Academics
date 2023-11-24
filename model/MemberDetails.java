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
@Table(name = "member_details")
public class MemberDetails {

	@Id
    @Column(name = "member_id", nullable = false)
	@GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name="UUID",
            strategy="org.hibernate.id.UUIDGenerator"
    )
	private String memberId;
	
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "designation", nullable = false)
    private String designation;
    
    @Column(name = "email", nullable = false)
    private String email;
    
    @Column(name = "mobile_no", nullable = false)
    private long mobileNo;

}
