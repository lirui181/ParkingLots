package bussiness;

import java.util.ArrayList;

public class ParkMagService {

	/**
	 * 返回空位数最多的停车场
	 * @param parks
	 * @return
	 */
	public Park getBlankMostPark(ArrayList<Park> parks) {
		// TODO Auto-generated method stub
		Park park=null;
		int blankPlace=0;
		for(int i=0;i<parks.size();i++)
		{
			if(parks.get(i).getSurplusCars()>blankPlace)
			{
				park=parks.get(i);
				blankPlace=parks.get(i).getSurplusCars();//停车场剩余停车位
			}
		}
		return park;
	}

	/**
	 * 返回空置率最大的停车场
	 * @param parks
	 * @return
	 */
	public Park getBlankRateMostPark(ArrayList<Park> parks) {
		// TODO Auto-generated method stub
		Park park=null;
		float blankPlace=0;
		for(int i=0;i<parks.size();i++)
		{
			if(parks.get(i).getBlankRate()>blankPlace)
			{
				park=parks.get(i);
				blankPlace=parks.get(i).getBlankRate();//停车场剩余停车位
			}
		}
		return park;
	}
	/**
	 * 输出停车仔管理的停车场信息
	 * @param staff
	 */
	public void printStaffInfo(Staff staff)
	{
		ArrayList<Park> parks=staff.getParks();
		Park park=null;
		int totalNo=0;//总车位数
		int totalSurplusNo=0;//总剩余车位数
		for(int i=0;i<parks.size();i++)
		{
			park=parks.get(i);
			totalNo+=park.getTotalParkPlace();
			totalSurplusNo+=park.getSurplusCars();
			System.out.println("停车场编号："+park.getParkNo());
			System.out.println("\t车位数："+park.getTotalParkPlace());
			System.out.println("\t空位数："+park.getSurplusCars());
		}
		System.out.println("Total车位数："+totalNo);
		System.out.println("Total空位数："+totalSurplusNo);
		
	}

	/**
	 * 取车
	 * @param parks
	 * @param carNo
	 * @return
	 */
	public boolean pickUpCar(ArrayList<Park> parks, String carNo) {
		// TODO Auto-generated method stub
		boolean tag=false;
		Park park=null;
		int i;
		for(i=0;i<parks.size();i++)
		{
			park=parks.get(i);
			tag=park.takeCar(carNo);
			if(tag)//取到车
			{
				break;
			}
		}
		return tag;
	}

	/**
	 * 打印停车仔和停车场信息
	 * @param manager
	 */
	public void printManagerInfo(Manager manager) {
		// TODO Auto-generated method stub
		//所管理停车仔信息
		ArrayList<Staff> staffs=manager.getStaffs();
		//所管理停车场信息
		ArrayList<Park> parks=manager.getParks();
		
		Staff staff=null;
		Park park=null;
		int j;
		int totalNo=0;//总车位数
		int totalSurplusNo=0;//总剩余车位数
		int totalPlace,leftPlace;
		for(int i=0;i<staffs.size();i++)
		{
			staff=staffs.get(i);
			System.out.println("停车仔编号："+staff.getNumber());
			totalPlace=0;
			leftPlace=0;
			for(j=0;j<staff.getParksNo();j++)
			{
				park=staff.getParks().get(j);
				totalPlace+=park.getTotalParkPlace();
				leftPlace+=park.getSurplusCars();
				System.out.println("\t停车场编号："+park.getParkNo());
				System.out.println("\t\t车位数："+park.getTotalParkPlace());
				System.out.println("\t\t空位数："+park.getSurplusCars());
			}
			System.out.println("\tTotal车位数："+totalPlace);
			System.out.println("\tTotal空位数："+leftPlace);
			totalNo+=totalPlace;
			totalSurplusNo+=leftPlace;
		}
		//打印自己管理的停车场
		for(int i=0;i<parks.size();i++)
		{
			park=parks.get(i);
			totalNo+=park.getTotalParkPlace();
			totalSurplusNo+=park.getSurplusCars();
			System.out.println("停车场编号："+park.getParkNo());
			System.out.println("\t车位数："+park.getTotalParkPlace());
			System.out.println("\t空位数："+park.getSurplusCars());
		}
		
		System.out.println("Total车位数："+totalNo);
		System.out.println("Total空位数："+totalSurplusNo);
	}

	/**
	 * 打印经理、停车仔和停车场信息
	 * @param director
	 */
	public void printDirectorInfo(Director director) {
		// TODO Auto-generated method stub
		//所管理停车场信息
		ArrayList<Manager> managers=director.getManagers();
		
		ArrayList<Staff> staffs;
		ArrayList<Park> parks;
		
		Manager manager=null;
		Staff staff=null;
		Park park=null;
		int j,k,m;
		int totalNo=0;//总车位数
		int totalSurplusNo=0;//总剩余车位数
		int totalPlace,leftPlace;
		int totalPlace1,leftPlace1;
		for(int i=0;i<managers.size();i++)
		{
			manager=managers.get(i);
			staffs=manager.getStaffs();//所管理停车仔
			parks=manager.getParks();//所管理停车场
			totalPlace1=0;
			leftPlace1=0;
			System.out.println("停车场经理编号："+manager.getNumber());
			for(k=0;k<staffs.size();k++)
			{
				staff=staffs.get(k);
				System.out.println("\t停车仔编号："+staff.getNumber());
				totalPlace=0;
				leftPlace=0;
				for(j=0;j<staff.getParksNo();j++)
				{
					park=staff.getParks().get(j);
					totalPlace+=park.getTotalParkPlace();
					leftPlace+=park.getSurplusCars();
					System.out.println("\t\t停车场编号："+park.getParkNo());
					System.out.println("\t\t\t车位数："+park.getTotalParkPlace());
					System.out.println("\t\t\t空位数："+park.getSurplusCars());
				}
				System.out.println("\t\tTotal车位数："+totalPlace);
				System.out.println("\t\tTotal空位数："+leftPlace);
				totalPlace1+=totalPlace;
				leftPlace1+=leftPlace;
			}
			totalNo+=totalPlace1;
			totalSurplusNo+=leftPlace1;
			//打印自己管理的停车场
			for(m=0;m<parks.size();m++)
			{
				park=parks.get(m);
				totalNo+=park.getTotalParkPlace();
				totalSurplusNo+=park.getSurplusCars();
				System.out.println("\t停车场编号："+park.getParkNo());
				System.out.println("\t\t车位数："+park.getTotalParkPlace());
				System.out.println("\t\t空位数："+park.getSurplusCars());
			}
			System.out.println("\tTotal车位数："+totalPlace1);
			System.out.println("\tTotal空位数："+leftPlace1);
		}
		System.out.println("Total车位数："+totalNo);
		System.out.println("Total空位数："+totalSurplusNo);
	}

}
