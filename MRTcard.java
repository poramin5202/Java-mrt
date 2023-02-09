
public class MRTcard {          // คลาสของบัตรโดยสารแบบเติมเงิน

    private int cid;            // สร้างบัตรโดยสารที่มีเลขบัตร (cid)
    private int value;          // เก็บเงินเริ่มต้น (value) ในบัตร
    private Station station;    // station เก็บว่าสถานีต้นทาง
    private final int[] status = new int[2];

    public MRTcard(int id, int value) {
// สร้างบัตรโดยสารที่มีเลขบัตร (id) และเงินเริ่มต้น (value)
// station เก็บว่าสถานีต้นทางคือสถานีอะไร
// โดยถ้าบัตรไม่ได้อยู่ระหว่างการเดินทาง จะเก็บค่า
// สถานีต้นทางนี้เป็นสตริงว่าง ๆ
        this.cid = id;
        this.value = value;
        this.station = new Station(id, "");
    }

    @Override
    public String toString() {
// แสดงสถานะของบัตร หมายเลขบัตร และเงินในบัตร
        return "(" + this.cid + "," + this.value + ")";
    }

    public void addValue(int x) {
//เพิ่มเงินในบัตรโดยสารเท่ากับ x โดยไม่ต้อง return
        value = value + x;
    }

    public boolean enter(Station station) {
//แตะบัตรเพื่อเข้าสู่สถานีรถไฟฟ้าให้เช็คว่าบัตรนี้ไม่ได้แตะเข้าที่สถานีอื่นมาก่อน
// ถ้าไม่มีการแตะเข้ามาก่อน ให้เปลี่ยนค่าสถานีต้นทางเป็น station แล้ว return true
//แต่ถ้ามีการแตะเข้าสถานีอื่นมาก่อน ให้ return false โดยไม่เปลี่ยนข้อมูลสถานีต้นทางของบัตรโดยสาร
        status[0] = status[0] + 1;
        if (status[0] == 1) {
            this.station = station;
            return true;
        } else {
            status[0] = 1;
            return false;
        }
    }

    public int[] leave(Station s) {
//แตะบัตรเพื่อออกจากสถานีรถไฟฟ้าให้เช็คว่าบัตรนี้มีข้อมูลสถานีต้นทางอยู่
// ถ้าไม่มีข้อมูลสถานีต้นทาง ให้ return อาเรย์ 1 มิติ (ตัวแปร status)ของเงินในบัตรและ -2
// ถ้ามีสถานีต้นทาง แต่จ านวนเงินในบัตรไม่พอจ่ายค่าโดยสาร ให้ return statusของเงินในบัตรและ -1
// ถ้ามีสถานีต้นทาง และจ านวนเงินในบัตรพอจ่ายค่าโดยสาร ให้ลบค่าโดยสารออกจากจ านวนเงินในบัตร
// เปลี่ยนสถานีต้นทางเป็นสตริงว่าง แล้ว return statusของเงินในบัตรหลังหักค่าโดยสารและ 0
        int[] d = {value, -2};

        if (status[0] == 1) {
            int p = station.getPrice(s);
            if ((value - p) < 0) {
                int[] y = {value, -1};
                return y;
            }
            value = value - p;
            int[] r = {value, 0};

            status[0] = 0;
            return r;
        } else {
            return d;
        }
    }

    public boolean lessThan(MRTcard rhs) {
// บัตรโดยสารที่มีเงินในบัตรน้อยกว่า จะถือว่าน้อยกว่า
        if (this.value < rhs.value) {
            return true;
        } else {
            return false;
        }
    }

    public String getStation() {
// แสดงสถานีต้นทาง ที่มีหมายเลข(id) และชื่อสถานี(name) ของบัตรใบนี้
        return station.toString();
    }
}
