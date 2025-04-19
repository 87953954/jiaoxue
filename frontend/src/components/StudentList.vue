<template>
  <div>
    <h2>Student List</h2>
    <el-table :data="students" style="width: 100%">
      <el-table-column prop="studentNo" label="Student No" width="180" />
      <el-table-column prop="name" label="Name" width="180" />
      <el-table-column prop="classNo" label="Class No" />
    </el-table>
  </div>
</template>

<script>
import axios from 'axios';
import { ElTable, ElTableColumn } from 'element-plus';

export default {
  components: {
    ElTable,
    ElTableColumn,
  },
  data() {
    return {
      students: [],
    };
  },
  mounted() {
    axios.get('/api/students')
      .then(response => {
        this.students = response.data;
      })
      .catch(error => {
        console.error('Error fetching students:', error);
      });
  },
};
</script>