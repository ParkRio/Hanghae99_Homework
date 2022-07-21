import transport.Bus;
import transport.Taxi;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {

        boolean exitcheck = true;

        Scanner sc = new Scanner(System.in);
        Bus sBus = new Bus(30);
        Bus mBus = new Bus(30);
        Taxi staxi = new Taxi(4);
        Taxi mtaxi = new Taxi(4);

        System.out.println(" 1.버스 / 2.택시 --> 번호 선택해주세요.");
        switch (sc.nextInt()) {
            case 1 : {
                do {
                    System.out.println("*********************************");
                    System.out.println("원하는 메뉴를 선택해주세요");
                    System.out.println("1. 시나리오");
                    System.out.println("2. 차량 생성");
                    System.out.println("3. 승객 추가");
                    System.out.println("4. 사용하거나 충전한 주유랑 입력");
                    System.out.println("5. 주유량 입력 및 차량상태 확인");
                    System.out.println("6. 상태 변경");
                    System.out.println("7. 속도 변경");
                    System.out.println("8. 종료");
                    System.out.println("*********************************");
                    switch (sc.nextInt()) {
                        case 1 : {
                            System.out.println("차량이 생성되었습니다. 아래는 고유번호입니다.");
                            sBus.createBus();
                            mBus.createBus();
                            System.out.println("==================================");
                            sBus.run();
                            break;
                        }
                        case 2 : {
                            sBus.createBus();
                            mBus.createBus();
                            break;
                        }
                        case 3 : {
                            System.out.println("탑승 승객 수를 숫자로 입력해주세요.");
                            sBus.boardingPassenger(sc.nextInt());
                            break;
                        }
                        case 4 : {
                            System.out.println("사용하거나 충전한 주유량을 ex) 30 / -30 등으로 입력해주세요.");
                            sBus.gasRemain(sc.nextInt());
                            break;
                        }
                        case 5: {
                            System.out.println("사용하거나 충전한 주유량을 ex) 30 / -30 등으로 입력해주세요.");
                            sBus.gasRemainAndStatus(sc.nextInt());
                            break;
                        }
                        case 6: {
                            System.out.println("상태 변경이 가능합니다. 차고지행 / 운행중 으로 입력해주세요.");
                            sBus.changeStatus(sc.next());
                            break;
                        }

                        case 7 : {
                            System.out.println("운행 중이라면 속도 변경이 가능합니다.");
                            System.out.println("현재속도 : " + sBus.speed + "km/h");
                            System.out.println("속도를 입력해주세요.");
                            sBus.speedChange(sc.nextInt());
                            System.out.println("현재속도 : " + sBus.speed + "km/h");
                            break;

                        }
                        case 8 : {
                            System.out.println("종료되었습니다.");
                            exitcheck = false;
                        }
                    }
                }
                while(exitcheck);

                break;
            }

            case 2 : {
                do {
                    System.out.println("*********************************");
                    System.out.println("원하는 메뉴를 선택해주세요");
                    System.out.println("1. 시나리오");
                    System.out.println("2. 차량 생성");
                    System.out.println("3. 승객 탑승");
                    System.out.println("4. 사용하거나 충전한 주유랑 입력 / 운행상태 불가시 확인 가능.");
                    System.out.println("5. 차량상태 확인");
                    System.out.println("6. 속도 변경");
                    System.out.println("7. 종료");
                    System.out.println("*********************************");
                    switch (sc.nextInt()) {
                        case 1 : {
                            System.out.println("차량이 생성되었습니다. 아래는 고유번호입니다.");
                            staxi.createTaxi();
                            System.out.println("==================================");
                            mtaxi.createTaxi();
                            System.out.println("==================================");
                            staxi.run();
                            break;
                        }
                        case 2 : {
                            staxi.createTaxi();
                            mtaxi.createTaxi();
                            break;
                        }
                        case 3 : {
                            System.out.println("승객 수와 목적지, 목적지까지의 거리를 입력해주세요.");
                            System.out.println("승객 수 : ");
                            int passenger = sc.nextInt();
                            System.out.println("목적지 : ");
                            String ones = sc.next();
                            System.out.println("목적지까지의 거리 : ");
                            String distance = sc.next();
                            staxi.boardingPassenger(passenger,ones,distance);
                            break;
                        }
                        case 4: {
                            System.out.println("사용하거나 충전한 주유량을 ex) 30 / -30 등으로 입력해주세요.");
                            staxi.cumulativeCharge(sc.nextInt());
                            break;
                        }

                        case 5 : {
                            staxi.transportStart();
                            break;
                        }

                        case 6 : {
                            System.out.println("현재속도 : " + staxi.speed + "km/h");
                            System.out.println("속도(숫자만)을/를 입력해주세요.");
                            staxi.speedChange(sc.nextInt());
                            System.out.println("현재속도 : " + staxi.speed + "km/h");
                            break;
                        }
                        case 7 : {
                            exitcheck = false;
                        }
                    }

                } while(exitcheck);

                break;
            }
        }
    }
}
