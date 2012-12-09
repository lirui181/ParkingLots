package test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import bussiness.Car;
import bussiness.Manager;
import bussiness.Park;
import bussiness.ParkMagService;
import bussiness.Staff;

/**
 * 停车场经理测试类
 * @author zjw
 *2012-12-15
 *2012-12-20
 */
public class ManagerTest {

	private Manager manager1=null;//停车场经理
	
	/**
	 * 初始化
	 */
	@Before
	public void init(){
		//---------------------停车仔1------------------------------------
		Staff staff1=new Staff("周杰伦","S001");//停车仔1
		Park park1=new Park("P001",30);//停车场1
		Park park2=new Park("P002",50);//停车场2
		Park park3=new Park("P003",70);//停车场3
		for(int i=0;i<4;i++)
		{
			park1.addCar(new Car("京 B000"+i));//剩余 26
		}
		for(int i=0;i<10;i++)
		{
			park2.addCar(new Car("京 C000"+i));//剩余 40
		}
		for(int i=0;i<12;i++)
		{
			park3.addCar(new Car("京 D000"+i));//剩余 58
		}
		staff1.addPark(park1);
		staff1.addPark(park2);
		staff1.addPark(park3);
		//---------------------停车仔2------------------------------------
		Staff staff2=new Staff("阿杜","S002");//停车仔2
		Park park4=new Park("P004",100);//停车场4
		Park park5=new Park("P005",85);//停车场5
		for(int i=0;i<25;i++)
		{
			park4.addCar(new Car("京 E000"+i));//剩余 75
		}
		staff2.addPark(park4);
		staff2.addPark(park5);
		//---------------------停车场1------------------------------------
		Park park6=new Park("P006",45);//停车场6
		for(int i=0;i<5;i++)
		{
			park6.addCar(new Car("京 F000"+i));//剩余 40
		}
		Park park7=new Park("P007",200);//停车场7
		for(int i=0;i<47;i++)
		{
			park7.addCar(new Car("京 G000"+i));//剩余 153
		}
		manager1=new Manager("张三丰","M001");//停车场经理
		manager1.addStaff(staff1);
		manager1.addStaff(staff2);
		manager1.addPark(park6);
		manager1.addPark(park7);
	}
	/**
	 * 测试车辆进入停车场
	 * 停在空位数最大的停车场
	 */
	@Test
	public void testCarIn()
	{
		ParkMagService parkMagService=new ParkMagService();
		Car car1=new Car("京 A0001");
		//停在车位最多的停车场
		Park aimPark=parkMagService.getBlankMostPark(manager1.getParks());
		Assert.assertEquals(aimPark.getParkNo(),"P007");
		boolean tag=aimPark.addCar(car1);
		Assert.assertEquals(tag,true);
	}
	/**
	 * 测试车辆进入停车场
	 * 停在空置率最大的停车场
	 */
	@Test
	public void testCarIn2()
	{
		ParkMagService parkMagService=new ParkMagService();
		Car car1=new Car("京 A0001");
		//停在空置率最大的停车场
		Park aimPark=parkMagService.getBlankRateMostPark(manager1.getParks());
		Assert.assertEquals(aimPark.getParkNo(),"P006");
		boolean tag=aimPark.addCar(car1);
		Assert.assertEquals(tag,true);
	}
	/**
	 * 测试车辆出停车场
	 * 凭证不对
	 */
	@Test
	public void testCarOut1()
	{
		ParkMagService parkMagService=new ParkMagService();
		//取车
		boolean tag=parkMagService.pickUpCar(manager1.getParks(),"京 A0001");
		Assert.assertEquals(tag,true);
	}
	/**
	 * 测试车辆出停车场
	 * 凭证正确
	 */
	@Test
	public void testCarOut2()
	{
		ParkMagService parkMagService=new ParkMagService();
		//取车
		boolean tag=parkMagService.pickUpCar(manager1.getParks(),"京 G0001");
		Assert.assertEquals(tag,true);
	}
	/**
	 * 打印停车场信息
	 * 所管理停车仔信息
	 */
	@Test
	public void testPrintInfo()
	{
		ParkMagService parkMagService=new ParkMagService();
		System.out.println("-----------------------停车场经理查看停车仔和停车场信息---------------------------");
		parkMagService.printManagerInfo(manager1);
	}
}
