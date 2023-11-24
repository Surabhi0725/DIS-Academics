package sgsits.cse.dis.academics.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Entity
@Getter 
@Setter
@NoArgsConstructor
@Table(name = "expert_details")
public class ExpertDetails {
	
//	@Column(name = "created_by")
//	private String createdBy;
//	
//	@Column(name = "created_date")
//	private String createdDate;
//	
//	@Column(name = "modified_by")
//	private String modifiedBy;
//	
//	@Column(name = "modified_date")
//	private String modifiedDate;
	
	@Id
    @Column(name = "expert_id", nullable = false)
	@GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name="UUID",
            strategy="org.hibernate.id.UUIDGenerator"
    )
	private String expertId;
	
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "designation", nullable = false)
    private String designation;
    
    @Column(name = "email", nullable = false)
    private String email;
    
    @Column(name = "mobile_no", nullable = false)
   // @Size(max = 10, min=10)
    private Long mobileNo;
    
    @Column(name = "dob")
    private Date dob;
    
    @Column(name = "fathers_name")
    private String fathersName;
    
    @Column(name = "office_address")
    private String officeAddress;
    
    @Column(name = "pin_code")
   // @Size(max=6)
    private Long pinCode;
    
    @Column(name = "city")
    private String city;
    
    @Column(name = "state")
    private String state;
    
    @Column(name = "country")
    private String country;
    
    @Column(name = "aadhaar_no")
   // @Size(min=8, max = 8)
    private Long aadhaarNo;
    
    @Column(name = "pan_no")
    private String panNo;
    
    @Column(name = "gst_no")
    private String gstNo;
    
    @Column(name = "bank_name")
    private String bankName;
    
    @Column(name = "account_no")
    private Long accountNo;
    
    @Column(name = "ifsc")
    private String ifsc;
    
    @Column(name = "unique_teqip_id")
    private Long uniqueTeqipId;
    
    @Column(name = "type")
    private String type;

    @Override
    public String toString() {
        return "ExpertDetails{" +
                "expertId='" + expertId + '\'' +
                ", name='" + name + '\'' +
                ", designation='" + designation + '\'' +
                ", email='" + email + '\'' +
                ", mobileNo=" + mobileNo +
                ", dob=" + dob +
                ", fathersName='" + fathersName + '\'' +
                ", officeAddress='" + officeAddress + '\'' +
                ", pinCode=" + pinCode +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", aadhaarNo=" + aadhaarNo +
                ", panNo='" + panNo + '\'' +
                ", gstNo='" + gstNo + '\'' +
                ", bankName='" + bankName + '\'' +
                ", accountNo=" + accountNo +
                ", ifsc='" + ifsc + '\'' +
                ", uniqueTeqipId=" + uniqueTeqipId +
                ", type='" + type + '\'' +
                '}';
    }
}
