package migu.algorithm.study.list;

import migu.algorithm.study.data.Employee;
import migu.algorithm.study.data.EmployeeDataNode;

public class EmployeeCircularLinkedList extends LinkedList<Employee> {
    private EmployeeDataNode tail = new EmployeeDataNode(); //dummy
    private EmployeeDataNode before;
    private EmployeeDataNode curr;

    public EmployeeCircularLinkedList() {
        super();
        //dummy count
        this.setNumOfData(1);
    }

    @Override
    void insertFront(Employee data) {
        EmployeeDataNode newNode = new EmployeeDataNode(data);
        newNode.setNext(this.tail.getNext());
        this.tail.setNext(newNode);
        this.setNumOfData(this.getNumOfData() + 1);
    }

    @Override
    void insertBehind(Employee data) {
        EmployeeDataNode newNode = new EmployeeDataNode(data);
        newNode.setNext(this.tail);
        if (tail.getNext() == null) {
            this.tail.setNext(newNode);
        } else {
            this.before = tail.getNext();
            while (before.getNext() != this.tail) {
                this.before = before.getNext();
            }
            this.before.setNext(newNode);
        }
        this.setNumOfData(this.getNumOfData() + 1);
    }

    @Override
    void removeData() {
        EmployeeDataNode currNode = this.curr;
        if (currNode != null && getNumOfData() != 1) {
            if (currNode.getNext() == this.tail) {
                this.before.setNext(this.tail);
            } else {
                this.before.setNext(this.curr.getNext());
            }
            this.curr = this.before;
            this.setNumOfData(this.getNumOfData() - 1);
            currNode = null;
        } else {
            System.out.println("Curr node is null");
        }
    }

    @Override
    boolean listFirst() {
        if (this.tail.getNext() == null) {
            return false;
        } else if (this.getNumOfData() == 1) {
            return false;
        }
        this.before = this.tail;
        this.curr = before.getNext();
        return true;
    }

    @Override
    boolean listNext() {
        if (this.tail.getNext() == null) {
            return false;
        } else if (this.getNumOfData() == 1) {
            return false;
        }

        this.before = this.curr;
        this.curr = this.before.getNext();

        return true;
    }


    public EmployeeDataNode getCurr() {
        return curr;
    }

    public void setCurr(EmployeeDataNode curr) {
        this.curr = curr;
    }

    public String whoIsNextOnDutyStaff(String onDutyStaff, int daysAfter) {
        String nextOnDutyStaff = null;
        int cnt = 0;
        boolean startFlag = false;

        if (daysAfter == cnt) {
            return onDutyStaff;
        }
        if (listFirst()) {
            if (this.curr.getEmployee().getName().equals(onDutyStaff)) {
                if (cnt == daysAfter) {
                    nextOnDutyStaff = this.getCurr().getEmployee().getName();
                    return nextOnDutyStaff;
                }
                startFlag = true;
            }

            while (listNext()) {
                if (isTail(this.getCurr()) && !startFlag) {
                    System.out.printf("%s is not on-duty staff", onDutyStaff);
                    break;
                }
                if (cnt == daysAfter) {
                    if (!isTail(this.getCurr())) {
                        nextOnDutyStaff = this.getCurr().getEmployee().getName();
                        return nextOnDutyStaff;
                    } else {
                        continue;
                    }
                }

                if (!startFlag) {
                    if (this.getCurr().getEmployee().getName().equals(onDutyStaff)) {
                        startFlag = true;
                        if (cnt == daysAfter) {
                            nextOnDutyStaff = this.getCurr().getEmployee().getName();
                            return nextOnDutyStaff;
                        }
                    }
                } else {
                    cnt++;
                }

            }
        }

        System.out.println("\t - Error");
        return null;

    }

    public boolean isTail(EmployeeDataNode node) {
        return node == this.tail;
    }

    public static void main(String[] args) {
        EmployeeCircularLinkedList circularLinkedList = new EmployeeCircularLinkedList();
        circularLinkedList.testCLL(true);
        circularLinkedList.testCLL(false);
    }

    public void testCLL(boolean isFront) {
        if (isFront) {
            insertFront(new Employee(1, "kyounggu"));
            insertFront(new Employee(2, "migu"));
            insertFront(new Employee(3, "ringu"));

            if (listFirst()) {
                System.out.printf("[\t%s\t", getCurr().getEmployee().getName());
                removeData();
                while (listNext()) {
                    System.out.printf("%s\t", getCurr().getEmployee().getName());
                    removeData();
                }
            }
            System.out.println("]");

        } else {
            insertBehind(new Employee(1, "kyounggu"));
            insertBehind(new Employee(2, "migu"));
            insertBehind(new Employee(3, "ringu"));

            int cnt = 3;
            if (listFirst()) {
                System.out.printf("[\t%s\t", this.getCurr().getEmployee().getName());
                while (listNext() && cnt >= 0) {
                    cnt--;
                    System.out.printf("%s\t", this.getCurr().getEmployee().getName());
                }
            }
            System.out.println("]");

            for (int i = 0; i <= 4; i++) {
                System.out.println(whoIsNextOnDutyStaff("ringu", i));
            }
            System.out.println(whoIsNextOnDutyStaff("migugu", 10));
        }

    }

}