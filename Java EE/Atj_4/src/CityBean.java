

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CityBean {
private ArrayList<String> cityList = new ArrayList<>();
	
	public ArrayList<String> getCityList() {
	return cityList;
}

public void setCityList(ArrayList<String> cityList) {
	this.cityList = cityList;
}

	public CityBean() {
		cityList.add("Warszawa");
		cityList.add("Berlin");
	}
}
