package cc.zy.base.businesses.service.impl;

import cc.zy.base.businesses.entity.StudentProgress;
import cc.zy.base.businesses.mapper.StudentProgressMapper;
import cc.zy.base.businesses.service.IStudentProgressService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class StudentProgressServiceImpl implements IStudentProgressService{
    @Resource
    private final StudentProgressMapper studentProgressMapper;

    @Override
    public Map<String, String> calculateProgress(Integer id) {
        StudentProgress status = studentProgressMapper.findStatusBySid(id);
        Map<String,String> map = new HashMap<>();
        if(status != null && !status.equals("")){
            String stageName = studentProgressMapper.findStatusNameById(status.getStageId());
            if("考前".equals(stageName)){
                map.put("stageName","考前");
                map.put("changeStatus","");
            }else if("已毕业".equals(stageName)){
                String tracsactionName = studentProgressMapper.findStatusNameById(status.getTracsaction());
                if("退学".equals(tracsactionName)){
                    map.put("stageName","已毕业");
                    map.put("changeStatus","退学");
                }else{
                    map.put("stageName","已毕业");
                    map.put("changeStatus","");
                }
            }else if("在籍".equals(stageName)){
                String allowEssayName = studentProgressMapper.findStatusNameById(status.getAllowEssay());
                if("允许".equals(allowEssayName)){
                    map.put("stageName","论文");
                    map.put("changeStatus","");
                }else{
                    String tracsactionName = studentProgressMapper.findStatusNameById(status.getTracsaction());
                    if("休学".equals(tracsactionName)){
                        map.put("","在籍");
                        map.put("changeStatus","休学");
                    }else{
                        map.put("stageName","在籍");
                        map.put("changeStatus","");
                    }
                }
            }else if("逾期毕业".equals(stageName)){
                map.put("stageName","逾期毕业");
                map.put("changeStatus","");
            }
            return map;
        }else{
            return null;
        }
    }
}
