package sgsits.cse.dis.academics.request;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class EditMagazineForm {

    private String magazineId;

    public String memberName;

    private String title;

    private String topic;

    private String article;

    private String submittedByName;

    private String submittedByDesignation;
}
