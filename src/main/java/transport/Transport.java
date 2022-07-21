package transport;

import java.util.UUID;

abstract public class Transport {

    // TODO 상위클래스 필수 요소
    String transportNumber = UUID.randomUUID().toString();
    int gas = 100;
    public int speed = 0;
    int speedChange = 0;
    int maxPassenger;

    // 필요할 경우


    // TODO 생성자
    public Transport() {
        // default
    }


    // TODO 메서드 기능
        // 운행 시작
    public void transportStart(){};
        // 속도 변경
    public void speedChange(int speed){};
        // 상태 변경
    public void changeStatus(String status){};
        // 승객 탑승
    public void boardingPassenger(int passenger){};



}
