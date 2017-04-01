package internationalization;
import java.util.ListResourceBundle;

public class FirstBundle_en extends ListResourceBundle {

  public Object[][] getContents() {return contents;}
  static final Object[][] contents = {
  {"text.title","English title"},
  {"text.english","English"},
  {"text.polish","Polish"},
  {"text.choose","Choose language"}
  };
}