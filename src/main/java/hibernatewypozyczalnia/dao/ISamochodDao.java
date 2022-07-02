package hibernatewypozyczalnia.dao;

import hibernatewypozyczalnia.model.Samochod;

import java.util.List;
import java.util.Optional;

public interface ISamochodDao {
    //Add
    public void dodajSamochod(Samochod samochod);
    //Delete
    public void usunSamochod(Samochod samochod);
    //Read
    public Optional<Samochod> zwrocSamochod(Long id);
    // Read (select * from student)
    public List<Samochod> zwrocListeSamochodow();
    // Update
    public void updateSamochod(Samochod samochod);
}
