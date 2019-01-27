
package SUT.SE61.Team07.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import SUT.SE61.Team07.Repository.*;
import SUT.SE61.Team07.Entity.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

class DrugdataController {
    private DrugdataRepository drugdatarepository;
    private StaffRepository staffrepository;
    private MedicineRepository medicinerepository;
    private CategoryRepository categoryrepository;
    private CustomerRepository customerrepository;

    public DrugdataController(DrugdataRepository drugdatarepository, StaffRepository staffrepository,
            MedicineRepository medicinerepository, CategoryRepository categoryrepository,
            CustomerRepository customerrepository) {
        this.drugdatarepository = drugdatarepository;
        this.staffrepository = staffrepository;
        this.medicinerepository = medicinerepository;
        this.categoryrepository = categoryrepository;
        this.customerrepository = customerrepository;
    }

    @GetMapping("/Drugdata-list")
    public Collection<Drugdata> items() {
        return drugdatarepository.findAll();
    }

    

    @GetMapping("/Drugdata/{drugdataId}")
    public Drugdata DrugdataFinds(@PathVariable("drugdataId") Long drugdataId) {
        return drugdatarepository.findByDrugdataId(drugdataId);
    }

    @GetMapping("/Medicine")
    public Collection<Medicine> Medicine() {
        return medicinerepository.findAll();
    }

    @GetMapping("/Medicine/{medicineId}")
    public Optional<Medicine> takeinMedicineByid(@PathVariable Long medicineId) {
        return medicinerepository.findById(medicineId);
    }

    /*
     * @PostMapping("/MedicineData/addMedicineData")
     * 
     * public Drugdata newDrugdata(Drugdata newDrugdata,@RequestBody()
     * Map<String,Object> body) { Optional<Staff> staff =
     * staffRepository.findById(Long.valueOf(body.get("staff").toString()));
     * Optional<Category> category =
     * categoryRepository.findById(Long.valueOf(body.get("category").toString()));
     * Optional<Medicine> medicine =
     * medicineRepository.findById(Long.valueOf(body.get("medicine").toString()));
     * 
     * newDrugdata.setStaff(staff.get()); newDrugdata.setCategory(category.get());
     * newDrugdata.setMedicine(medicine.get());
     * newDrugdata.setBrand(body.get("brandName").toString());
     * newDrugdata.setDetail(body.get("detail").toString()); return
     * drugdataRepository.save(newDrugdata); }
     */

    // =============Staff====================
    /*
     * @GetMapping("/Staff") public Collection<Staff> staff() { return
     * staffRepository.findAll(); }
     */

    /*
     * @GetMapping("/Staff/{staffId}") public Optional<Staff>
     * takeinUserByid(@PathVariable Long userID) { return
     * staffRepository.findById(userID); }
     */

    // =============Medicine=================

    /*
     * @PostMapping("/Medicine/addMedicine/{medicineName}") public Medicine
     * newMedicine(@PathVariable String medicineName){ Medicine newMedicine = new
     * Medicine(medicineName); return medicineRepository.save(newMedicine); }
     */

    // =============Category==================
    /*
     * @GetMapping("/Category") public Collection<Category> Type() { return
     * categoryRepository.findAll(); }
     */
    /*
     * 
     * @GetMapping("/Category/{CategoryId}") public Optional<Category>
     * takeinTypeByid(@PathVariable Long categoryId) { return
     * categoryRepository.findById(categoryId); }
     */
    /*
     * @PostMapping("/Category/addCategory/{CategoryName}") public Category
     * newCategory(@PathVariable String categoryName){ Category newCategory = new
     * Category(categoryName); return categoryRepository.save(newCategory); }
     */
}