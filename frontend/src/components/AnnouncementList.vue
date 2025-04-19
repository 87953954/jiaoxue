<template>
  <div>
    <h2>公告列表</h2>
    <el-table :data="announcements" style="width: 100%">
      <el-table-column prop="id" label="ID" width="180" />
      <el-table-column prop="content" label="内容" />
      <el-table-column prop="publishTime" label="发布时间" />
      <el-table-column prop="classNo" label="班级" />
    </el-table>
  </div>
</template>

<script>
import axios from 'axios';
import { ElTable, ElTableColumn } from 'element-plus';

export default {
  name: 'AnnouncementList',
  components: {
    ElTable,
    ElTableColumn,
  },
  data() {
    return {
      announcements: [],
    };
  },
  mounted() {
    this.fetchAnnouncements();
  },
  methods: {
    async fetchAnnouncements() {
      try {
        const response = await axios.get('/api/announcements');
        this.announcements = response.data;
      } catch (error) {
        console.error('获取公告列表失败', error);
      }
    },
  },
};
</script>