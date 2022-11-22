package Trial3RiceNoodles;

import Trial3RiceNoodles.RiceNoodles.GanJiangRiceNoodles;
import Trial3RiceNoodles.RiceNoodles.IRiceNoodles;
import Trial3RiceNoodles.RiceNoodles.SuanJiangRiceNoodles;
import Trial3RiceNoodles.RiceNoodles.WaterRiceNoodles;
import Trial3RiceNoodles.decorator.Beef;
import Trial3RiceNoodles.decorator.Egg;
import Trial3RiceNoodles.decorator.ToFu;

import java.util.Map;
import java.util.Objects;

public class handleInput {
    /*
    RNTYPE: 用户输入的米线类型
    map: 加的调料列表。
     */
    public static Result computeOrder(String RNTYPE, Map<String, Integer> map) {
        IRiceNoodles riceNoodles = null;
        if (Objects.equals(RNTYPE, "酸米线")) {
            riceNoodles = handleInput.computeResult(map,new SuanJiangRiceNoodles());
        } else if (RNTYPE.equals("干米线")) {
            riceNoodles = handleInput.computeResult(map,new GanJiangRiceNoodles());
        } else {
            riceNoodles = handleInput.computeResult(map,new WaterRiceNoodles());
        }
        if (riceNoodles == null){
            return new Result("asdf",2.0);
        } else {
            return new Result(riceNoodles.getDescription(),riceNoodles.cost());
        }
    }
    public static IRiceNoodles computeResult(Map<String, Integer> map,IRiceNoodles noodlesType) {
        IRiceNoodles riceNoodles = null;
        if (map.get("牛肉") > 0) {
            IRiceNoodles riceNoodles1 = new Beef(noodlesType,map.get("牛肉"));
            riceNoodles = riceNoodles1;
        }
        if (map.get("鸡蛋") > 0) {
            if (riceNoodles == null) {
                IRiceNoodles riceNoodles2 = new Egg(noodlesType,map.get("鸡蛋"));
                riceNoodles = riceNoodles2;
            } else {
                IRiceNoodles riceNoodles2 = new Egg(riceNoodles,map.get("鸡蛋"));
                riceNoodles = riceNoodles2;
            }
        }
        if (map.get("豆腐") > 0) {
            if (riceNoodles == null) {
                IRiceNoodles riceNoodles3 = new ToFu(noodlesType,map.get("豆腐"));
                riceNoodles = riceNoodles3;
            } else {
                IRiceNoodles riceNoodles3 = new ToFu(riceNoodles,map.get("豆腐"));
                riceNoodles = riceNoodles3;
            }
        }
        return riceNoodles;
    }

}
