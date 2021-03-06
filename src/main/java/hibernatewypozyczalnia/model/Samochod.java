package hibernatewypozyczalnia.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Samochod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nazwa;
    private String marka;
    private LocalDate dataProdukcji;

    @Enumerated(EnumType.STRING)
    private TypNadwozia TypNadwozia;

    private  int iloscpasazerow;

}
