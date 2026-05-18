package bai5.ra.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Project {
    private String projectId;
    private String projectName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Employee[] employees = new Employee[99];
    private Status status;

    public Project() {
    }

    public Project(String projectId, String projectName, LocalDate startDate, LocalDate endDate, Employee[] employees, Status status) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employees = employees;
        this.status = status;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void inputData(Scanner scanner, Project[] arrProject, int index, Employee[] arrEmp, int empIndex) {
        getProjectId(scanner, arrProject, index);

        getProjectName(scanner, arrProject, index);

        getProjectStartDate(scanner);

        getProjectEndDate(scanner);

        getProjectEmployees(scanner, arrEmp, empIndex);

        getProjectStatus(scanner);
    }

    public void inputUpdateData(Scanner scanner, Project[] arrProject, int index, Employee[] arrEmp, int empIndex) {
        getProjectName(scanner, arrProject, index);
        getProjectStartDate(scanner);
        getProjectEndDate(scanner);
        getProjectEmployees(scanner, arrEmp, empIndex);
        getProjectStatus(scanner);
    }
    
    private void getProjectStatus(Scanner scanner) {
        do {
            try {
                System.out.print("Chọn trạng thái dự án (1. PLANNING, 2. RUNNING, 3. FINISHED): ");
                int choice = Integer.parseInt(scanner.nextLine().trim());
                if (choice >= 1 && choice <= 3) {
                    this.status = Status.values()[choice - 1];
                    break;
                } else {
                    System.out.println("Vui lòng chọn từ 1 đến 3");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập vào một số nguyên!");
            }
        } while (true);
    }

    private void getProjectEmployees(Scanner scanner, Employee[] arrEmp, int empIndex) {
        // Trường hợp hệ thống trống nhân viên
        if (empIndex == 0) {
            System.out.println("Chưa có nhân viên nào trong hệ thống!");
            this.employees = new Employee[0];
            return;
        }

        int numberEmployee = 0;
        // Nhập số lượng nhân viên tham gia
        do {
            try {
                System.out.print("Mời nhập số lượng nhân viên tham gia vào dự án: ");
                numberEmployee = Integer.parseInt(scanner.nextLine().trim());
                if (numberEmployee < 0) {
                    System.out.println("Số lượng nhân viên tham gia vào dự án không được nhỏ hơn 0!");
                } else if (numberEmployee > empIndex) {
                    System.out.println("Số lượng nhân viên đã vượt quá số nhân viên đang có trong hệ thống (" + empIndex + ")!");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số nguyên!");
            }
        } while (true);

        // Khởi tạo kích thước mảng chứa nhân viên tham gia dự án
        this.employees = new Employee[numberEmployee];

        // Tiến hành điền nhân viên vào từng ô trống của dự án
        for (int i = 0; i < numberEmployee; i++) {
            do {
                System.out.print("Mời nhập mã nhân viên thứ nhất: ");
                String employeeId = scanner.nextLine().trim();

                Employee employee = new Employee();
                boolean isExist = employee.checkIdEmployeeExist(employeeId, arrEmp, empIndex);
                if (!isExist) {
                    System.out.println("Mã nhân viên không tồn tại!");
                    continue; // nhập lại
                }

                // Chặn trùng: Không cho phép thêm cùng 1 nhân viên vào dự án này 2 lần
                boolean isExistEmployeeInProject = false;
                for (int j = 0; j < i; j++) {
                    if (this.employees[j].getEmployeeId().equalsIgnoreCase(employeeId)) {
                        isExistEmployeeInProject = true;
                        break;
                    }
                }

                if (isExistEmployeeInProject) {
                    System.out.println("Nhân viên này đã được thêm vào dự án rồi! Vui lòng chọn nhân viên khác.");
                } else {
                    // Lấy chính xác đối tượng nhân viên từ hệ thống để gán vào ô thứ i của dự án
                    // Tìm và gán chính xác vào vị trí thứ i của dự án
                    for (int j = 0; j < empIndex; j++) {
                        if (arrEmp[j].getEmployeeId().equalsIgnoreCase(employeeId)) {
                            this.employees[i] = arrEmp[j];
                            break;
                        }
                    }
                    System.out.println("Đã thêm nhân viên [" + this.employees[i].getEmployeeName() + "] vào dự án.");
                    break;
                }
            } while (true);
        }
    }

    private void getProjectEndDate(Scanner scanner) {
        do {
            try {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                System.out.print("Mời nhập ngày kết thúc (ngày kết thúc (>= startDate)): ");
                this.endDate = LocalDate.parse(scanner.nextLine(), dtf);
                if (!this.endDate.isBefore(this.startDate)) {
                    break;
                } else {
                    System.out.println("Ngày kết phải lớn hơn ngày bắt đầu");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Ngày kết thúc sai định dạng ngày/tháng/năm");
            }
        } while (true);
    }

    private void getProjectStartDate(Scanner scanner) {
        do {
            try {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                System.out.println("Mời nhập ngày bắt đầu: ");
                this.startDate = LocalDate.parse(scanner.nextLine().trim(), dtf);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Ngày bắt đầu sai định dạng ngày/tháng/năm");
            }
        } while (true);
    }

    private void getProjectName(Scanner scanner, Project[] arrProject, int index) {
        do {
            System.out.print("Mời nhập tên dự án (10–50 ký tự, duy nhất):");
            this.projectName = scanner.nextLine().trim();
            if (this.projectName.length() >= 10 && this.projectName.length() <= 50) {
                if (checkProjectName(this.projectName, arrProject, index)) {
                    System.out.println("Tên dự án đã tồn tại!");
                } else {
                    break;
                }
            } else if (this.projectName.isEmpty()) {
                System.out.println("Tên dự án không được để trống!");
            } else {
                System.out.println("Tên dự án phải từ 10 đến 50 ký tự!");
            }
        } while (true);
    }

    private void getProjectId(Scanner scanner, Project[] arrProject, int index) {
        do {
            System.out.print("Mời nhập mã dự án (P0001): ");
            this.projectId = scanner.nextLine().trim();
            if (this.projectId.matches("^P\\d{4}$")) {
                if (checkProjectId(this.projectId, arrProject, index)) {
                    System.out.println("Mã dự án đã tồn tại!");
                } else {
                    break;
                }
            } else if (this.projectId.isEmpty()) {
                System.out.println("Mã dự án không được để trống!");
            } else {
                System.out.println("Mã dự án sai định dạng");
            }
        } while (true);
    }

    public boolean checkProjectId(String projectId, Project[] projects, int index) {
        for (int i = 0; i < index; i++) {
            if (projects[i].getProjectId().equalsIgnoreCase(projectId)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkProjectName(String projectName, Project[] projects, int index) {
        for (int i = 0; i < index; i++) {
            if (projects[i].getProjectName().equalsIgnoreCase(projectName)) {
                return true;
            }
        }
        return false;
    }

    public void displayData() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Mã dự án: " + this.projectId + ", Tên dự án: " + this.projectName + ", Trạng thái: " + this.status);
        System.out.println("Ngày bắt đầu: " + this.startDate + ", Ngày kết thúc: " + this.endDate);
        System.out.println("Nhân viên tham gia dự án: ");
        if (this.employees == null || this.employees.length == 0) {
            System.out.println("Dự án này chưa có thành viên nào!");
        } else {
            for (Employee employee : employees) {
                employee.displayData();
            }
        }
        System.out.println("=============================================");
    }
}
