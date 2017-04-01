

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CityBean2 {
	private ArrayList<City> cityList = new ArrayList<>();
	private int city;
	private String state;
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public CityBean2() {
		cityList.add(new City(1, "Warszawa"));
		cityList.add(new City(2, "Berlin"));
		cityList.add(new City(3, "Gold Coast"));
	}
	
	@Override
	public String toString() {
		return "CityBean2 [cityList=" + cityList + ", city=" + city + "]";
	}

	
	
	public ArrayList<City> getCityList() {
		return cityList;
	}
	public void setCityList(ArrayList<City> cityList) {
		this.cityList = cityList;
	}
	public int getCity() {
		return city;
	}
	public void setCity(int city) {
		this.city = city;
	}

}
