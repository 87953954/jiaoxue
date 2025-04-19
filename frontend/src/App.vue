<template>
  <div id="app">
    <header>
      <el-menu mode="horizontal">
        <el-menu-item index="/">
          <router-link to="/">Home</router-link>
        </el-menu-item>
        <el-menu-item index="/teachers">
          <router-link to="/teachers">Teacher</router-link>
        </el-menu-item>
        <el-menu-item index="/students">
          <router-link to="/students">Student</router-link>
        </el-menu-item>
        <el-menu-item index="/courses">
          <router-link to="/courses">Course</router-link>
        </el-menu-item>
        <el-menu-item index="/announcements">
          <router-link to="/announcements">Announcement</router-link>
        </el-menu-item>
      </el-menu>
    </header>
    <main>
      <router-view/>
    </main>
    <footer>
      <p>&copy; 2024 教学管理系统</p>
    </footer>
  </div>
</template>
<script setup>
import { RouterLink } from 'vue-router';
</script>
<style scoped>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  color: #2c3e50;
}
header {
  background-color: #f0f0f0;
  padding: 20px;
  margin-bottom: 20px;
}

footer {
  background-color: #f0f0f0;
  padding: 10px;
  margin-top: 20px;
}

.el-menu-item a{
  text-decoration: none;
}
</style>