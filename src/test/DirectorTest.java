package test;

import org.junit.Before;
import org.junit.Test;

import bussiness.Car;
import bussiness.Director;
import bussiness.Manager;
import bussiness.Park;
import bussiness.ParkMagService;
import bussiness.Staff;

/**
 * 停车场主管测试类
 * @author zjw tony
 * 2012-12-16
 * 2012-12-19
 */
public class DirectorTest {

	private Director director=null;//停车场主管
	
	/**
	 * 初始化
	 */
	@Before
	public void init(){
		//---------------------经理1------------------------------------
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
		Manager manager1=new Manager("张三丰","M001");//停车场经理
		manager1.addStaff(staff1);
		manager1.addStaff(staff2);
		manager1.addPark(park6);
		manager1.addPark(park7);
		
		//---------------------经理2------------------------------------
		//---------------------停车仔------------------------------------
		Staff staff3=new Staff("周星驰","S003");//停车仔3
		Park park8=new Park("P008",70);//停车场
		Park park9=new Park("P009",125);//停车场
		Park park10=new Park("P010",85);//停车场
		for(int i=0;i<5;i++)
		{
			park8.addCar(new Car("京 L000"+i));
		}
		for(int i=0;i<47;i++)
		{
			park9.addCar(new Car("京 H000"+i));
		}
		for(int i=0;i<21;i++)
		{
			park10.addCar(new Car("京 M000"+i));
		}
		staff3.addPark(park8);
		staff3.addPark(park9);
		staff3.addPark(park10);
		//---------------------停车仔2------------------------------------
		Staff staff4=new Staff("李小龙","S004");//停车仔
		Park park11=new Park("P011",60);//停车场
		Park park12=new Park("P012",85);//停车场
		for(int i=0;i<25;i++)
		{
			park11.addCar(new Car("京 K000"+i));
		}
		staff4.addPark(park11);
		staff4.addPark(park12);
		//---------------------停车场------------------------------------
		Park park13=new Park("P013",120);//停车场13
		for(int i=0;i<19;i++)
		{
			park13.addCar(new Car("京 Q000"+i));
		}
		Manager manager2=new Manager("张无忌","M002");//停车场经理
		manager2.addStaff(staff3);
		manager2.addStaff(staff4);
		manager2.addPark(park13);
		
		director=new Director("王家卫");
		director.addManager(manager1);
		director.addManager(manager2);
	}
	@Test
	public void testPrintInfo()
	{
		ParkMagService parkMagService=new ParkMagService();
		System.out.println("-----------------------停车场主管查看经理、停车仔和停车场信息---------------------------");
		parkMagService.printDirectorInfo(director);
	}
}
