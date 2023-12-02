package ldn.cs.fusion.pojo.sale;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * @author Daisy
 * @date 2023-11-29 15:20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class YearSaleVo {

    private String groupName;

    private List<String> year;

    private List<Integer> yearData;

    private Map<String, List<Integer>> monthData;
}
