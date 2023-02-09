public class MRTTest {
public static void main(String[] args) {
Station s1 = new Station(1,"Bang Sue");
Station s2 = new Station(3,"Bang Pho");
Station s3 = new Station(5,"Bang Phlat");
MRTcard b1 = new MRTcard(123,5);
MRTcard b2 = new MRTcard(999,10);
// --------------------------------------------------------------
b1.addValue(100);           // b1มีเงินในบัตร 105บาท
System.out.println(b1.toString());
boolean p = b1.enter(s1);   // p = true
System.out.println(p);
p = b1.enter(s3);  // p = false (แตะเข้าสถานีหลังจากแตะเข้าไปแล้ว)
System.out.println(p);
int []s = b1.leave(s2); // b1เหลือเงินในบัตร 95บาท โดย s = (95,0)
System.out.println(s[0]+","+s[1]);
// --------------------------------------------------------------
p = b2.enter(s3);   // p = true
System.out.println(p);
s = b2.leave(s1);   // b2มีเงินในบัตร 10บาทไม่พอจ่ายค่าโดยสาร โดย s = (10,-1)
System.out.println(s[0]+","+s[1]);
b2.addValue(50);    // b2มีเงินในบัตร 60บาท
System.out.println(b2.toString());
s = b2.leave(s1);   // b2เหลือเงินในบัตร 40บาท โดย s = (40,0)
System.out.println(s[0]+","+s[1]);
s = b2.leave(s2);   // s = (40,-2) (ยังไม่ได้แตะเข้าสถานี จึงไม่มีสถานีต้นทาง)
System.out.println(s[0]+","+s[1]);
p = b2.enter(s2);   // p = true
System.out.println(p);
p = b1.lessThan(b2);// p = false   
System.out.println(p);    
  }
}