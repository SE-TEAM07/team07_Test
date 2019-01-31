package SUT.SE61.Team07;
//////////////////// System import ///////////

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Collections;
import java.util.OptionalInt;
import java.util.Set;
import java.util.Date;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


//////////////////// System import ///////////

 //////////////////////////////// all import //////////////////////////////
import SUT.SE61.Team07.Repository.*;
import SUT.SE61.Team07.Entity.*;
 //////////////////////////////// all import //////////////////////////////

@RunWith(SpringRunner.class)
@DataJpaTest
public class Team07ApplicationUnitTests {
	
	@Autowired
	private PrescriptionRepository prescriptionrepository;

	@Autowired
	private TestEntityManager entityManager;
	
	private Validator validator;

	@Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
	}
	
	 //ทดสอบ save data ปกติ
	 @Test
	 public void testTestInsertDataSuccess() {
		 Prescription mag = new Prescription();
		 mag.setPreId("1234567890TH");
		 mag.setDate(new Date());
		 try {
			 entityManager.persist(mag);
			 entityManager.flush();
		 } catch(javax.validation.ConstraintViolationException e) {
			 fail("Should not pass to this line");
		 }
	 }


	 @Test
	public void testTestPackageIdSizeLessThan8() {
        Prescription mag = new Prescription();
        mag.setPreId("1234TH");
        mag.setDate(new Date());
        try {
            entityManager.persist(mag);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            //คาดการว่าจะเกิด error เท้าไร
            assertEquals(violations.size(), 2);
        }
	}
	

	// ทดสอบห้ามเป็น not null
    @Test
	public void testTestPackageIdNotNull() {
        Prescription mag = new Prescription();
        mag.setPreId(null);
        mag.setDate(new Date());
        try {
            entityManager.persist(mag);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }


}

