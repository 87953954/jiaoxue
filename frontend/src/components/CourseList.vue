<template>
  <div>
    <h2>课程列表</h2>
    <el-table :data="courseList" style="width: 100%">
      <el-table-column prop="id" label="ID" width="180" />
      <el-table-column prop="name" label="课程名称" />
      <el-table-column prop="teacherId" label="教师ID" />
    </el-table>
  </div>
</template>

<script>
import axios from 'axios';
import { ElTable, ElTableColumn } from 'element-plus';

export default {
  name: 'CourseList',
  components: {
    ElTable,
    ElTableColumn,
  },
  data() {
    return {
      courseList: [],
    };
  },
  mounted() {
    this.fetchCourseList();
  },
  methods: {
    fetchCourseList() {
      axios.get('/api/courses')
        .then(response => {
          this.courseList = response.data;
        })
        .catch(error => {
          console.error('获取课程列表失败:', error);
        });
    },
  },
};
</script>