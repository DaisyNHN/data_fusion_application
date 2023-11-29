package ldn.cs.fusion.pojo.production;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryVo {

    private String groupName;

    private List<Data>  series;


    @lombok.Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Data{
        private String name;
        private Integer data;
    }

}
