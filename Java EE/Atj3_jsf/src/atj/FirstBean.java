package atj;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class FirstBean {

  private String arg1;
  private String arg2;
  
  
  public String getArg1() {
    return(arg1);
  }
  public void setArg1(String arg1) {
    this.arg1 = arg1;
  }

  public String getArg2() {
    return arg2 ;
  }

  public void setArg2(String arg2) {
    this.arg2 = arg2;
  }

  
  public String getResult() {
	 int x = Integer.parseInt(arg1);
	 int y = Integer.parseInt(arg2);
	 int z = x+y;
	 
    return Integer.toString(z);
  }
  
  public void setResult(String result) {
  }
  
  
  public String computeResultActionControllerMethod() {
    return "result-page";  // Czyli idziemy do strony result-page.xhtml
  }
  public String enterArgumentsActionControllerMethod() {
	  return "calculator";  // Czyli idziemy do strony index.xhtml
  }
}