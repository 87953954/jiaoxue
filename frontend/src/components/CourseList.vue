<template>
  <div>
    <h2>课程列表</h2>
    <el-table :data="courseList" style="width: 100%" v-loading="loading">
      <el-table-column prop="name" label="课程名称" />
      <el-table-column prop="teacherId" label="教师ID" />
    </el-table>
  </div>
</template>

<script>
  import axios from 'axios';
  import { ElMessage } from 'element-plus';

  export default {
    name: 'CourseList',
    data() {
      return {
        courseList: [],
        loading: true,
      };
    },
    mounted() {
      this.fetchCourseList();
    },
    methods: {
      async fetchCourseList() {
        try {
          const response = await axios.get('/api/courses');
          if(response.data.code == 200){
            this.courseList = response.data.data;
          }else{
            ElMessage.error("get data error");
          }
        } catch (error) {
          ElMessage.error('Failed to fetch courses');
        } finally {
          this.loading = false;
        }
      }
    }
  }
</script>