package internationalization;
import java.util.ListResourceBundle;

public class FirstBundle_es extends ListResourceBundle {

  public Object[][] getContents() {return contents;}
  static final Object[][] contents = {
  {"text.title","El titulo espanol"},
  {"text.english","ingles"},
  {"text.polish","polaco"},
  {"text.choose","Elige la lengua"}
  };
}