package transport;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Bus extends Transport {

    // Todo 하위 클래스 필수 요소
    int passenger = 0; // 탑승 할 승객 수
    int remainPassenger = 0; // 잔여 승객 수
    int payment = 1000; // 기본 금액
    int totalPayment = 0; // 총 합계 금액
    boolean status = true; // true : 운행 , false : 운행 x

    // 있을경우

    // Todo Bus클래스 생성자
    public Bus(int maxPassenger) {
        this.maxPassenger = maxPassenger;
    }

    // Todo 메서드
    // Todo : run() 메서드 시나리오용 메서드
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("탑승 승객 수를 숫자로 입력해주세요.");
        boardingPassenger(sc.nextInt());
        System.out.println("===========================");
        System.out.println("사용하거나 충전한 주유량을 ex) 30 / -30 등으로 입력해주세요.");
        gasRemain(sc.nextInt());
        System.out.println("상태 변경이 가능합니다. 차고지행 / 운행중 으로 입력해주세요.");
        changeStatus(sc.next());
        System.out.println("===========================");
        System.out.println("사용하거나 충전한 주유량을 ex) 30 / -30 등으로 입력해주세요.");
        gasRemainAndStatus(sc.nextInt());
        System.out.println("===========================");
        System.out.println("상태 변경이 가능합니다. 차고지행 / 운행중 으로 입력해주세요.");
        changeStatus(sc.next());
        System.out.println("탑승 승객 수를 숫자로 입력해주세요.");
        boardingPassenger(sc.nextInt());
        System.out.println("탑승 승객 수를 숫자로 입력해주세요.");
        boardingPassenger(sc.nextInt());
        System.out.println("사용하거나 충전한 주유량을 ex) 30 / -30 등으로 입력해주세요.");
        gasRemainAndStatus(sc.nextInt());

    }


    @Override
    public void boardingPassenger(int passenger) {

        if (passenger > this.maxPassenger) {
            System.out.println("alert! 최대 수용량을 초과하였습니다. alert!");
        }
        else {
            this.remainPassenger = this.maxPassenger - passenger;
            this.passenger += passenger;
            this.totalPayment = this.totalPayment + (payment * passenger);
            System.out.println("현재 탑승 승객 수는 " + this.passenger);
            System.out.println("잔여 승객 수는 : " + (this.remainPassenger));
            System.out.println("요금 확인 : " + this.totalPayment);
        }
    }

    @Override
    public void changeStatus(String status){
        try {
            System.out.println("*변경문구가 출력되지 않을시 다시 입력해주세요.*");
            if (status.equals("차고지행")) {
                this.status = false;
                this.remainPassenger = this.maxPassenger;
                this.passenger = 0;
                this.totalPayment = 0;
                System.out.println("-----> 차고지행으로 상태 변경되었습니다.");

            } else if (status.equals("운행중")) {
                this.status = true;
                System.out.println("-----> 운행중으로 상태 변경되었습니다.");
            }
        } catch (Exception e) {
            return;
        }
    }

    @Override
    public void speedChange(int speedChange) {
        if (this.status) {
            int speedValue = this.speed + speedChange;
            if (speedValue < 0) {
                System.out.println("속도를 0km/h 이하로 줄일 수 없습니다.");
            } else {
                this.speed = speedValue;
            }
        } else {
            System.out.println("운행중에만 속도변경이 가능합니다.");
            System.out.println("현재위치 : 차고지");
        }
    }

    public void createBus(){
        System.out.println("버스 고유번호 : " + this.transportNumber);
    }

    public void gasRemain(int gas) {
        this.gas += gas;
        System.out.println("주유량 : " + this.gas);
    }

    public void gasRemainAndStatus(int gas) {
        String st = "";
        this.gas += gas;
        if (!this.status) {
            st = "차고지행";
        }
        else st = "운행중";
        System.out.println("상태 : " + st);
        System.out.println("주유량 : " + this.gas);
        if (this.gas < 10) {
            this.status = false;
            System.out.println("alert! 주유가 필요합니다 alert!");
            System.out.println("상태 : 차고지행" );
        }
    }
}
