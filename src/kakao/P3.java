package kakao;

import java.util.*;

class Parking{

    private String carNum;
    private int inTime;
    private int outTime;
    private int totalTime;
    private int fee;

    public Parking(String carNum, String inTime, String outTime, int totalTime,int fee) {
        this.carNum = carNum;
        setInTime(inTime);
        setOutTime(outTime);
        this.totalTime = 0;
        this.fee = 0;
    }

    public String getCarNum() {
        return carNum;
    }

    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public int getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = toMinute(inTime);
    }

    public int getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = toMinute(outTime);
    }

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int toMinute(String time){
        String[] times = time.split(":");
        int hours = Integer.parseInt(times[0]);
        int minute = Integer.parseInt(times[1]);
        return minute + (hours*60);
    }


    public int getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }
}

public class P3 {

    Map<String, Parking> parkings = new HashMap<>();

    public int calculateFee(int[] fees, Parking parking){
        int time = parking.getTotalTime()-fees[0];
        int fee = fees[1];

        if(time > 0){
            fee += (int)(Math.ceil((double)time / fees[2]) * fees[3]);
        }

        return fee;
    }

    public int[] solution(int[] fees, String[] records) {

        for(String record : records){
            String[] splitedRecord = record.split(" ");

            String time = splitedRecord[0];
            String carNum = splitedRecord[1];
            String state = splitedRecord[2];

            if(state.equals("IN")){
                if(parkings.containsKey(carNum)){
                    Parking parking = parkings.get(carNum);
                    parking.setTotalTime(parking.getTotalTime()+ parking.getOutTime()- parking.getInTime());
                    parking.setInTime(time);
                    parking.setOutTime("23:59");
                }
                else{
                    Parking parking = new Parking(carNum,time,"23:59",0,0);
                    parkings.put(carNum,parking);
                }
            }
            else if(state.equals("OUT")){
                Parking parking = parkings.get(carNum);
                parking.setOutTime(time);
            }
        }

        Set<String> keys = parkings.keySet();
        ArrayList<String> carAndFee = new ArrayList<>();
        for(String key : keys){
            Parking parking = parkings.get(key);
            parking.setTotalTime(parking.getTotalTime()+ parking.getOutTime()- parking.getInTime());

            parking.setFee(calculateFee(fees,parking));
            carAndFee.add(parking.getCarNum()+" "+Integer.toString(parking.getFee()));
        }

        Collections.sort(carAndFee);
        int[] answer = new int[parkings.size()];

        for(int i=0; i<carAndFee.size(); i++){
            String fee = carAndFee.get(i).split(" ")[1];
            answer[i] = Integer.parseInt(fee);
        }

        return answer;
    }
}
