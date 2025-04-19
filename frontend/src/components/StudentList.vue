<template>
  <div>
    <h2>Student List</h2>
    <el-table :data="students" style="width: 100%" v-loading="loading">
      <el-table-column prop="name" label="Name" />
      <el-table-column prop="studentNo" label="Student No" />
    </el-table>
  </div>
</template>

<script>
import axios from 'axios';
import { ElMessage } from 'element-plus';

export default {
  name: 'StudentList',
  data() {
    return {
      students: [],
      loading: true,
    };
  },
  mounted() {
    this.fetchStudents();
  },
  methods: {
    async fetchStudents() {
      try {
        const response = await axios.get('/api/students');
        if(response.data.code == 200){
            this.students = response.data.data;
        }else {
          ElMessage.error('Failed to fetch students')
        }
      } catch (error) {
        ElMessage.error('Failed to fetch students');
      } finally {
        this.loading = false;
      }
    },
  },
};
</script>