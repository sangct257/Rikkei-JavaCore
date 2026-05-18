package bai5.ra.business;

import bai5.ra.entity.Employee;
import bai5.ra.entity.Project;
import bai5.ra.entity.Role;
import bai5.ra.entity.Status;

import java.util.Scanner;

public class ProjectBusiness {
    private static Project[] projects = new Project[50];
    private static int currentIndex = 0;


    public static void addProject(Scanner scanner) {
        if (currentIndex >= projects.length) {
            System.out.println("Bộ nhớ danh sách dự án đã đầy!");
            return;
        }

        // Bốc kho dữ liệu nhân viên từ hệ thống để truyền sang cho Project kiểm tra
        Employee[] systemEmployees = EmployeeBusiness.getEmployees();
        int systemEmpCount = EmployeeBusiness.getCurrentIndex();

        Project newProject = new Project();
        // Chạy hàm nhập dữ liệu (nhập thông tin + nhập nhân viên ban đầu)
        newProject.inputData(scanner, projects, currentIndex, systemEmployees, systemEmpCount);

        projects[currentIndex++] = newProject;
        System.out.println("Thêm dự án mới thành công!");
    }

    public static void displayProjects() {
        if (currentIndex == 0) {
            System.out.println("Không có dự án nào trong danh sách!");
            return;
        }
        System.out.println("=================== DANH SÁCH DỰ ÁN ===================");
        for (int i = 0; i < currentIndex; i++) {
            projects[i].displayData();
        }
    }

    public static void updateProject(Scanner scanner) {
        if (currentIndex == 0) {
            System.out.println("Danh sách trống, không thể cập nhật!");
            return;
        }
        System.out.print("Nhập mã dự án cần cập nhật (Ví dụ: P0001): ");
        String searchProjectId = scanner.nextLine().trim();

        int foundIndex = -1;
        for (int i = 0; i < currentIndex; i++) {
            if (projects[i].getProjectId().equalsIgnoreCase(searchProjectId)) {
                foundIndex = i;
                break;
            }
        }

        if (foundIndex != -1) {
            System.out.println("--- Cập nhật thông tin toàn diện cho dự án " + searchProjectId + " ---");
            Employee[] systemEmployees = EmployeeBusiness.getEmployees();
            int systemEmpCount = EmployeeBusiness.getCurrentIndex();

            // Gọi hàm cập nhật bao gồm cả sửa đổi danh sách nhân viên nội bộ
            projects[foundIndex].inputUpdateData(scanner, projects, currentIndex, systemEmployees, systemEmpCount);
            System.out.println("Cập nhật thông tin và nhân viên dự án thành công!");
        } else {
            System.out.println("Mã dự án không tồn tại trong hệ thống!");
        }
    }

    public static void deleteProject(Scanner scanner) {
        if (currentIndex == 0) {
            System.out.println("Danh sách trống, không có dự án để xóa!");
            return;
        }
        System.out.print("Nhập mã dự án cần xóa: ");
        String deleteId = scanner.nextLine().trim();

        int foundIndex = -1;
        for (int i = 0; i < currentIndex; i++) {
            if (projects[i].getProjectId().equalsIgnoreCase(deleteId)) {
                foundIndex = i;
                break;
            }
        }

        if (foundIndex != -1) {
            Employee[] empsInProject = projects[foundIndex].getEmployees();
            if (empsInProject != null && empsInProject.length > 0) {
                System.out.println("Không thể xóa dự án vì đã có nhân viên tham gia (Theo yêu cầu đề bài)!");
            } else {
                for (int i = foundIndex; i < currentIndex - 1; i++) {
                    projects[i] = projects[i + 1];
                }
                projects[currentIndex - 1] = null;
                currentIndex--;
                System.out.println("Xóa dự án thành công!");
            }
        } else {
            System.out.println("Mã dự án không tồn tại!");
        }
    }

    public static void addEmployeeToProject(Scanner scanner) {
        if (currentIndex == 0) {
            System.out.println("Chưa có dự án nào trong hệ thống!");
            return;
        }
        System.out.print("Nhập mã dự án muốn bổ sung thêm nhân viên: ");
        String projId = scanner.nextLine().trim();

        int projIdx = -1;
        for (int i = 0; i < currentIndex; i++) {
            if (projects[i].getProjectId().equalsIgnoreCase(projId)) {
                projIdx = i;
                break;
            }
        }

        if (projIdx == -1) {
            System.out.println("Mã dự án không tồn tại!");
            return;
        }

        int systemEmpCount = EmployeeBusiness.getCurrentIndex();
        Employee[] systemEmployees = EmployeeBusiness.getEmployees();

        if (systemEmpCount == 0) {
            System.out.println("Hệ thống chưa có nhân viên nào, vui lòng tạo nhân viên trước!");
            return;
        }

        System.out.print("Nhập mã nhân viên muốn gán vào dự án này: ");
        String empId = scanner.nextLine().trim();

        Employee targetEmp = null;
        for (int i = 0; i < systemEmpCount; i++) {
            if (systemEmployees[i].getEmployeeId().equalsIgnoreCase(empId)) {
                targetEmp = systemEmployees[i];
                break;
            }
        }

        if (targetEmp == null) {
            System.out.println("Mã nhân viên không tồn tại trên hệ thống!");
            return;
        }

        Project currentProj = projects[projIdx];
        Employee[] currentEmps = currentProj.getEmployees();

        if (currentEmps != null) {
            for (Employee e : currentEmps) {
                if (e.getEmployeeId().equalsIgnoreCase(empId)) {
                    System.out.println("Nhân viên này đã tham gia dự án này rồi!");
                    return;
                }
            }
        }

        int oldLength = (currentEmps == null) ? 0 : currentEmps.length;
        Employee[] newEmps = new Employee[oldLength + 1];
        for (int i = 0; i < oldLength; i++) {
            newEmps[i] = currentEmps[i];
        }
        newEmps[oldLength] = targetEmp;
        currentProj.setEmployees(newEmps);

        System.out.println("Đã bổ sung nhân viên [" + targetEmp.getEmployeeName() + "] vào dự án thành công!");
    }

    public static void searchProjectByName(Scanner scanner) {
        if (currentIndex == 0) {
            System.out.println("Danh sách trống!");
            return;
        }
        System.out.print("Nhập tên dự án muốn tìm kiếm: ");
        String searchName = scanner.nextLine().trim().toLowerCase();

        boolean isFound = false;
        System.out.println("================= KẾT QUẢ TÌM KIẾM =================");
        for (int i = 0; i < currentIndex; i++) {
            if (projects[i].getProjectName().toLowerCase().contains(searchName)) {
                projects[i].displayData();
                isFound = true;
            }
        }
        System.out.println("====================================================");
        if (!isFound) {
            System.out.println("Không tìm thấy dự án nào khớp với từ khóa.");
        }
    }

    public static void statisticalEmployeeRole() {
        if (currentIndex == 0) {
            System.out.println("Chưa có dự án nào để thống kê!");
            return;
        }
        System.out.println("============= THỐNG KÊ NHÂN VIÊN THEO VAI TRÒ =============");
        for (int i = 0; i < currentIndex; i++) {
            Project proj = projects[i];
            System.out.println("Dự án: " + proj.getProjectName() + " [" + proj.getProjectId() + "]");

            Employee[] emps = proj.getEmployees();
            int countDev = 0, countTester = 0, countPm = 0, countBa = 0;

            if (emps != null) {
                for (Employee emp : emps) {
                    if (emp.getRole() == Role.DEV) countDev++;
                    else if (emp.getRole() == Role.TESTER) countTester++;
                    else if (emp.getRole() == Role.PM) countPm++;
                    else if (emp.getRole() == Role.BA) countBa++;
                }
            }
            System.out.printf("   + DEV   : %d người\n", countDev);
            System.out.printf("   + TESTER: %d người\n", countTester);
            System.out.printf("   + PM    : %d người\n", countPm);
            System.out.printf("   + BA    : %d người\n", countBa);
            System.out.println("-------------------------------------------------------");
        }
    }

    public static void findRunningProjectNearEnd() {
        if (currentIndex == 0) {
            System.out.println("Hệ thống chưa có dự án nào!");
            return;
        }

        Project targetProject = null;

        for (int i = 0; i < currentIndex; i++) {
            Project currentProj = projects[i];
            // Chỉ xét các dự án đang ở trạng thái RUNNING
            if (currentProj.getStatus() == Status.RUNNING) {
                if (targetProject == null) {
                    targetProject = currentProj;
                } else {
                    // Nếu ngày kết thúc của dự án này sớm hơn dự án đã lưu trước đó thì đổi ngôi
                    if (currentProj.getEndDate().isBefore(targetProject.getEndDate())) {
                        targetProject = currentProj;
                    }
                }
            }
        }

        if (targetProject != null) {
            System.out.println("================== DỰ ÁN SẮP HOÀN THÀNH ==================");
            targetProject.displayData();
        } else {
            System.out.println("Hiện tại không có dự án nào ở trạng thái ĐANG CHẠY (RUNNING)!");
        }
    }
}
