
public class Station { // คลาสของสถานีรถไฟฟ้า

    private final int sid;        // หมายเลขสถานี
    private final String name;    // ชื่อสถานี

    public Station(int id, String name) {
// สร้างสถานีที่มีหมายเลข (id) และชื่อสถานี(name)
// ก าหนดให้หมายเลขสถานีเป็นจ านวนเต็ม โดยสถานีที่ติดกัน
// มีค่าห่างกัน 1
        this.sid = id;
        this.name = name;
    }

    public int getPrice(Station other) {
// คืนค่าโดยสารระหว่างสถานีปัจจุบัน และ other
        return Math.abs(this.sid - other.sid) * 5;
    }

    public String getName() {//คืนค่าชื่อสถานี
        return name;
    }
//@Override

    public String toString() {
// แสดงสถานี ที่มีหมายเลข (id) และชื่อสถานี(name)
        return "(" + this.sid + "," + this.name + ")";
    }
}
