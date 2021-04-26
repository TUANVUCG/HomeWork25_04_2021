import java.util.List;
import java.util.Scanner;

public class StudentBranchC extends Student{

    private double literaryScore;
    private double historyScore;
    private double geographyScore;

    public StudentBranchC() {
    }

    public StudentBranchC(double literaryScore, double historyScore, double geographyScore) {
        this.literaryScore = literaryScore;
        this.historyScore = historyScore;
        this.geographyScore = geographyScore;
    }

    public StudentBranchC(int id, String name, String address, String prioritizeType, double literaryScore, double historyScore, double geographyScore) {
        super(id, name, address, prioritizeType);
        this.literaryScore = literaryScore;
        this.historyScore = historyScore;
        this.geographyScore = geographyScore;
    }

    public double getLiteraryScore() {
        return literaryScore;
    }

    public void setLiteraryScore(double literaryScore) {
        this.literaryScore = literaryScore;
    }

    public double getHistoryScore() {
        return historyScore;
    }

    public void setHistoryScore(double historyScore) {
        this.historyScore = historyScore;
    }

    public double getGeographyScore() {
        return geographyScore;
    }

    public void setGeographyScore(double geographyScore) {
        this.geographyScore = geographyScore;
    }

    // Nhap thong tin thi sinh khoi C
    public void inputStudentBranchCInfo(List<Student> studentList){
        inputStudentInfo(studentList);
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập điểm môn Ngữ văn : ");
        literaryScore = sc.nextDouble();
        System.out.print("Nhập điểm môn Lịch sử : ");
        historyScore = sc.nextDouble();
        System.out.print("Nhập điểm môn Địa lý : ");
        geographyScore = sc.nextDouble();
    }

    @Override
    public String toString() {
        return "Thí sinh khối C : "+ super.toString()+"Điểm Ngữ văn : " + literaryScore + "   "+
                "Điểm Lịch sử : " + historyScore +"   "+
                "Điểm Địa lý : " + geographyScore ;
    }
}
