package ldn.cs.fusion.pojo.wealth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Daisy
 * @date 2023-11-29 16:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayVo {

    private String groupName;

    //指标项目
    private List<String> item;

    private List<Data> data;

    @lombok.Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Data {
        private String year;
        //和item一一对应
        private List<Integer> data;
    }
}
