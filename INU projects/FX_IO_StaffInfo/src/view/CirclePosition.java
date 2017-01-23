package view;

/**
 * Created by karol_000 on 16.01.2017.
 */
public enum CirclePosition {

    POSITION1(70, 360),
    POSITION2(70, 250),
    POSITION3(75, 90),
    POSITION4(200, 90),
    POSITION5(225, 200),
    POSITION6(210, 370),
    POSITION7(435, 370),
    POSITION8(435, 250),
    POSITION9(560, 90),
    POSITION10(535, 200),
    POSITION11(690, 90),
    POSITION12(690, 255);

    private double x;
    private double y;

    private CirclePosition (double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }


}
