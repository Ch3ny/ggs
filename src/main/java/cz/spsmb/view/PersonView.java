package cz.spsmb.view;
import cz.spsmb.dao.BrandRepository;
import cz.spsmb.dao.CarRepository;
import cz.spsmb.dto.Cardto;
import cz.spsmb.dto.Persondto;
import cz.spsmb.model.Brand;
import cz.spsmb.model.Car;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.core.Response;
import org.primefaces.component.card.Card;


import java.util.List;
import java.util.Map;
import java.util.Optional;

@Named
@ApplicationScoped
public class PersonView {

    @Inject
    BrandRepository brandRepository;
    @Inject
    CarRepository carRepository;
    List<Car> cars;
    Persondto newGuy;
    Cardto newCar;
    List<Brand> brandList;




    @PostConstruct
    public void init() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String categoryName = params.get("category");

        System.out.println(categoryName);

        cars = carRepository.listAll();
        System.out.println(cars);

        Optional<Car> brands = carRepository.listOp("BMW");
        if (brands.isPresent()){
            brands = carRepository.listOp("BMW");
        }
        else {
            brands= carRepository.listOp("");
        }
       newCar =new Cardto();

    }

    public List<Car> getCar() {
        return cars;
    }

    public void setPeople(List<Car> cars) {
        this.cars = cars;
    }

    @Transactional
    public Response saveCar() {
        if (validateInput(newCar)) {
            Car car = new Car();
            car.setBrand(newCar.getBrand());
            car.setModel(newCar.getModel());
            Optional<Car> brandOptional = carRepository.listOp(newCar.getBrand());

            if (brandOptional.isPresent()) {

                car.setModel(brandOptional.get().toString());
            } else {
                Brand brand = new Brand();
                brand.setName(newCar.getBrand());
                brandRepository.persist(brand);
                brand.setName(brand.toString());
            }
            carRepository.persist(car);
            return Response.ok().entity("ok").build();
        }
        return Response.status(400).entity("Invalid inputs").build();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Cardto getNewCar() {
        return newCar;
    }

    public void setNewCar(Cardto newCar) {
        this.newCar = newCar;
    }

    public List<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Brand> cateroeies) {
        this.brandList = cateroeies;
    }

    private boolean validateInput(Cardto cardto) {
        return !(cardto.getBrand().isEmpty() || cardto.getModel().isEmpty() || cardto.getPrice() == 0);
    }
}
