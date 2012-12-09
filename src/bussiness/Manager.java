package bussiness;

import java.util.ArrayList;

/**
 * 停车场经理类
 * @author zjw
 *2012-12-9
 */
public class Manager {

	private String name;//姓名
	private String number;//编号
	private ArrayList<Staff> staffs=new ArrayList<Staff>();//所管理停车仔信息
	private ArrayList<Park> parks=new ArrayList<Park>();//停放车辆信息
	
	/**
	 * 构造函数
	 * @param name 姓名
	 * @param number 编号
	 */
	public Manager(String name,String number)
	{
		this.name=name;
		this.number=number;
	}
	/**
	 * 添加多个停车仔
	 * @param managers
	 */
	public void addStaff(ArrayList<Staff> staffs)
	{
		this.staffs=staffs;
	}
	/**
	 * 添加一个停车仔
	 * @param manager
	 */
	public void addStaff(Staff staff)
	{
		staffs.add(staff);
	}
	/**
	 * 得到下属停车仔人员信息
	 * @return
	 */
	public ArrayList<Staff> getStaffs()
	{
		return staffs;
	}
	/**
	 * 得到停车仔个数
	 * @return
	 */
	public int getStaffsCount()
	{
		int count=staffs.size();
		return count;
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
	public void setStaffs(ArrayList<Staff> staffs) {
		this.staffs = staffs;
	}
	public ArrayList<Park> getParks() {
		return parks;
	}
	public void setParks(ArrayList<Park> parks) {
		this.parks = parks;
	}
	
}
