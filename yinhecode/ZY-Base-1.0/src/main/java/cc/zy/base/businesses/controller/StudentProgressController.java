package cc.zy.base.businesses.controller;

import cc.zy.base.businesses.service.IStudentProgressService;
import cc.zy.base.common.entity.FebsResponse;
import cc.zy.base.common.entity.QueryRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 学籍进度
 * @author 赵佳伟
 * @date 2021/01/29
 */

@Slf4j
@Validated
@Controller
@RequiredArgsConstructor
public class StudentProgressController {

    private final IStudentProgressService studentProgressService;

    /**
     * 前台传来学生id，判断该学生的学籍进度
     * @param id
     * @return map集合，stageName：学籍进度（考前、在籍、论文、毕业、逾期毕业）
     *                  changeStatus：学籍异动状态（“”、休学、退学）
     */
    @GetMapping("studentProgress/progress")
    @ResponseBody
    public FebsResponse correspondenceCollegeList(Integer id) {
        Map<String, String> calculateProgress = studentProgressService.calculateProgress(id);
        return new FebsResponse().success().data(calculateProgress);

    }
}
