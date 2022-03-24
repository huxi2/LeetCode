package Others;

import java.util.LinkedList;
import java.util.List;

public class Generate_YH {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> row = new LinkedList<>();
        row.add(1);
        res.add(row);
        if (numRows == 1) return res;
        row = new LinkedList<>();
        row.add(1);
        row.add(1);
        res.add(row);
        if (numRows == 2) return res;

        for (int i = 1; i < numRows - 1; i++) {//计算第i行数据
            List<Integer> temp = res.get(i);
            row = new LinkedList<>();
            row.add(1);
            for (int j = 1; j < temp.size(); j++) {
                row.add(temp.get(j - 1) + temp.get(j));
            }
            row.add(1);
            res.add(row);
        }
        return res;
    }
}
