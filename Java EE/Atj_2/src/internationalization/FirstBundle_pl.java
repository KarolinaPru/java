package internationalization;

import java.util.ListResourceBundle;

public class FirstBundle_pl extends ListResourceBundle {
  public Object[][] getContents() {return contents;}

  static final Object[][] contents = {
  {"text.title","Polski tytuł"},
  {"text.english","Angielski"},
  {"text.polish","Polski"},
  {"text.choose","Wybierz język"}  
  };
}