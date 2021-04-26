import java.util.List;
import java.util.Scanner;

public class StudentBranchB extends Student{
    private double mathScore;
    private double chemicalScore;
    private double biologicalScore;


    public StudentBranchB() {
    }

    public StudentBranchB(double mathScore, double chemicalScore, double biologicalScore) {
        this.mathScore = mathScore;
        this.chemicalScore = chemicalScore;
        this.biologicalScore = biologicalScore;
    }

    public StudentBranchB(int id, String name, String address, String prioritizeType, double mathScore, double chemicalScore, double biologicalScore) {
        super(id, name, address, prioritizeType);
        this.mathScore = mathScore;
        this.chemicalScore = chemicalScore;
        this.biologicalScore = biologicalScore;
    }

    public double getMathScore() {
        return mathScore;
    }

    public void setMathScore(double mathScore) {
        this.mathScore = mathScore;
    }

    public double getChemicalScore() {
        return chemicalScore;
    }

    public void setChemicalScore(double chemicalScore) {
        this.chemicalScore = chemicalScore;
    }

    public double getBiologicalScore() {
        return biologicalScore;
    }

    public void setBiologicalScore(double biologicalScore) {
        this.biologicalScore = biologicalScore;
    }

    // Nhap thong tin thi sinh khoi B
    public void inputStudentBranchBInfo(List<Student> studentList){
        inputStudentInfo(studentList);
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập điểm thi môn Toán : ");
        mathScore = sc.nextDouble();
        System.out.print("Nhập điểm thi môn Hóa : ");
        chemicalScore = sc.nextDouble();
        System.out.print("Nhập điểm thi môn Sinh : ");
        biologicalScore = sc.nextDouble();
    }

    @Override
    public String toString() {
        return "Thí sinh khối B : "+ super.toString()+"Điểm Toán : " + mathScore + "   "+
                "Điểm Hóa học : " + chemicalScore +"   "+
                "Điểm Sinh học : " + biologicalScore ;
    }
}
