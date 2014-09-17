/**
 * Add comment here
 * <p/>
 * HeadHunter.Bottles
 * Pakage PACKAGE_NAME
 * By @author Mmuzaf
 * Created at 14.09.14
 */
public class Bottle {
    private final int bottleVolume;
    private int waterVolume;

    public Bottle(int bottleVolume) {
        this.bottleVolume = bottleVolume;
        this.waterVolume = 0;
    }

    public int getWaterVolume() {
        return this.waterVolume;
    }

    /**
     *
     * @param volume water volume to transfer
     * @return transferred water volume
     */
    public int fill(int volume) {
        //System.out.println("Bottle of volume [" + bottleVolume + "] -> fill -> " + someVolume);
        int waterTransferred;
        if (this.waterVolume + volume > this.bottleVolume) {
            waterTransferred = this.bottleVolume - this.waterVolume;
            this.waterVolume = this.bottleVolume;
        } else {
            this.waterVolume += volume;
            waterTransferred = volume;
        }
        return waterTransferred;
    }

    public void fillFull() {
        System.out.println("Bottle[" + bottleVolume + "] -> FULL;");
        this.fill(this.bottleVolume);
    }

    public void empty() {
        System.out.println("Bottle[" + bottleVolume + "] -> EMPTY;");
        this.waterVolume = 0;
    }

    public void transferTo(Bottle b) {
        int transferredWater = 0;
        transferredWater = b.fill(this.waterVolume);
        this.waterVolume -= transferredWater;
        System.out.println("Bottle[" + bottleVolume + "] -> transfer " +
                transferredWater + " to -> Bottle[" + b.bottleVolume + "];");
        System.out.println("Bottle[" + bottleVolume + "] " + this.waterVolume + " left;");
        System.out.println("Bottle[" + b.bottleVolume + "] " + b.waterVolume + " left;");

    }

    public boolean isFull() {
        return (this.waterVolume == this.bottleVolume);
    }

}
