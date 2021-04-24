import java.util.Scanner;

public class StudentBranchA extends Student{
    private double mathScore;
    private double physicalScore;
    private double chemicalScore;

    public StudentBranchA() {
    }

    public StudentBranchA(double mathScore, double physicalScore, double chemicalScore) {
        this.mathScore = mathScore;
        this.physicalScore = physicalScore;
        this.chemicalScore = chemicalScore;
    }

    public StudentBranchA(int id, String name, String address, String prioritizeType, double mathScore, double physicalScore, double chemicalScore) {
        super(id, name, address, prioritizeType);
        this.mathScore = mathScore;
        this.physicalScore = physicalScore;
        this.chemicalScore = chemicalScore;
    }

    public double getMathScore() {
        return mathScore;
    }

    public void setMathScore(double mathScore) {
        this.mathScore = mathScore;
    }

    public double getPhysicalScore() {
        return physicalScore;
    }

    public void setPhysicalScore(double physicalScore) {
        this.physicalScore = physicalScore;
    }

    public double getChemicalScore() {
        return chemicalScore;
    }

    public void setChemicalScore(double chemicalScore) {
        this.chemicalScore = chemicalScore;
    }

    // Nhap thong tin cua thi sinh khoi A
    public void inputStudentBranchAInfo(){
        inputStudentInfo();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập điểm thi môn Toán : ");
        mathScore = sc.nextDouble();
        System.out.print("Nhập điểm thi môn Lý : ");
        physicalScore = sc.nextDouble();
        System.out.print("Nhập điểm thi môn Hóa : ");
        chemicalScore = sc.nextDouble();
    }

    @Override
    public String toString() {
        return "Thí sinh khối A : "+ super.toString()+"Điểm Toán : " + mathScore + "   "+
                "Điểm Vật lý : " + physicalScore +"   "+
                "Điểm Hóa học : " + chemicalScore ;
    }
}
