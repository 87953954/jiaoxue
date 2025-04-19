<template>
  <div>
    <h2>教师列表</h2>
    <el-table :data="teachers" style="width: 100%" v-loading="loading">
      <el-table-column prop="name" label="姓名" />
      <el-table-column prop="teacherNo" label="教师编号"  />
    </el-table>
  </div>
</template>

<script>
import axios from 'axios';
import { ElMessage } from 'element-plus';
export default {
  name: 'TeacherList',
  data() {
    return {
      teachers: [],
      loading: true,
    };
  },
  mounted() {
    this.fetchTeachers();
  },
  methods: {
    async fetchTeachers() {
      try {
        const response = await axios.get('/api/teachers');
        if(response.data.code == 200){
                    this.teachers = response.data.data;
        } else{
          ElMessage.error("get data error");
        }
      } catch (error) {
        ElMessage.error('Failed to fetch teachers');
      } finally {
        this.loading = false;
      }
    },
  },
};
</script>