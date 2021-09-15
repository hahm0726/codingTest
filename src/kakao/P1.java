package kakao;

import java.util.*;

public class P1 {
    class Member{
        private int idx;
        private String name;
        private int reportedCnt;
        private Set<String> myReport;

        public Member(int idx, String name, int reportedCnt) {
            this.idx = idx;
            this.name = name;
            this.reportedCnt = reportedCnt;
            this.myReport = new HashSet<>();
        }

        public void setReportedCnt(int reportedCnt) {
            this.reportedCnt = reportedCnt;
        }

        public void setMyReport(Set<String> myReport) {
            this.myReport = myReport;
        }

        public int getIdx() {
            return idx;
        }

        public String getName() {
            return name;
        }

        public int getReportedCnt() {
            return reportedCnt;
        }

        public Set<String> getMyReport() {
            return myReport;
        }
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, Member> members = new HashMap<>();

        for(int i=0; i<id_list.length; i++){
            Member newMember = new Member(i,id_list[i],0);
            members.put(id_list[i],newMember);
        }

        for(String reportStr: report){
            String[] reports = reportStr.split(" ");  // 0:신고자 , 1: 신고당한 사람

            Member reporter = members.get(reports[0]);
            Member reportedMem = members.get(reports[1]);

            Set<String> reporterReport = reporter.getMyReport();

            if(reporterReport.contains(reports[1])) continue;
            reporterReport.add(reports[1]);
            reportedMem.setReportedCnt(reportedMem.getReportedCnt()+1);
        }

        int[] answer = new int[id_list.length];

        for(String name : members.keySet()){
            Member reporter = members.get(name);
            for(String reportName : reporter.getMyReport()){
                Member member = members.get(reportName);
                if(member.getReportedCnt() >= k){
                    answer[reporter.getIdx()]++;
                }
            }
        }

        return answer;
    }
}
