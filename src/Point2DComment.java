import java.awt.geom.Point2D;

/**
 * Add comment here
 * <p/>
 * HeadHunter.Bottles
 * Pakage PACKAGE_NAME
 * By @author Mmuzaf
 * Created at 17.09.14
 */
public class Point2DComment extends Point2D.Double {

    String comment;

    public Point2DComment(Point2D point) {
        super(point.getX(), point.getY());
        this.comment = null;
    }

    public Point2DComment(double X, double Y) {
        super(X, Y);
        this.comment = null;
    }

    public Point2DComment(double X, double Y, String comment) {
        super(X, Y);
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }
}
