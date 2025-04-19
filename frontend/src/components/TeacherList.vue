<template>
  <div>
    <h2>教师列表</h2>
    <el-table :data="teachers" style="width: 100%">
      <el-table-column prop="id" label="ID" width="180" />
      <el-table-column prop="name" label="姓名" width="180" />
      <el-table-column prop="teacherNo" label="教师编号" />
    </el-table>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'TeacherList',
  data() {
    return {
      teachers: [],
    };
  },
  mounted() {
    this.fetchTeachers();
  },
  methods: {
    fetchTeachers() {
      axios.get('/api/teachers')
        .then(response => {
          this.teachers = response.data;
        })
        .catch(error => {
          console.error('Error fetching teachers:', error);
        });
    },
  },
};
</script>