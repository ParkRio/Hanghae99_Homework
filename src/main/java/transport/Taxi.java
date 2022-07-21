package transport;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Taxi extends Transport {
    // Todo 하위 클래스 필수 요소
    String ones; // 목적지
    String distance; // 목적지까지의 거리
    int basicDistance = 1; // 기본 거리 1km
    int basicPayment = 3000; // 기본요금
    int distancePayment = 1000; // 거리당 요금
    boolean status = true; // true : 일반, 탑승가능 * false : 운행중, 운행 불가 : 탑승불가
    int payment = 0; // 총 결제금액
    int passenger = 0; // 탑승 승객 수
    int cumulativeCharge = 0; // 누적금액

    //Todo 하위 클래스 생성자
    public Taxi(int maxPassenger) {
        this.maxPassenger = maxPassenger;
    }

    //Todo 메서드
    // Todo : run() 메서드 시나리오용 메서드
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("==================================");
        transportStart();
        System.out.println("==================================");
        System.out.println("승객 수와 목적지, 목적지까지의 거리를 입력해주세요.");
        System.out.println("승객 수 : ");
        int passenger = sc.nextInt();
        System.out.println("목적지 : ");
        String ones = sc.next();
        System.out.println("목적지까지의 거리 : ");
        String distance = sc.next();
        boardingPassenger(passenger, ones, distance);
        System.out.println("==================================");
        System.out.println("사용하거나 충전한 주유량을 ex) 30 / -30 등으로 입력해주세요.");
        int gas = sc.nextInt();
        cumulativeCharge(gas);
        System.out.println("==================================");
        System.out.println("승객 수와 목적지, 목적지까지의 거리를 입력해주세요.");
        System.out.println("승객 수 : ");
        int passenger2 = sc.nextInt();
        System.out.println("목적지 : ");
        String ones2 = sc.next();
        System.out.println("목적지까지의 거리 : ");
        String distance2 = sc.next();
        boardingPassenger(passenger2, ones2, distance2);
        System.out.println("사용하거나 충전한 주유량을 ex) 30 / -30 등으로 입력해주세요.");
        int gas2 = sc.nextInt();
        cumulativeCharge(gas2);
        System.out.println("==================================");
        System.out.println("승객 수와 목적지, 목적지까지의 거리(km)를 입력해주세요.");
        System.out.println("승객 수 : ");
        int passenger3 = sc.nextInt();
        System.out.println("목적지 : ");
        String ones3 = sc.next();
        System.out.println("목적지까지의 거리 : ");
        String distance3 = sc.next();
        boardingPassenger(passenger3, ones3, distance3);
        System.out.println("사용하거나 충전한 주유량을 ex) 30 / -30 등으로 입력해주세요.");
        int gas3 = sc.nextInt();
        cumulativeCharge(gas3);

    }

    @Override
    public void transportStart() {
        if (this.gas >= 10) {
            status = true;
            System.out.println("현재 주유량이 10이상으로 운행 가능합니다.");
        } else {
            status = false;
            System.out.println("현재 주유량이 10미만으로 운행 불가합니다.");
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
        }
    }

    public void plusDistancePayment(int distance) {
        this.payment = (distance - this.basicDistance) * this.distancePayment + this.basicPayment;
    }

    public void createTaxi() {
        String st;
        if (this.status) {
            st = "일반";
        } else {
            st = "운행중이거나 운행불가입니다.";
        }
        System.out.println("택시 고유번호 : " + this.transportNumber);
        System.out.println("주유량 : " + this.gas);
        System.out.println("상태 : " + st);
    }

    public void boardingPassenger(int passenger, String ones, String distance) {

        try {

            if (!this.status) {
                if (passenger > this.maxPassenger) {
                    System.out.println("1번");
                    System.out.println("alert! 최대 승객 수 초과 alert!");
                } else {
                    System.out.println("alert! 주유 필요!! alert!");
                }
            } else {
                if (passenger > this.maxPassenger) {
                    System.out.println("2번");
                    System.out.println("alert! 최대 승객 수 초과 alert!");

                } else {
                    this.passenger = passenger;
                    this.ones = ones;
                    this.distance = distance.split("km")[0];
                    plusDistancePayment(Integer.parseInt(this.distance));

                    this.passenger += passenger;
                    this.status = false;
                    System.out.println("탑승 승객 수 : " + passenger);
                    System.out.println("잔여 승객 수 : " + (this.maxPassenger - passenger));
                    System.out.println("기본 요금 확인 : " + this.basicPayment);
                    System.out.println("목적지 : " + this.ones);
                    System.out.println("목적지까지 거리 : " + distance);
                    System.out.println("지불할 요금 : " + this.payment);
                    System.out.println("상태 : 운행중");
                }
            }
        } catch (Exception e) {
            return;
        }
    }

    public void cumulativeCharge(int gas){
        this.gas += gas;
        this.cumulativeCharge += this.payment;
        if (this.gas > 10) {
            System.out.println("주유량 : " + this.gas);
            transportStart();
            System.out.println("누적 요금 : " + this.cumulativeCharge);
        }
        if (this.gas < 10) {
            System.out.println("주유량 : " + this.gas);
            transportStart();
            System.out.println("누적 요금 : " + this.cumulativeCharge);
            System.out.println("alert! 주유 필요!!! alert!");
        }
    }
}
