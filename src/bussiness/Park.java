package bussiness;

import java.util.ArrayList;

/**
 * 停车场类
 * @author zjw
 *2012-12-12
 */
public class Park {

	private String parkNo;//停车场编号
	private int totalParkPlace;//总停车位
	private ArrayList<Car> cars=new ArrayList<Car>();//停放车辆信息
	
	/**
	 * 构造函数
	 * @param parkNo
	 * @param totalParkPlace
	 */
	public Park(String parkNo,int totalParkPlace)
	{
		this.parkNo=parkNo;
		this.totalParkPlace=totalParkPlace;
	}
	/**
	 * 得到停车场停放车辆总数
	 * @return
	 */
	public int getCars()
	{
		return cars.size();
	}
	/**
	 * 得到停车场剩余停车位
	 * @return
	 */
	public int getSurplusCars()
	{
		return totalParkPlace-cars.size();
	}
	/**
	 * 车辆进入停车场
	 * @param car
	 * @return
	 */
	public boolean addCar(Car car)
	{
		boolean reValue=true;
		if(getCars()>=totalParkPlace)
		{
			reValue=false;
			System.out.print("停车场（"+parkNo+"）已没有空位，车辆（"+car.getCarNo()+"）停放失败！");
		}else{
			cars.add(car);
		}
		return reValue;
	}
	/**
	 * 取车
	 * @param carNo
	 * @return
	 */
	public boolean takeCar(String carNo)
	{
		boolean reValue=false;
		Car car=null;
		for(int i=0;i<cars.size();i++)
		{
			car=cars.get(i);
			if(car.getCarNo().equals(carNo))
			{
				cars.remove(i);
				reValue=true;
				break;
			}
		}
		return reValue;
	}
	public float getBlankRate()
	{
		int carsLeft=this.getSurplusCars();//剩余卡数量
		float f1=carsLeft/(float)totalParkPlace;
		return f1;
	}
	/**
	 * 得到停车场编号
	 * @return
	 */
	public String getParkNo()
	{
		return parkNo;
	}
	public int getTotalParkPlace() {
		return totalParkPlace;
	}
	public void setTotalParkPlace(int totalParkPlace) {
		this.totalParkPlace = totalParkPlace;
	}
	public void setParkNo(String parkNo) {
		this.parkNo = parkNo;
	}
	public void setCars(ArrayList<Car> cars) {
		this.cars = cars;
	}
	
}
