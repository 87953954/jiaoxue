package com.example.teaching.controller;
import com.example.teaching.service.TeachingMaterialService;
import com.example.teaching.entity.TeachingMaterial;
import com.example.teaching.service.TeachingMaterialService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * TeachingMaterialController 类
 * 该类负责处理与 TeachingMaterial 实体相关的 HTTP 请求。
 * 提供了教学资料管理相关的 API 接口。
 */
@Api(tags = "教学资料管理")
@RestController
@RequestMapping("/api/teachingMaterials")
public class TeachingMaterialController {
    @Autowired
    private TeachingMaterialService teachingMaterialService;
    /**
     * 获取所有教学资料
     * @return 教学资料列表
     */
    @ApiOperation("获取所有教学资料")
    @GetMapping
    public List<TeachingMaterial> getAllTeachingMaterials() {
        return teachingMaterialService.findAll();
    }

    /**
     * 创建教学资料
     * @param teachingMaterial 要创建的教学资料对象
     * @return 创建成功的教学资料对象
     */
    @ApiOperation("创建教学资料")
    @PostMapping
    public ResponseEntity<TeachingMaterial> createTeachingMaterial(@RequestBody TeachingMaterial teachingMaterial) {
        TeachingMaterial createdTeachingMaterial = teachingMaterialService.createTeachingMaterial(teachingMaterial);
        return new ResponseEntity<>(createdTeachingMaterial, HttpStatus.CREATED);
    }
    /**
     * 根据ID获取教学资料
     * @param id 教学资料ID
     * @return 找到的教学资料
     */
    @ApiOperation("根据ID获取教学资料")
    @GetMapping("/{id}")
    public ResponseEntity<TeachingMaterial> getTeachingMaterialById(@PathVariable Long id) {
        TeachingMaterial teachingMaterial = teachingMaterialService.getTeachingMaterialById(id);
        if (teachingMaterial != null) {
            return new ResponseEntity<>(teachingMaterial, HttpStatus.OK);
        } else {   // 如果不存在则返回404
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    /**
     * 更新教学资料信息
     * @param teachingMaterial 要更新的教学资料对象
     * @return 更新后的教学资料对象
     */
    @ApiOperation("更新教学资料信息")
    @PutMapping
    public ResponseEntity<TeachingMaterial> updateTeachingMaterial(@RequestBody TeachingMaterial teachingMaterial) {
        TeachingMaterial updatedTeachingMaterial = teachingMaterialService.updateTeachingMaterial(teachingMaterial);
        return new ResponseEntity<>(updatedTeachingMaterial, HttpStatus.OK);
    }
    /**
     * 根据ID删除教学资料
     * @param id 要删除的教学资料ID
     * @return 无返回内容
     */
    @ApiOperation("根据ID删除教学资料")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTeachingMaterialById(@PathVariable Long id) {
        teachingMaterialService.deleteTeachingMaterialById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    /**
     * 根据课程ID获取教学资料列表
     * @param courseId 课程ID
     * @return 教学资料列表
     */
    @ApiOperation("根据课程 ID 获取教学资料")
    @GetMapping("/byCourse/{courseId}")
    public List<TeachingMaterial> getTeachingMaterialsByCourseId(@PathVariable Long courseId) {
        return teachingMaterialService.getTeachingMaterialsByCourseId(courseId);
    }
    /**
     * 根据教师ID获取教学资料列表
     * @param teacherId 教师ID
     * @return 教学资料列表
     */
    @ApiOperation("根据教师 ID 获取教学资料")
    @GetMapping("/byTeacher/{teacherId}")
    public List<TeachingMaterial> getTeachingMaterialsByTeacherId(@PathVariable Long teacherId) {
        return teachingMaterialService.getTeachingMaterialsByTeacherId(teacherId);
    }
}