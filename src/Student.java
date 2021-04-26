import java.util.List;
import java.util.Scanner;

public class Student {
    private int id;
    private String name;
    private String address;
    private String prioritizeType;

    public Student() {
    }

    public Student(int id, String name, String address, String prioritizeType) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.prioritizeType = prioritizeType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPrioritizeType() {
        return prioritizeType;
    }

    public void setPrioritizeType(String prioritizeType) {
        this.prioritizeType = prioritizeType;
    }

    // Nhap thong tin mot thi sinh
    public void inputStudentInfo(List<Student> studentList){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số báo danh : ");
        while (true){
            id = sc.nextInt();
            sc.nextLine();
            boolean isFind = false;
            for(Student student : studentList){
                if(student.getId()==id){
                    isFind = true;
                }
            }
            if(!isFind){
                break;
            }else {
                System.err.println("Mã sinh viên đã tồn tại !");
            }
        }
        System.out.print("Nhập họ tên thí sinh : ");
        name = sc.nextLine();
        System.out.print("Nhập địa chỉ : ");
        address = sc.nextLine();
        System.out.print("Nhập diện ưu tiên khu vực : ");
        prioritizeType = sc.nextLine();
    }

    @Override
    public String toString() {
        return "Số báo danh : " + id + "    " +
                "Tên thí sinh : " + name + "    " +
                "Địa chỉ : " + address + "    " +
                "Diện ưu tiên khu vực : " + prioritizeType +"    ";
    }
}
