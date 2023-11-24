package sgsits.cse.dis.academics.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Subject {
    private String subjectCode;
    private String subjectName;
}