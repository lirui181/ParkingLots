package bussiness;

import java.util.ArrayList;

/**
 * 停车场停车仔类
 * @author zjw
 *2012-12-10
 */
public class Staff {

	private String name;//姓名
	private String number;//编号
	private ArrayList<Park> parks=new ArrayList<Park>();//停放车辆信息
	
	/**
	 * 构造函数
	 * @param name 姓名
	 * @param number 编号
	 */
	public Staff(String name,String number)
	{
		this.name=name;
		this.number=number;
	}
	/**
	 * 添加一个停车场
	 * @param park
	 */
	public void addPark(Park park)
	{
		parks.add(park);
	}
	/**
	 * 删除一个停车场
	 * @param parkNo
	 */
	public boolean removePark(String parkNo)
	{
		boolean reValue=false;
		Park park=null;
		for(int i=0;i<parks.size();i++)
		{
			park=parks.get(i);
			if(park.getParkNo().equals(parkNo))
			{
				parks.remove(i);
				reValue=true;
				break;
			}
		}
		return reValue;
	}
	/**
	 * 得到停车场个数
	 * @return
	 */
	public int getParksNo()
	{
		return parks.size();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public ArrayList<Park> getParks() {
		return parks;
	}
	public void setParks(ArrayList<Park> parks) {
		this.parks = parks;
	}
	
}
