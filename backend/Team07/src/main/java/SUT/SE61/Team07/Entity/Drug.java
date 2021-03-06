package SUT.SE61.Team07.Entity;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import lombok.*;

@Entity
@Data
public class Drug {

     @Id
    @SequenceGenerator(name = "drug_seq", sequenceName = "drug_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "drug_seq")
    private  Long drugId;

    //@Size(min = 3, max = 20)
    private @NonNull String name;
    private @NonNull String price;
    
    private @NonNull String qty;
    


   private Drug(){}
   public Drug(String name,String price,String qty){
       this.name  = name;
       this.price = price;
       this.qty = qty;
       
   }
    
}