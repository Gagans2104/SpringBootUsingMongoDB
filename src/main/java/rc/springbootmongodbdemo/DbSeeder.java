package rc.springbootmongodbdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {

    private HotelRepository hotelRepository;

    public DbSeeder(HotelRepository hotelRepository){
        this.hotelRepository = hotelRepository;
    }

    @Override
    public void run(String... strings) throws Exception{
        Hotel marriot = new Hotel(
                "Marriot",
                130,
                new Address("Paris","France"),
                Arrays.asList(
                        new Review("John", 8,false),
                        new Review("Marry",9,true)
                )
        );
        Hotel raddison = new Hotel(
                "Raddison",
                190,
                new Address("Venice","Italy"),
                Arrays.asList(
                        new Review("John", 6,false),
                        new Review("Marry",5,true)
                )
        );
        Hotel submarine = new Hotel(
                "Submarine",
                210,
                new Address("Manchester","United"),
                new ArrayList<>()
        );

        this.hotelRepository.deleteAll();

        List<Hotel> hotels = Arrays.asList(marriot,raddison,submarine);
        this.hotelRepository.saveAll(hotels);

    }
}
