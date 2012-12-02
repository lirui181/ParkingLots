import java.util.HashMap;
import java.util.Map;

public class ParkPlace {
    private Map<Ticket, Car> parkedCarList = new HashMap<Ticket, Car>();
    private Integer maxParkingNum;

    public Integer GetAvailableNum() {
        return maxParkingNum - parkedCarList.size();
    }

    public ParkPlace(int maxParkingNum) {
        this.maxParkingNum = maxParkingNum;
    }

    public Ticket parking(Car c) throws NoPlaceException {
        if (GetAvailableNum() == 0) {
            throw new NoPlaceException("没有停车位了！");
        }
        Ticket ticket = new Ticket();
        parkedCarList.put(ticket, c);
        return ticket;
    }

    public Car GetParkedCar(Ticket pp) throws NoCarException {
        if (parkedCarList.containsKey(pp)) {
            return parkedCarList.remove(pp);
        }
        throw new NoCarException("没有此车 请拨打110！");
    }
}
