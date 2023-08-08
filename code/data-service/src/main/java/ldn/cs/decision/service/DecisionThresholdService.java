package ldn.cs.decision.service;

import ldn.cs.decision.dao.DecisionThresholdDao;
import ldn.cs.decision.pojo.threshold.DecisionThreshold;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DecisionThresholdService {
    @Autowired
    private DecisionThresholdDao decisionThresholdDao;

    // 差一个补充更新阈值的方法

    public List<DecisionThreshold> getDecisionThreshold(int categories) {
        return decisionThresholdDao.getDecisionThreshold(categories);
    }
}
