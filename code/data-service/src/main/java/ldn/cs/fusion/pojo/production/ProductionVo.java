package ldn.cs.fusion.pojo.production;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductionVo {

    //集团名
    private String groupName;

    //集团下的公司名
    private List<String>companyName;

    //各类图标指标
    private List<Data> series;

    @lombok.Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Data{
        //指标名
        private String name;
        //指标值
        private List<Integer> data;
    }

}
