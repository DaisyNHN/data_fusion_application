package ldn.cs.fusion.pojo.sale;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Daisy
 * @date 2023-11-29 16:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExportVo {

    private String groupName;

    private List<String> countries;

    private List<Data> data;
    @lombok.Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Data{
        private String year;
        private String type;
        //和countries一一对应
        private List<Integer> data;
    }
}
