package test;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import bussiness.Car;
import bussiness.Park;
import bussiness.ParkMagService;
import bussiness.Staff;
/**
 * 停车仔测试类
 * @author zjw dupeng
 *2012-12-12
 *2012-12-18
 */
public class StaffTest {

	private Staff staff1=null;//停车仔
	private int P1HAVENO=4;//停车场1停放车辆数
	private int P2HAVENO=10;//停车场2停放车辆数
	private int P3HAVENO=13;//停车场3停放车辆数
	
	/**
	 * 初始化
	 */
	@Before
	public void init(){
		Park park1=new Park("P001",30);//停车场1
		Park park2=new Park("P002",50);//停车场2
		Park park3=new Park("P003",70);//停车场3
		for(int i=0;i<P1HAVENO;i++)
		{
			park1.addCar(new Car("京 B000"+i));//剩余 26
		}
		for(int i=0;i<P2HAVENO;i++)
		{
			park2.addCar(new Car("京 C000"+i));//剩余 40
		}
		for(int i=0;i<P3HAVENO;i++)
		{
			park3.addCar(new Car("京 D000"+i));//剩余 58
		}
		staff1=new Staff("周杰伦","S001");//停车仔
		staff1.addPark(park1);
		staff1.addPark(park2);
		staff1.addPark(park3);
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
		Park aimPark=parkMagService.getBlankMostPark(staff1.getParks());
		Assert.assertEquals(aimPark.getParkNo(),"P003");
		boolean tag=aimPark.addCar(car1);
		Assert.assertEquals(tag,true);
		//输出停车场信息
		//System.out.println("----------------------停车场信息-停车（停在空位数最大的停车场）----------------------------");
		//parkMagService.printStaffInfo(staff1);
	}
	/**
	 * 测试车辆进入停车场
	 * 停在空置率最大的停车场
	 */
	@Test
	public void testCarin2()
	{
		ParkMagService parkMagService=new ParkMagService();
		Car car1=new Car("京 A0001");
		//停在空置率最大的停车场
		Park aimPark=parkMagService.getBlankRateMostPark(staff1.getParks());
		Assert.assertEquals(aimPark.getParkNo(),"P001");
		boolean tag=aimPark.addCar(car1);
		Assert.assertEquals(tag,true);
		//输出停车场信息
		//System.out.println("----------------------停车场信息-停车（停在空置率最大的停车场）----------------------------");
		//parkMagService.printStaffInfo(staff1);
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
		boolean tag=parkMagService.pickUpCar(staff1.getParks(),"京 A0001");
		Assert.assertEquals(tag,false);
		//输出停车场信息
		//System.out.println("-----------------------停车场信息-取车（凭证不对）---------------------------");
		//parkMagService.printStaffInfo(staff1);
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
		boolean tag=parkMagService.pickUpCar(staff1.getParks(),"京 B0001");
		Assert.assertEquals(tag,true);
		//输出停车场信息
		//System.out.println("-----------------------停车场信息-取车（凭证不对）---------------------------");
		//parkMagService.printStaffInfo(staff1);
	}
	/**
	 * 打印停车场信息
	 */
	@Test
	public void testPrintInfo()
	{
		ParkMagService parkMagService=new ParkMagService();
		System.out.println("-----------------------停车仔查看停车场信息---------------------------");
		parkMagService.printStaffInfo(staff1);
	}
}
