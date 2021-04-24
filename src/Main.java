import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String DANH_SACH_SAU_SAP_XEP = "Danh sách thí sinh sau sắp xếp : ";
        Admissions admissions = new Admissions();
        admissions.studentList.add(new StudentBranchA(1,"Naruto", "Bac Ninh","kv1", 9,10,7));
        admissions.studentList.add(new StudentBranchB(4,"Aasuke", "Ha Noi","kv2", 7,6.5,8));
        admissions.studentList.add(new StudentBranchC(2,"Kakura", "Bac Kan","kv3", 8,9,8.5));
        admissions.studentList.add(new StudentBranchA(5,"Lee", "Ha Tinh","kv2", 6,8,9));
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập lựa chọn của bạn");
        int choice = -1;
        do{
            menu();
            choice = sc.nextInt();
            switch (choice){
                case 1 : {
                    admissions.addStudent();
                    break;
                }
                case 2 : {
                    admissions.showInfoAllStudent();
                    break;
                }
                case 3 : {
                    sortByNameUseSelectionSort(DANH_SACH_SAU_SAP_XEP, admissions);
                    break;
                }
                case 4 : {
                    sortByIdUseSelectionSort(DANH_SACH_SAU_SAP_XEP, admissions);
                    break;
                }
                case 5 : {
                    searchStudentById(admissions, sc);
                    break;
                }
                case 6 : {
                    editStudentInfoById(admissions, sc);
                    break;
                }
                case 7 : {
                    removeStudentById(admissions, sc);
                    break;
                }
            }

        }while(choice!=0);
    }

    private static void removeStudentById(Admissions admissions, Scanner sc) {
        System.out.print("Nhập SBD cần xóa : ");
        int id = sc.nextInt();
        admissions.removeStudentById(id);
        System.out.println("Danh sách thí sinh sau khi xóa");
        admissions.showInfoAllStudent();
    }

    private static void editStudentInfoById(Admissions admissions, Scanner sc) {
        System.out.print("Nhập SBD cần sửa : ");
        int id = sc.nextInt();
        admissions.editStudentInfoById(id);
        System.out.println("Danh sách sau khi sửa");
        admissions.showInfoAllStudent();
    }

    private static void searchStudentById(Admissions admissions, Scanner sc) {
        System.out.print("Nhập SBD cần tìm : ");
        int id = sc.nextInt();
        admissions.showStudentInfoById(id);
    }

    private static void sortByIdUseSelectionSort(String DANH_SACH_SAU_SAP_XEP, Admissions admissions) {
        admissions.sortStudentById();
        System.out.println(DANH_SACH_SAU_SAP_XEP);
        admissions.showInfoAllStudent();
    }

    private static void sortByNameUseSelectionSort(String DANH_SACH_SAU_SAP_XEP, Admissions admissions) {
        admissions.sortStudentListByNameUseSelectionSort();
        System.out.println(DANH_SACH_SAU_SAP_XEP);
        admissions.showInfoAllStudent();
    }

    private static void menu() {
        System.out.println("1. Nhập thông tin thí sinh");
        System.out.println("2. Hiển thị thông tin tất cả thí sinh");
        System.out.println("3. Sắp xếp danh sách thí sinh theo họ tên sử dụng selection sort");
        System.out.println("4. Sắp xếp danh sách thí sinh theo mã thí sinh");
        System.out.println("5. Tìm kiếm theo số báo danh sử dụng thuật toán tìm kiếm nhị phân");
        System.out.println("6. Chỉnh sửa thông tin của một thí sinh khi biết số báo danh");
        System.out.println("7. Xóa thông tin của thí sinh khi biết số báo danh");
        System.out.println("0. Thoát chương trình");
    }

}
