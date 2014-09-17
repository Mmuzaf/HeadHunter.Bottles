import java.awt.geom.Point2D;
import java.util.*;

/**
 * Created by Maksim.Muzafarov on 16.09.14.
 */
public class SearchAsTree {

    double X;
    double Y;

    Queue<Point2D> queue = new LinkedList<Point2D>();
    Set<Point2D> uniqueLeafs = new HashSet<Point2D>();
    Tree<Point2DComment> treeRoadMap;

    public SearchAsTree(int X, int Y) {
        this.X = X;
        this.Y = Y;
        Point2DComment point = new Point2DComment(0, 0, "HEAD");
        uniqueLeafs.add(point);
        queue.add(point);
        treeRoadMap = new Tree<Point2DComment>(point);
    }

    private void saveState(Point2D previousXY, Point2D XY, String comment) {
        if(!uniqueLeafs.contains(XY)) {
            Point2DComment newXY = new Point2DComment(XY.getX(), XY.getY(), comment);
            Point2DComment newPreviousXY = new Point2DComment(previousXY.getX(), previousXY.getY());
            //System.out.println(newXY.toString() + ";");
            uniqueLeafs.add(newXY);
            queue.add(newXY);
            treeRoadMap.addLeaf(newPreviousXY, newXY);
        }
    }

    private void calculateX(Point2D current) {
        //System.out.println("Begin [X]");
        Point2D result = (Point2D) current.clone();
        if (current.getX() == 0) {
            // set FULL;
            String commentFULL = "Set X FULL;";
            result.setLocation(this.X, current.getY());
            saveState(current, result, commentFULL);
            //return result;
        } else {
            //set EMPTY;
            String commentEMPTY = "Set X EMPTY;";
            result.setLocation(0, current.getY());
            saveState(current, result, commentEMPTY);

            double left = this.Y - current.getY();
            if (left != 0) {

                double to_pour;
                if (left < current.getX()) {
                    to_pour = left;
                } else {
                    to_pour = current.getX();
                }
                double newX = current.getX() - to_pour;
                double newY = current.getY() + to_pour;
                result.setLocation(newX, newY);
                String commentTransfer = "Transfer from X to Y value " + to_pour + ";";
                saveState(current, result, commentTransfer);
                //return result;
            }

        }

    }

    private void calculateY(Point2D current) {
        //System.out.println("Begin [Y]");
        Point2D result = (Point2D) current.clone();
        if (current.getY() == 0) {
            // set FULL;
            String commentFULL = "Set Y FULL;";
            result.setLocation(current.getX(), this.Y);
            saveState(current, result, commentFULL);
            //return result;
        } else {
            //set EMPTY;
            String commentEMPTY = "Set X EMPTY;";
            result.setLocation(current.getX(), 0);
            saveState(current, result, commentEMPTY);

            double left = this.X - current.getX();
            if (left != 0) {

                double to_pour;
                if (left < current.getY()) {
                    to_pour = left;
                } else {
                    to_pour = current.getY();
                }
                double newY = current.getY() - to_pour;
                double newX = current.getX() + to_pour;
                result.setLocation(newX, newY);
                String commentTransfer = "Transfer from Y to X value " + to_pour + ";";
                saveState(current, result, commentTransfer);
                //return result;
            }

        }

    }


    public void search(double goal) {
        Point2D position = null;// = new Point2D.Double(0, 0);
        //saveState(position, position, 0);

        while (!queue.isEmpty()) {
            position = queue.poll();
            if (goal == position.getX() || goal == position.getY()) {
                //last = position;
                break;
            }

            //System.out.println("[current] = " + position.toString());
            calculateX(position);
            calculateY(position);
            //System.out.println("-----------------------");
        }

        //System.out.println(uniqueLeafs.get(position).toString());
        //System.out.println("[out] = " + position.toString());
        //System.out.println(this.treeRoadMap.toString());
        if (!queue.isEmpty()) {
            List<Point2DComment> T2 = treeRoadMap.getAncestors(new Point2DComment(position));
            Collections.reverse(T2);
            for (Point2DComment p : T2) {
                System.out.println(p.toString() + " | " + p.getComment());
            }
        }
    }
}
