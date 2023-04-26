package lk.developersstack.lms.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class RegistrationIds implements Serializable {
    private long studentId;
    private long programId;
}
