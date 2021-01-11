package ee.cdi;

import javax.inject.Named;

@Named
public class StartCDI {

    private String text = "CDI start";

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
