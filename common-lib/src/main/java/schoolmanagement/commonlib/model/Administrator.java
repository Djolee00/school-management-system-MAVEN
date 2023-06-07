package schoolmanagement.commonlib.model;

import java.io.Serializable;
import java.time.LocalDate;


public class Administrator extends User implements Serializable{
    
    private LocalDate employmentDate;
    
    public Administrator(Long id,String username, String password,LocalDate employmentDate) {
        super(id,username, password);
        this.employmentDate = employmentDate;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    @Override
    public String toString() {
        return "Administrator{id= "+super.getId()+" username= "+super.getUsername()+" password= "+super.getPassword() + "employmentDate=" + employmentDate + '}';
    }
    
    
}
