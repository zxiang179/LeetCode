package zx.leetcode.Aug.alibaba;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<UnilateralLine> lineList = new ArrayList<UnilateralLine>();
        while (scanner.hasNextLine()) {
            String[] options = scanner.nextLine().split(";");
            if (options.length < 5) {
                break;
            }
            lineList.add(new UnilateralLine(options[0], options[1], options[2],
                    options[3], options[4], options[5]));
        }
        scanner.close();

        // wirte your code here
        List<String> result = calculateUnilateral(lineList);

        for (String str : result) {
            System.out.println(str);
        }
    }

    public static List<String> calculateUnilateral(
            List<UnilateralLine> lineList) {
        List<String> result = new ArrayList<String>();

        String rule;
        for (int i = 0; i < lineList.size() - 1; i++) {
            for (int j = i + 1; j < lineList.size(); j++) {
                rule = lineList.get(i).inCycle(lineList.get(j));
                if (rule.equals("one")) {
                    meetType(lineList,i,j,result,"rule1:");
                } else if (rule.equals("three"))
                    meetType(lineList,i,j,result,"rule3:");
                else if ("neg".equals(rule)) {
                    for (int k = j+1;k < lineList.size(); k++) {
                        if (lineList.get(k).getId() != lineList.get(i).getId()
                                && lineList.get(k).getId() != lineList.get(j).getId()) {
                            if (lineList.get(j).getECen().equals(lineList.get(k).getSCen())
                                    && lineList.get(k).getECen().equals(
                                            lineList.get(i).getSCen())) {
                                result.add("rule2:" + lineList.get(i).getId()
                                        + "+" + lineList.get(j).getId() + "+"
                                        + lineList.get(k).getId());
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
   
    public static void meetType(List<UnilateralLine> lineList,int i,int j,List<String> result,String Type){
        double cx = Double.valueOf(lineList.get(i).getTType().substring(0, lineList.get(i).getTType().length()-1))
                - Double.valueOf(lineList.get(j).getTType().substring(0, lineList.get(j).getTType().length()-1));
        if (cx == 0)
            result.add(Type + lineList.get(i).getId() + "+"
                    + lineList.get(j).getId());
        else if (cx < 0) {
            for (int q = i + 1; q < lineList.size(); q++) {
                if (lineList.get(i).compare(lineList.get(q)))
                    result.add(Type + lineList.get(i).getId()
                            + "+" + lineList.get(j).getId() + "+"
                            + lineList.get(q).getId());
            }
        } else if (cx > 0) {
            for (int q = j + 1; q < lineList.size(); q++) {
                if (lineList.get(j).compare(lineList.get(q)))
                    result.add(Type + lineList.get(i).getId()
                            + "+" + lineList.get(j).getId() + "+"
                            + lineList.get(q).getId());
            }
        }
    }

    public static class UnilateralLine {
        private String id;
        private String sCen;// 出发分拨
        private String sPro;// 出发省
        private String eCen;// 到达分拨
        private String ePro;// 到达省
        // 9.6m/17.5m
        private String tType;// 车型

        public UnilateralLine(String id, String sCen, String sPro, String eCen,
                String ePro, String tType) {
            this.id = id;
            this.sCen = sCen;
            this.sPro = sPro;
            this.eCen = eCen;
            this.ePro = ePro;
            this.tType = tType;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSCen() {
            return sCen;
        }

        public void setSCen(String ePro) {
            this.ePro = ePro;
        }

        public String getSPro() {
            return sPro;
        }

        public void setSPro(String sPro) {
            this.sPro = sPro;
        }

        public String getECen() {
            return eCen;
        }

        public void setECen(String eCen) {
            this.eCen = eCen;
        }

        public String getEPro() {
            return ePro;
        }

        public void setEPro(String ePro) {
            this.ePro = ePro;
        }

        public String getTType() {
            return tType;
        }

        public void setTType(String tType) {
            this.tType = tType;
        }

        public String inCycle(UnilateralLine line) {
            if (this.getECen().equals(line.getSCen())) {
                if (this.getSCen().equals(line.getECen()))
                    return "one";
                else
                    return "neg";
            } else if (line.getSCen().equals(this.getECen())) {
                if (line.getEPro().equals(this.sPro)) return "three";
            }
            return "zero";
        }

        public boolean compare(UnilateralLine line) {
            if (line.getSCen().equals(this.sCen)
                    && line.getECen().equals(this.eCen)
                    && line.getTType().equals(this.tType))
                return true;
            return false;
        }
    }
}
