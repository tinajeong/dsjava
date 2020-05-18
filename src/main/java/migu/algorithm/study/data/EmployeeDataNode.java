package migu.algorithm.study.data;

public class EmployeeDataNode {
    private EmployeeDataNode next;
    private Employee employee;

    public EmployeeDataNode() {
        employee = new Employee();
    }

    public EmployeeDataNode(Employee employee) {
        this.employee = employee;
    }

    public EmployeeDataNode getNext() {
        return next;
    }

    public void setNext(EmployeeDataNode next) {
        this.next = next;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
