package ldn.cs.fusion.pojo.convey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Daisy
 * @date 2023-11-29 16:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConveyVo {

    private String groupName;

    private List<String> item;

    private List<Integer> times;

    private List<Integer> cost;

}
