package atj;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean(name = "navigationController", eager = true)
@SessionScoped

public class NavigationController implements Serializable {

    public String moveToResultPage() {
        return "result";
    }

    public String moveToAllResultsPage() {
        return "allResultsPage";
    }

    public String moveToIndexPage() {
        return "index";
    }
}
