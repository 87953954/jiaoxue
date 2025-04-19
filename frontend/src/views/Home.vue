<template>
  <div class="home">
    <h1>教学管理系统</h1>
    <el-button type="primary" @click="goToTeachers">教师列表</el-button>
    <el-button type="primary" @click="goToStudents">学生列表</el-button>
    <el-button type="primary" @click="goToCourses">课程列表</el-button>
    <el-button type="primary" @click="goToAnnouncements">公告列表</el-button>
  </div>
</template>

<script>
import { ElButton } from 'element-plus';

export default {
  name: 'Home',
  components: {
    ElButton
  },
  methods: {
    goToTeachers() {
      this.$router.push('/teachers');
    },
    goToStudents() {
      this.$router.push('/students');
    },
    goToCourses() {
      this.$router.push('/courses');
    },
    goToAnnouncements() {
      this.$router.push('/announcements');
    }
  }
};
</script>

<style scoped>
.home {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100vh;
}

.home h1 {
  margin-bottom: 20px;
}

.el-button {
  margin: 10px;
}
</style>