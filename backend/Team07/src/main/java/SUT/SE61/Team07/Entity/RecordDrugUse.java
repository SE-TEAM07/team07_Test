package SUT.SE61.Team07.Entity;

import lombok.*;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import java.util.Date;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.validation.constraints.*;

@Entity
@Data
public class RecordDrugUse {
    @Id
    @SequenceGenerator(name = "recorddrug_seq", sequenceName = "recorddrug_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recorddrug_seq")

    @NotNull
    private Long recorddrugId;

    @NotNull(message = "symptom  must not be null to be valid")
   // @Pattern(regexp = "\\w{0,3}\\d{8,13}")
    @Size(min = 10, max = 20)
    private String symptom;

    @NotNull
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "drugdataId")
    private Drugdata drugdata;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "staffId")
    private Staff staff;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId")
    private Customer customer;

    public RecordDrugUse() {
    }

    public RecordDrugUse(String symptom, Drugdata drugdata, Staff staff, Customer customer) {

        this.symptom = symptom;
        this.drugdata = drugdata;
        this.staff = staff;
        this.customer = customer;
        this.date = new Date();
    }

}